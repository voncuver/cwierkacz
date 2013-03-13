package com.tguzik.cwierkacz.configuration.reader;

import java.io.File;

import com.tguzik.cwierkacz.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.configuration.DatabaseConfiguration;
import com.tguzik.cwierkacz.configuration.JobsConfiguration;
import com.tguzik.cwierkacz.configuration.ProcessorsConfiguration;
import com.tguzik.cwierkacz.configuration.SingleJobConfiguration;
import com.tguzik.cwierkacz.configuration.SingleProcessorConfiguration;
import com.tguzik.cwierkacz.configuration.TableCacheConfiguration;
import com.tguzik.cwierkacz.configuration.XmlServerConfiguration;
import com.tguzik.cwierkacz.utils.annotation.Threadsafe;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.converters.basic.ShortConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.converters.extended.JavaClassConverter;
import com.thoughtworks.xstream.mapper.DefaultMapper;

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

    private XStream constructParser( ) {
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(false);

        bindMainConfiguration(xstream);
        bindDatabaseConfiguration(xstream);
        bindJobsConfiguration(xstream);
        bindProcessorsConfiguration(xstream);
        bindXmlServerConfiguration(xstream);

        return xstream;
    }

    private void bindMainConfiguration( XStream xstream ) {
        xstream.alias("cwierkacz-configuration", CwierkaczConfiguration.class);
        xstream.aliasField("database-configuration", CwierkaczConfiguration.class, "databaseConfiguration");
        xstream.aliasField("jobs-configuration", CwierkaczConfiguration.class, "jobsConfiguration");
        xstream.aliasField("processors-configuration", CwierkaczConfiguration.class, "processorsConfiguration");
        xstream.aliasField("xml-server-configuration", CwierkaczConfiguration.class, "xmlServerConfiguration");
    }

    private void bindDatabaseConfiguration( XStream xstream ) {
        xstream.alias("database-configuration", DatabaseConfiguration.class);
        xstream.aliasType("table", TableCacheConfiguration.class);
        xstream.registerLocalConverter(DatabaseConfiguration.class, "url", new StringConverter());
    }

    private void bindJobsConfiguration( XStream xstream ) {
        final Class<SingleJobConfiguration> sjc = SingleJobConfiguration.class;
        final Class<JobsConfiguration> jc = JobsConfiguration.class;

        xstream.alias("jobs-configuration", jc);
        xstream.addImplicitCollection(jc, "jobs", "job", sjc);
        xstream.alias("job", sjc);
        xstream.aliasField("lifecycle", sjc, "lifecycleStageNames");
        xstream.aliasType("stage", String.class);
    }

    private void bindProcessorsConfiguration( XStream xstream ) {
        final Class<SingleProcessorConfiguration> spc = SingleProcessorConfiguration.class;
        final Class<ProcessorsConfiguration> pc = ProcessorsConfiguration.class;
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        xstream.alias("processors-configration", pc);
        xstream.addImplicitCollection(pc, "processors", "processor", spc);
        xstream.alias("processor", spc);
        xstream.aliasField("class", spc, "clazz");
        xstream.registerLocalConverter(spc, "clazz", new JavaClassConverter(cl));
        xstream.registerLocalConverter(spc, "properties", new MapConverter(new DefaultMapper(cl)));
    }

    private void bindXmlServerConfiguration( XStream xstream ) {
        xstream.alias("xml-server-configuration", XmlServerConfiguration.class);
        xstream.registerLocalConverter(XmlServerConfiguration.class, "portNumber", new ShortConverter());
        xstream.registerLocalConverter(XmlServerConfiguration.class, "xmlValidation", new BooleanConverter());
    }
}
