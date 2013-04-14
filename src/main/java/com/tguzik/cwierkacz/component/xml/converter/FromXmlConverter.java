package com.tguzik.cwierkacz.component.xml.converter;

import static com.tguzik.cwierkacz.utils.CollectionUtil.safe;

import com.google.common.base.Function;
import com.tguzik.cwierkacz.common.data.RequestData;
import com.tguzik.cwierkacz.common.data.RequestDataBuilder;
import com.tguzik.cwierkacz.common.data.RequestedAccount;
import com.tguzik.cwierkacz.common.data.RequestedAccountBuilder;
import com.tguzik.cwierkacz.common.data.RequestedJob;
import com.tguzik.cwierkacz.common.data.RequestedJobBuilder;
import com.tguzik.cwierkacz.common.data.diagnostics.Diagnostic;
import com.tguzik.cwierkacz.common.data.value.UserMessage;
import com.tguzik.cwierkacz.component.xml.beans.XmlAccount;
import com.tguzik.cwierkacz.component.xml.beans.XmlJob;
import com.tguzik.cwierkacz.component.xml.beans.XmlRequest;
import com.tguzik.cwierkacz.component.xml.beans.XmlTweet;

class FromXmlConverter implements Function<XmlRequest, RequestData>
{
    @Override
    public RequestData apply( XmlRequest xmlRequest ) {
        RequestDataBuilder builder = RequestData.builder();

        builder.withCustomerId(xmlRequest.getCustomerId());

        for ( XmlJob job : safe(xmlRequest.getJobs()) ) {
            builder.withRequestedJob(fromXmlJob(job));
        }

        for ( Integer value : safe(xmlRequest.getRequestedDiagnostics()) ) {
            builder.withDiagnostic(Diagnostic.from(value));
        }

        return builder.build();
    }

    private RequestedJob fromXmlJob( XmlJob job ) {
        RequestedJobBuilder builder = RequestedJob.builder();

        builder.withName(job.getName());

        for ( XmlAccount xmlAccount : safe(job.getAccounts()) ) {
            builder.withTwitterAccount(fromXmlAccount(xmlAccount));
        }

        return builder.build();
    }

    private RequestedAccount fromXmlAccount( XmlAccount xmlAccount ) {
        RequestedAccountBuilder builder = RequestedAccount.builder();

        builder.withName(xmlAccount.getName());

        for ( XmlTweet tweet : safe(xmlAccount.getTweets()) ) {
            builder.withUserMessage(UserMessage.create(tweet.getContent()));
        }

        return builder.build();
    }
}
