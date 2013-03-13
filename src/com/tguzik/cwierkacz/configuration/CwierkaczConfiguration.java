package com.tguzik.cwierkacz.configuration;

import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class CwierkaczConfiguration extends StandardElement
{
    private DatabaseConfiguration databaseConfiguration;
    private JobsConfiguration jobsConfiguration;
    private ProcessorsConfiguration processorsConfiguration;
    private XmlServerConfiguration xmlServerConfiguration;

    public DatabaseConfiguration getDatabaseConfiguration( ) {
        return databaseConfiguration;
    }

    public JobsConfiguration getJobsConfiguration( ) {
        return jobsConfiguration;
    }

    public ProcessorsConfiguration getProcessorsConfiguration( ) {
        return processorsConfiguration;
    }

    public XmlServerConfiguration getXmlServerConfiguration( ) {
        return xmlServerConfiguration;
    }
}
