package com.tguzik.cwierkacz.application.initialization;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.processing.postprocessor.artifacts.ArtifactsProcessor;
import com.tguzik.cwierkacz.processing.postprocessor.email.EmailNotificationProcessor;
import com.tguzik.cwierkacz.processing.postprocessor.history.HistoryProcessor;
import com.tguzik.cwierkacz.processing.preprocessor.credentials.CredentialsValidationProcessor;
import com.tguzik.cwierkacz.processing.processor.account.AccountCreatorProcessor;
import com.tguzik.cwierkacz.processing.processor.account.AccountDeletionProcessor;
import com.tguzik.cwierkacz.processing.processor.account.AccountModificationProcessor;
import com.tguzik.cwierkacz.processing.processor.twitter.FetcherProcessor;
import com.tguzik.cwierkacz.processing.processor.twitter.PosterProcessor;

public class ProcessorFactory
{
    private final DataAccessor dataAccessor;

    public ProcessorFactory( DataAccessor dataAccessor ) {
        this.dataAccessor = dataAccessor;
    }

    public Processor getInstance( Class<Processor> clazz, ImmutableMap<String, String> properties ) {
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
            return new FetcherProcessor(dataAccessor, properties);
        }
        if ( eq(clazz, PosterProcessor.class) ) {
            return new PosterProcessor(dataAccessor, properties);
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
