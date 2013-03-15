package com.tguzik.cwierkacz.application.configuration.reader;

import java.io.File;

import com.tguzik.cwierkacz.application.configuration.CacheConfiguration;
import com.tguzik.cwierkacz.application.configuration.CacheRegionConfiguration;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.application.configuration.DatabaseConfiguration;
import com.tguzik.cwierkacz.application.configuration.InterfaceConfiguration;
import com.tguzik.cwierkacz.application.configuration.JobsConfiguration;
import com.tguzik.cwierkacz.application.configuration.ProcessorsConfiguration;
import com.tguzik.cwierkacz.application.configuration.SingleInterfaceConfiguration;
import com.tguzik.cwierkacz.application.configuration.SingleJobConfiguration;
import com.tguzik.cwierkacz.application.configuration.SingleProcessorConfiguration;
import com.tguzik.cwierkacz.application.configuration.ThreadPoolConfiguration;
import com.tguzik.cwierkacz.utils.annotation.Threadsafe;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.converters.basic.LongConverter;
import com.thoughtworks.xstream.converters.basic.ShortConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.converters.extended.JavaClassConverter;

@Threadsafe
class XStreamConfigurationParser
{
    @Threadsafe
    private final XStream parser;

    XStreamConfigurationParser() {
        this.parser = constructParser();
    }

    public Object parse( File file, Object root ) {
        return parser.fromXML(file, root);
    }

    public Object parse( String xml, Object root ) {
        return parser.fromXML(xml, root);
    }

    public Object parse( File file ) {
        return parser.fromXML(file);
    }

    public Object parse( String xml ) {
        return parser.fromXML(xml);
    }

    private static XStream constructParser( ) {
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(false);

        bindMainConfiguration(xstream);

        bindCacheConfiguration(xstream);
        bindInterfaceConfiguration(xstream);
        bindDatabaseConfiguration(xstream);
        bindJobsConfiguration(xstream);
        bindProcessorsConfiguration(xstream);
        bindThreadPoolConfiguration(xstream);
        bindXmlServerConfiguration(xstream);

        return xstream;
    }

    private static void bindMainConfiguration( XStream xstream ) {
        xstream.alias("cwierkacz-configuration", CwierkaczConfiguration.class);
        xstream.aliasField("thread-pool-configuration", CwierkaczConfiguration.class, "threadPool");
        xstream.aliasField("interface-configuration", CwierkaczConfiguration.class, "interfaces");
        xstream.aliasField("cache-configuration", CwierkaczConfiguration.class, "cache");
        xstream.aliasField("database-configuration", CwierkaczConfiguration.class, "database");
        xstream.aliasField("jobs-configuration", CwierkaczConfiguration.class, "jobs");
        xstream.aliasField("processors-configuration", CwierkaczConfiguration.class, "processors");
    }

    private static void bindInterfaceConfiguration( XStream xstream ) {
        xstream.alias("interface-configuration", InterfaceConfiguration.class);
        xstream.aliasType("interface", SingleInterfaceConfiguration.class);
        xstream.addImplicitCollection(InterfaceConfiguration.class,
                                      "interfaces",
                                      "interface",
                                      SingleInterfaceConfiguration.class);

        xstream.registerLocalConverter(SingleInterfaceConfiguration.class, "properties", getMapConverter(xstream));
    }

    private static void bindThreadPoolConfiguration( XStream xstream ) {
        xstream.alias("thread-pool-configuration", ThreadPoolConfiguration.class);
        xstream.registerLocalConverter(ThreadPoolConfiguration.class, "keepAliveSeconds", new LongConverter());
    }

    private static void bindCacheConfiguration( XStream xstream ) {
        xstream.alias("cache-configuration", CacheConfiguration.class);
        xstream.aliasType("region", CacheRegionConfiguration.class);
        xstream.addImplicitCollection(CacheConfiguration.class, "regions", "region", CacheRegionConfiguration.class);
    }

    private static void bindDatabaseConfiguration( XStream xstream ) {
        xstream.alias("database-configuration", DatabaseConfiguration.class);
        xstream.registerLocalConverter(DatabaseConfiguration.class, "url", new StringConverter());
    }

    private static void bindJobsConfiguration( XStream xstream ) {
        final Class<SingleJobConfiguration> sjc = SingleJobConfiguration.class;
        final Class<JobsConfiguration> jc = JobsConfiguration.class;

        xstream.alias("jobs-configuration", jc);
        xstream.addImplicitCollection(jc, "jobs", "job", sjc);
        xstream.alias("job", sjc);
        xstream.aliasField("lifecycle", sjc, "lifecycleStageNames");
        xstream.aliasType("stage", String.class);

        xstream.registerLocalConverter(sjc, "properties", getMapConverter(xstream));
    }

    private static void bindProcessorsConfiguration( XStream xstream ) {
        final Class<SingleProcessorConfiguration> spc = SingleProcessorConfiguration.class;
        final Class<ProcessorsConfiguration> pc = ProcessorsConfiguration.class;

        xstream.alias("processors-configration", pc);
        xstream.addImplicitCollection(pc, "processors", "processor", spc);
        xstream.alias("processor", spc);
        xstream.aliasField("class", spc, "clazz");
        xstream.registerLocalConverter(spc, "clazz", new JavaClassConverter(getClassLoader()));
        xstream.registerLocalConverter(spc, "properties", getMapConverter(xstream));
    }

    private static void bindXmlServerConfiguration( XStream xstream ) {
        xstream.alias("xml-server-configuration", InterfaceConfiguration.class);
        xstream.registerLocalConverter(InterfaceConfiguration.class, "portNumber", new ShortConverter());
        xstream.registerLocalConverter(InterfaceConfiguration.class, "xmlValidation", new BooleanConverter());
    }

    private static ClassLoader getClassLoader( ) {
        return ClassLoader.getSystemClassLoader();
    }

    private static MapConverter getMapConverter( XStream xstream ) {
        return new MapConverter(xstream.getMapper());
    }
}
