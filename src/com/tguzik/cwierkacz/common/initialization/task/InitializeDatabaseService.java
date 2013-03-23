package com.tguzik.cwierkacz.common.initialization.task;

import java.util.concurrent.Future;

import com.tguzik.cwierkacz.common.configuration.reader.ConfigurationReader;
import com.tguzik.cwierkacz.common.initialization.InitializationState;
import com.tguzik.cwierkacz.database.DatabaseService;

public final class InitializeDatabaseService implements InitializationTask<DatabaseService>
{
    private final Future<InitializationState> futureState;

    public InitializeDatabaseService( Future<InitializationState> futureState ) {
        this.futureState = futureState;
    }

    @Override
    public DatabaseService call( ) throws Exception {
        String configurationDirectory = futureState.get().getConfigurationDirectory();
        ConfigurationReader reader = new ConfigurationReader(configurationDirectory);

        return new DatabaseService(reader.getMyBatisSessionFactory());
    }

    @Override
    public String getName( ) {
        return "Initialize MyBatis-based database service";
    }
}
