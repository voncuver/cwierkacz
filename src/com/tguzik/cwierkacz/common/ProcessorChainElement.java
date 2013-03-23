package com.tguzik.cwierkacz.common;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.common.data.RequestedJob;
import com.tguzik.cwierkacz.utils.annotation.IgnoreErrorsFromThisProcessor;
import com.tguzik.cwierkacz.utils.cor.AbstractChainElement;

public class ProcessorChainElement extends AbstractChainElement<ApplicationProcessingData, RequestedJob>
{
    public static final ProcessorChainElement EMPTY = create(null, "EMPTY", NoOperationProcessor.INSTANCE);
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessorChainElement.class);
    private final Processor processor;
    private final boolean rethrowExceptions;

    private ProcessorChainElement( ProcessorChainElement nextInChain, Processor processor, String name ) {
        super(nextInChain, name);
        this.rethrowExceptions = shouldRethrowException(processor);
        this.processor = processor;
    }

    @Override
    protected void processInner( ApplicationProcessingData data, RequestedJob requestedJob ) throws Exception {
        try {
            processor.process(data, requestedJob);
        }
        catch ( Exception e ) {
            LOGGER.error("[{}] Processing error: {}", getName(), e.getMessage(), e);

            if ( !rethrowExceptions ) {
                throw e;
            }
        }
    }

    public static ProcessorChainElement create( ProcessorChainElement nextInChain,
                                                String jobName,
                                                Processor processor ) {
        String elementName = String.format("%s:%s", jobName, processor.getClass().getName());
        return new ProcessorChainElement(nextInChain, processor, elementName);
    }

    private static boolean shouldRethrowException( Processor processor ) {
        try {
            Method method = processor.getClass().getMethod("process",
                                                           ApplicationProcessingData.class,
                                                           RequestedJob.class);
            return method.getAnnotation(IgnoreErrorsFromThisProcessor.class) != null;
        }
        catch ( Exception e ) {
            LOGGER.error("Intialization exception for {}: {}",
                         processor.getClass().getName(),
                         e.getMessage(),
                         e);
        }
        return false;
    }
}
