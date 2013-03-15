package com.tguzik.cwierkacz.application.configuration;

import static com.tguzik.cwierkacz.utils.CollectionUtil.copyToImmutableList;
import static com.tguzik.cwierkacz.utils.CollectionUtil.safe;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class JobsConfiguration extends StandardElement
{
    private List<SingleJobConfiguration> jobs;

    private JobsConfiguration() {
    }

    public ImmutableList<SingleJobConfiguration> getJobs( ) {
        return copyToImmutableList(jobs);
    }

    public SingleJobConfiguration getJob( String name ) {
        for ( SingleJobConfiguration job : safe(jobs) ) {
            if ( StringUtils.equalsIgnoreCase(name, job.getName()) ) {
                return job;
            }
        }
        return null;
    }
}
