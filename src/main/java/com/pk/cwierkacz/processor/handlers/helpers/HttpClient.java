package com.pk.cwierkacz.processor.handlers.helpers;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpClient
{

    public final Map<String, String> connectionHeaders = new HashMap<String, String>();
    public static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");
    private final StringBuffer cookie = new StringBuffer(512);
    public String lastLocation = "";

    public final HttpURLConnection getUrlConnection( final String url, final boolean post, final String output ) throws IOException {
        int retries = 0;
        HttpURLConnection conn;
        while ( true ) {
            try {
                final URL urlObj = new URL(url);
                conn = (HttpURLConnection) urlObj.openConnection();
                conn.setConnectTimeout(30 * 1000);
                conn.setReadTimeout(5 * 60 * 1000);
                if ( post ) {
                    conn.setRequestMethod("POST");
                }
                final String referer;
                final int pathIdx;
                if ( ( pathIdx = url.lastIndexOf('/') ) > "https://".length() ) {
                    referer = url.substring(0, pathIdx);
                }
                else {
                    referer = url;
                }
                conn.setRequestProperty("Referer", referer);
                final Set<String> keys = this.connectionHeaders.keySet();
                for ( final String k : keys ) {
                    final String value = this.connectionHeaders.get(k);
                    if ( value != null ) {
                        conn.setRequestProperty(k, value);
                    }
                }
                conn.setUseCaches(false);
                if ( output != null ) {
                    conn.setDoOutput(true);
                    final BufferedOutputStream out = new BufferedOutputStream(conn.getOutputStream());
                    out.write(output.getBytes(CHARSET_UTF8));
                    out.close();
                }
                if ( appendCookies(this.cookie, conn) ) {
                    putConnectionHeader("Cookie", this.cookie.toString());
                }
                break;
            }
            catch ( final Throwable e ) {
                e.printStackTrace();
                if ( retries++ > 20 ) {
                    throw new IOException(e);
                }
                else {
                    try {
                        Thread.sleep(( 60 * retries * 100 ) + ( (int) Math.random() * 100 * 60 * retries ));
                    }
                    catch ( final InterruptedException e1 ) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        return conn;
    }

    public final boolean appendCookies( final StringBuffer cookie, final HttpURLConnection conn ) throws IOException {
        try {
            boolean changed = false;
            final Map<String, List<String>> headerFields = conn.getHeaderFields();
            this.lastLocation = conn.getHeaderField("Location");
            if ( this.lastLocation == null ) {
                this.lastLocation = "";
            }
            final List<String> values = headerFields.get("Set-Cookie");
            if ( values != null ) {
                for ( final String v : values ) {
                    if ( v.indexOf("deleted") == -1 ) {
                        if ( cookie.length() > 0 ) {
                            cookie.append("; ");
                        }
                        cookie.append(v.split(";")[ 0 ]);
                        changed = true;
                    }
                }
            }
            return changed;
        }
        catch ( final Throwable e ) {
            throw new IOException(e);
        }
    }

    public final void putConnectionHeader( final String key, final String value ) {
        this.connectionHeaders.put(key, value);
    }

}
