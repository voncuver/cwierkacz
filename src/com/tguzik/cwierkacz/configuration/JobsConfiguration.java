package com.tguzik.cwierkacz.configuration;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class JobsConfiguration extends StandardElement
{
    private final List<SingleJobConfiguration> jobs;

    private JobsConfiguration() {
        this.jobs = Lists.newArrayList();
    }

    public ImmutableList<SingleJobConfiguration> getJobs( ) {
        return ImmutableList.copyOf(jobs);
    }

    public SingleJobConfiguration getJob( String name ) {
        for ( SingleJobConfiguration job : jobs ) {
            if ( StringUtils.equalsIgnoreCase(name, job.getName()) ) {
                return job;
            }
        }
        return null;
    }
}
