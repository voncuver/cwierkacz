package com.tguzik.cwierkacz.component.xml.converter;

import com.google.common.base.Function;
import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.component.xml.beans.XmlResponse;

class ToXmlConverter implements Function<ApplicationProcessingData, XmlResponse>
{
    @Override
    public XmlResponse apply( ApplicationProcessingData input ) {
        throw new UnsupportedOperationException("NYI");
    }
}
