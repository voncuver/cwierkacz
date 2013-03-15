package com.tguzik.cwierkacz.application.initialization.tasks;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.InterfaceConfiguration;
import com.tguzik.cwierkacz.application.configuration.SingleInterfaceConfiguration;
import com.tguzik.cwierkacz.interfaces.xmlserver.XmlServerInterface;

public class InitXmlServerInterface implements InitializationTask<XmlServerInterface>
{
    private final Future<ThreadPoolExecutor> threadPoolFuture;
    private final SingleInterfaceConfiguration configuration;
    private final ApplicationContextBuilder builder;

    public InitXmlServerInterface( InterfaceConfiguration configuration, ApplicationContextBuilder builder,
                                   Future<ThreadPoolExecutor> threadPool ) {
        this.configuration = findWithName(configuration.getInterfaces(), getName());
        this.threadPoolFuture = threadPool;
        this.builder = builder;
    }

    @Override
    public XmlServerInterface call( ) throws Exception {
        ThreadPoolExecutor threadPool = threadPoolFuture.get();
        XmlServerInterface xsi;

        xsi = new XmlServerInterface(threadPool, configuration);

        builder.withInterface(getName(), xsi);
        return xsi;
    }

    @Override
    public String getName( ) {
        return XmlServerInterface.getCanonicalName();
    }

    private static SingleInterfaceConfiguration findWithName( ImmutableList<SingleInterfaceConfiguration> interfaces,
                                                              String name ) {
        for ( SingleInterfaceConfiguration sic : interfaces ) {
            if ( StringUtils.equalsIgnoreCase(name, sic.getName()) ) {
                return sic;
            }
        }

        return null;
    }
}
