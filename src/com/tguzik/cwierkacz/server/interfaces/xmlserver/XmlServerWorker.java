package com.tguzik.cwierkacz.server.interfaces.xmlserver;

import java.io.InputStream;
import java.net.Socket;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.cache.dataobject.key.CustomerKey;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.common.data.ApplicationProcessingDataBuilder;
import com.tguzik.cwierkacz.common.data.RequestData;
import com.tguzik.cwierkacz.common.data.RequestedJob;
import com.tguzik.cwierkacz.component.xml.beans.XmlRequest;
import com.tguzik.cwierkacz.component.xml.beans.XmlResponse;
import com.tguzik.cwierkacz.component.xml.converter.XmlConverter;
import com.tguzik.cwierkacz.component.xml.request.XmlRequestParser;
import com.tguzik.cwierkacz.component.xml.response.XmlResponseBuilder;
import com.tguzik.cwierkacz.server.ApplicationContext;
import com.tguzik.cwierkacz.server.interfaces.AbstractSocketInterfaceWorker;

public class XmlServerWorker extends AbstractSocketInterfaceWorker
{
    private final XmlResponseBuilder xmlResponseBuilder;
    private final XmlRequestParser xmlRequestParser;
    private final ApplicationContext context;
    private final XmlConverter xmlConverter;
    private final DataAccessor dataAccessor;

    public XmlServerWorker( String originInterface,
                            ApplicationContext context,
                            XmlRequestParser xmlRequestParser,
                            XmlConverter xmlConverter,
                            XmlResponseBuilder xmlResponseBuilder,
                            Socket clientSocket ) {
        super(clientSocket, originInterface);
        this.xmlResponseBuilder = xmlResponseBuilder;
        this.xmlRequestParser = xmlRequestParser;
        this.xmlConverter = xmlConverter;
        this.context = context;

        this.dataAccessor = context.getDataAccessor();
    }

    @Override
    protected RequestData createRequestData( InputStream inputStream ) throws Exception {
        XmlRequest xmlRequest = xmlRequestParser.parse(inputStream);
        return xmlConverter.fromXml(xmlRequest);
    }

    @Override
    /** TODO: FIXME: Move this type of preprocessing to a master processor that would be shared with other interfaces */
    protected ApplicationProcessingData preprocessing( RequestData rd ) throws Exception {
        ApplicationProcessingDataBuilder builder = ApplicationProcessingData.builder();

        builder.withRequestData(rd);

        if ( !rd.getCustomerName().isEmpty() ) {
            CustomerKey customerKey = CustomerKey.create(rd.getCustomerName().toValue());
            builder.withCustomer(dataAccessor.getCustomer(customerKey));
        }

        return builder.build();
    }

    @Override
    protected void process( ApplicationProcessingData data ) throws Exception {
        // TODO: Refactor

        RequestData requestData = data.getRequestData();

        for ( RequestedJob requestedJob : requestData.getRequestedJobs() ) {
            Job job = context.getJobsByName().get(requestedJob.getName());

            job.getChain().process(data, requestedJob);
        }
    }

    @Override
    protected String createResponse( ApplicationProcessingData data ) throws ParserConfigurationException,
                                                                     FactoryConfigurationError,
                                                                     TransformerException {
        XmlResponse xmlResponse = xmlConverter.toXml(data);
        return xmlResponseBuilder.build(xmlResponse);
    }

    @Override
    protected void postprocessing( ApplicationProcessingData data ) {
        // do nothing.
    }

    @Override
    protected String produceErrorResponse( Exception e ) {
        return String.format("<Error> %s: %s </Error>\n", e.getClass().getName(), e.getMessage());
    }
}
