package com.tguzik.cwierkacz.server.initialization.task;

import java.util.concurrent.Future;

import com.tguzik.cwierkacz.server.configuration.ApplicationConfiguration;
import com.tguzik.cwierkacz.server.configuration.reader.ConfigurationReader;
import com.tguzik.cwierkacz.server.initialization.InitializationState;

public final class InitConfiguration implements InitializationTask<ApplicationConfiguration>
{
    private final Future<InitializationState> futureState;

    public InitConfiguration( Future<InitializationState> futureState ) {
        this.futureState = futureState;
    }

    @Override
    public ApplicationConfiguration call( ) throws Exception {
        String configurationDirectory = futureState.get().getConfigurationDirectory();
        ConfigurationReader reader = new ConfigurationReader(configurationDirectory);

        return reader.read();
    }

    @Override
    public String getName( ) {
        return "Configuration";
    }
}
