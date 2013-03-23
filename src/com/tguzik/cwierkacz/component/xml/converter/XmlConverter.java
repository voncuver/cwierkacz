package com.tguzik.cwierkacz.component.xml.converter;

import com.google.common.base.Function;
import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.common.data.RequestData;
import com.tguzik.cwierkacz.component.xml.beans.XmlRequest;
import com.tguzik.cwierkacz.component.xml.beans.XmlResponse;

public class XmlConverter
{
    private final Function<ApplicationProcessingData, XmlResponse> toXmlConverter;
    private final Function<XmlRequest, RequestData> fromXmlConverter;

    public XmlConverter() {
        this.fromXmlConverter = new FromXmlConverter();
        this.toXmlConverter = new ToXmlConverter();
    }

    public RequestData fromXml( XmlRequest xmlRequest ) {
        return fromXmlConverter.apply(xmlRequest);
    }

    public XmlResponse toXml( ApplicationProcessingData data ) {
        return toXmlConverter.apply(data);
    }
}
