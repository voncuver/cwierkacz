package com.tguzik.cwierkacz.server.interfaces.xmlserver;

import java.io.InputStream;

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
import com.tguzik.cwierkacz.component.xml.converter.XmlConverter;
import com.tguzik.cwierkacz.component.xml.request.XmlRequestParser;
import com.tguzik.cwierkacz.component.xml.response.XmlResponseBuilder;
import com.tguzik.cwierkacz.server.ApplicationContext;
import com.tguzik.cwierkacz.server.interfaces.ProtocolWorker;

public class XmlServerWorker implements ProtocolWorker
{
    private final XmlResponseBuilder xmlResponseBuilder;
    private final XmlRequestParser xmlRequestParser;
    private final ApplicationContext context;
    private final XmlConverter xmlConverter;
    private final DataAccessor dataAccessor;

    public XmlServerWorker( ApplicationContext context,
                            XmlRequestParser xmlRequestParser,
                            XmlConverter xmlConverter,
                            XmlResponseBuilder xmlResponseBuilder ) {
        this.dataAccessor = context.getDataAccessor();
        this.xmlResponseBuilder = xmlResponseBuilder;
        this.xmlRequestParser = xmlRequestParser;
        this.xmlConverter = xmlConverter;
        this.context = context;
    }

    @Override
    public String apply( InputStream input ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void postprocessing( ) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public String produceErrorResponse( Exception e ) {
        // TODO Auto-generated method stub
        return null;
    }

    protected RequestData createRequestData( InputStream inputStream ) throws Exception {
        XmlRequest xmlRequest = xmlRequestParser.parse(inputStream);
        return xmlConverter.fromXml(xmlRequest);
    }

    /**
     * TODO: FIXME: Move this type of preprocessing to a master processor that
     * would be shared with other interfaces
     */
    protected ApplicationProcessingData preprocessing( RequestData rd ) throws Exception {
        ApplicationProcessingDataBuilder builder = ApplicationProcessingData.builder();

        builder.withRequestData(rd);

        if ( rd.getCustomerId() != null ) {
            CustomerKey customerKey = CustomerKey.create(rd.getCustomerId());
            builder.withCustomer(dataAccessor.getCustomer(customerKey));
        }

        return builder.build();
    }

    protected void process( ApplicationProcessingData data ) throws Exception {
        // TODO: Refactor

        RequestData requestData = data.getRequestData();

        for ( RequestedJob requestedJob : requestData.getRequestedJobs() ) {
            Job job = context.getJobsByName().get(requestedJob.getName());

            job.getChain().process(data, requestedJob);
        }
    }

    protected String createResponse( ApplicationProcessingData data ) throws ParserConfigurationException,
                                                                     FactoryConfigurationError,
                                                                     TransformerException {
        return xmlResponseBuilder.build(xmlConverter.toXml(data));
    }
}
