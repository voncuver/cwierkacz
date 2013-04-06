package com.tguzik.cwierkacz.server.initialization;

import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.processing.traits.Processor;
import com.tguzik.cwierkacz.component.postprocessor.artifacts.ArtifactsProcessor;
import com.tguzik.cwierkacz.component.postprocessor.email.EmailNotificationProcessor;
import com.tguzik.cwierkacz.component.postprocessor.history.HistoryProcessor;
import com.tguzik.cwierkacz.component.preprocessor.credentials.CredentialsValidationProcessor;
import com.tguzik.cwierkacz.component.processor.account.AccountCreatorProcessor;
import com.tguzik.cwierkacz.component.processor.account.AccountDeletionProcessor;
import com.tguzik.cwierkacz.component.processor.account.AccountModificationProcessor;
import com.tguzik.cwierkacz.component.processor.twitter.FetcherProcessor;
import com.tguzik.cwierkacz.component.processor.twitter.PosterProcessor;

public class ProcessorFactory
{
    private final DataAccessor dataAccessor;

    public ProcessorFactory( DataAccessor dataAccessor ) {
        this.dataAccessor = dataAccessor;
    }

    public Processor create( Class<Processor> clazz,
                             ImmutableMap<String, String> properties,
                             ThreadPoolExecutor endpointThreadPool ) {
        if ( eq(clazz, CredentialsValidationProcessor.class) ) {
            return new CredentialsValidationProcessor(dataAccessor, properties);
        }

        if ( eq(clazz, AccountCreatorProcessor.class) ) {
            return new AccountCreatorProcessor(dataAccessor, properties);
        }

        if ( eq(clazz, AccountDeletionProcessor.class) ) {
            return new AccountDeletionProcessor(dataAccessor, properties);
        }

        if ( eq(clazz, AccountModificationProcessor.class) ) {
            return new AccountModificationProcessor(dataAccessor, properties);
        }

        if ( eq(clazz, FetcherProcessor.class) ) {
            return new FetcherProcessor(dataAccessor, properties, endpointThreadPool);
        }
        if ( eq(clazz, PosterProcessor.class) ) {
            return new PosterProcessor(dataAccessor, properties, endpointThreadPool);
        }

        if ( eq(clazz, HistoryProcessor.class) ) {
            return new HistoryProcessor(dataAccessor, properties);
        }

        if ( eq(clazz, ArtifactsProcessor.class) ) {
            return new ArtifactsProcessor(dataAccessor, properties);
        }

        if ( eq(clazz, EmailNotificationProcessor.class) ) {
            return new EmailNotificationProcessor(dataAccessor, properties);
        }

        throw new IllegalArgumentException(String.format("Illegal processor class: %s", clazz));
    }

    private static boolean eq( Class<Processor> clazz, Class<?> processor ) {
        return Objects.equal(clazz, processor);
    }
}
