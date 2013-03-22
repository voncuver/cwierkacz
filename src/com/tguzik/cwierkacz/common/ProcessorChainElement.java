package com.tguzik.cwierkacz.common;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.utils.annotation.IgnoreErrorsFromThisProcessor;
import com.tguzik.cwierkacz.utils.cor.AbstractChainElement;

public class ProcessorChainElement extends AbstractChainElement<ApplicationProcessingData>
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
    protected void processInner( ApplicationProcessingData data ) throws Exception {
        try {
            processor.process(data);
        }
        catch ( Exception e ) {
            LOGGER.error(String.format("[%s] Processing error: %s", getName(), e.getMessage()), e);

            if ( !rethrowExceptions ) {
                throw e;
            }
        }
    }

    public static ProcessorChainElement create( ProcessorChainElement nextInChain, String jobName, Processor processor ) {
        String elementName = String.format("%s:%s", jobName, processor.getClass().getName());
        return new ProcessorChainElement(nextInChain, processor, elementName);
    }

    private static boolean shouldRethrowException( Processor processor ) {
        try {
            Method method = processor.getClass().getMethod("process", ApplicationProcessingData.class);
            return method.getAnnotation(IgnoreErrorsFromThisProcessor.class) != null;
        }
        catch ( Exception e ) {
            LOGGER.error(String.format("Intialization exception for %s", processor.getClass().getName()), e);
        }
        return false;
    }
}
