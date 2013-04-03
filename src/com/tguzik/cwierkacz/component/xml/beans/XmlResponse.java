package com.tguzik.cwierkacz.component.xml.beans;

import java.util.List;

import com.google.common.collect.Lists;
import com.tguzik.cwierkacz.common.StandardElement;

public class XmlResponse extends StandardElement
{
    private final List<XmlJob> jobs;
    private final StringBuilder diagnostics;
    private int returnCode;
    private Long customerId;

    public XmlResponse() {
        this.diagnostics = new StringBuilder();
        this.jobs = Lists.newArrayList();
    }

    public int getReturnCode( ) {
        return returnCode;
    }

    public void setReturnCode( int returnCode ) {
        this.returnCode = returnCode;
    }

    public Long getCustomerId( ) {
        return customerId;
    }

    public void setCustomerId( Long customerId ) {
        this.customerId = customerId;
    }

    public List<XmlJob> getJobs( ) {
        return jobs;
    }

    public void addJob( XmlJob job ) {
        this.jobs.add(job);
    }

    public String getDiagnostics( ) {
        return diagnostics.toString();
    }

    public void addDiagnostic( String diagnostic ) {
        this.diagnostics.append(diagnostic).append("\n");
    }
}
