package com.tguzik.cwierkacz.component.xml.beans;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.utils.annotation.SingleThreaded;

@SingleThreaded
public class XmlRequest extends StandardElement
{
    private final List<XmlJob> jobs;
    private final Set<Integer> requestedDiagnostics;
    private XmlCustomer customer;

    public XmlRequest() {
        this.requestedDiagnostics = Sets.newHashSet();
        this.jobs = Lists.newArrayList();
    }

    public XmlCustomer getCustomer( ) {
        return customer;
    }

    public void setCustomer( XmlCustomer customer ) {
        this.customer = customer;
    }

    public List<XmlJob> getJobs( ) {
        return jobs;
    }

    public void addJob( XmlJob job ) {
        jobs.add(job);
    }

    public Set<Integer> getRequestedDiagnostics( ) {
        return requestedDiagnostics;
    }

    public void addRequestedDiagnostics( Integer diagnosticNumber ) {
        this.requestedDiagnostics.add(diagnosticNumber);
    }
}
