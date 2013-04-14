package com.tguzik.cwierkacz.common.processing;

import static com.tguzik.cwierkacz.utils.CollectionUtil.safe;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.cache.dataobject.Customer;
import com.tguzik.cwierkacz.cache.dataobject.FunctionalAccount;
import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.common.data.ApplicationProcessingDataBuilder;
import com.tguzik.cwierkacz.common.data.RequestData;
import com.tguzik.cwierkacz.common.data.RequestedAccount;
import com.tguzik.cwierkacz.common.data.RequestedJob;
import com.tguzik.cwierkacz.common.data.value.FunctionalAccountName;
import com.tguzik.cwierkacz.server.ApplicationContext;
import com.tguzik.cwierkacz.server.interfaces.ProtocolWorker;
import com.tguzik.cwierkacz.server.interfaces.socket.SocketWorker;

public class MasterProcessor implements Runnable
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MasterProcessor.class);
    private final ProtocolWorker protocolWorker;
    private final ApplicationContext context;
    private final SocketWorker socketWorker;

    private MasterProcessor( ApplicationContext context, SocketWorker socket, ProtocolWorker protocol ) {
        this.protocolWorker = protocol;
        this.socketWorker = socket;
        this.context = context;
    }

    @Override
    public void run( ) {
        LOGGER.info("[{}] Interacting with {}",
                    socketWorker.getOriginInterface(),
                    socketWorker.getRemoteAddress());

        try {
            initialize();

            String request = socketWorker.getRequest();

            if ( StringUtils.isBlank(request) ) {
                sendResponse(protocolWorker.produceEmptyRequestResponse());
                return;
            }

            ApplicationProcessingData data = createProcessingData(request);

            process(data);

            sendResponse(protocolWorker.createResponse(data));

            postProcessing();
        }
        catch ( Exception e ) {
            LOGGER.error("Exception caught while processing", e);
            sendResponse(protocolWorker.produceErrorResponse(e));
        }
        finally {
            shutdown();
            LOGGER.info("[{}] Finished interacting with {}",
                        socketWorker.getOriginInterface(),
                        socketWorker.getRemoteAddress());
        }
    }

    private ApplicationProcessingData createProcessingData( String request ) throws Exception {
        ApplicationProcessingDataBuilder builder = ApplicationProcessingData.builder();
        RequestData requestData = protocolWorker.createRequestData(request);

        builder.withRequestData(requestData);

        if ( !requestData.getCustomerId().isEmpty() ) {
            Customer customer = getDataAccessor().getCustomer(requestData.getCustomerId());
            builder.withCustomer(customer);
        }

        for ( RequestedJob requestedJob : safe(requestData.getRequestedJobs()) ) {
            for ( RequestedAccount requestedAccount : requestedJob.getTwitterAccounts() ) {
                FunctionalAccountName name = requestedAccount.getName();
                FunctionalAccount account = getDataAccessor().getFunctionalAccount(name);
                builder.withFunctionalAccount(name, account);
            }
        }

        return builder.build();
    }

    private void process( ApplicationProcessingData data ) throws Exception {
        RequestData requestData = data.getRequestData();

        if ( requestData.getRequestedJobs().isEmpty() ) {
            throw new ProcessingException("No jobs were requested.");
        }

        for ( RequestedJob requestedJob : requestData.getRequestedJobs() ) {
            getRequestedJob(requestedJob).getChain().process(data, requestedJob);
        }
    }

    private void postProcessing( ) {
        // TODO Auto-generated method stub
    }

    private Job getRequestedJob( RequestedJob requestedJob ) throws ProcessingException {
        Job job = context.getJobsByName().get(requestedJob.getName());

        if ( job == null ) {
            throw new ProcessingException("Invalid job name");
        }

        return job;
    }

    private void sendResponse( String response ) {
        socketWorker.sendResponse(response);
    }

    public void initialize( ) throws Exception {
        protocolWorker.initialize();
        socketWorker.initialize();
    }

    public void shutdown( ) {
        protocolWorker.shutdown();
        socketWorker.shutdown();
    }

    private DataAccessor getDataAccessor( ) {
        return context.getDataAccessor();
    }

    public static MasterProcessor create( ApplicationContext context,
                                          SocketWorker socket,
                                          ProtocolWorker protocol ) {
        return new MasterProcessor(context, socket, protocol);
    }
}
