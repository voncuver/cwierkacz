package com.tguzik.cwierkacz.common.data.artifacts;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.cache.dataobject.FunctionalAccount;
import com.tguzik.cwierkacz.utils.annotation.Threadsafe;

@Threadsafe
public final class ArtifactsHistory
{
    private final ConcurrentLinkedQueue<ArtifactEntry> entries;

    private ArtifactsHistory() {
        this.entries = new ConcurrentLinkedQueue<>();
    }

    public void add( ArtifactEntry entry ) {
        this.entries.add(entry);
    }

    public void add( FunctionalAccount account, ArtifactType type, String value ) {
        ArtifactEntry entry = ArtifactEntry.create(account, type, value);
        this.entries.add(entry);
    }

    public void add( FunctionalAccount account, ArtifactType type, Object value ) {
        add(account, type, String.valueOf(value));
    }

    public void add( ArtifactType type, Object value ) {
        add(null, type, String.valueOf(value));
    }

    public ImmutableList<ArtifactEntry> getEntries( ) {
        return ImmutableList.copyOf(entries);
    }

    public static ArtifactsHistory create( ) {
        return new ArtifactsHistory();
    }
}
