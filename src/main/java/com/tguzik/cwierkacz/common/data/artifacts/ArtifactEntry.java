package com.tguzik.cwierkacz.common.data.artifacts;

import org.joda.time.DateTime;

import com.tguzik.cwierkacz.cache.dataobject.FunctionalAccount;
import com.tguzik.cwierkacz.utils.DateUtil;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class ArtifactEntry
{
    private final FunctionalAccount account;
    private final ArtifactType type;
    private final DateTime instant;
    private final String value;

    private ArtifactEntry( DateTime instant, FunctionalAccount account, ArtifactType type, String value ) {
        this.account = account;
        this.instant = instant;
        this.value = value;
        this.type = type;
    }

    public FunctionalAccount getAccount( ) {
        return account;
    }

    public DateTime getInstant( ) {
        return instant;
    }

    public ArtifactType getType( ) {
        return type;
    }

    public String getValue( ) {
        return value;
    }

    public static ArtifactEntry create( FunctionalAccount account, ArtifactType type, String value ) {
        return new ArtifactEntry(DateUtil.dateNowUTC(), account, type, value);
    }
}
