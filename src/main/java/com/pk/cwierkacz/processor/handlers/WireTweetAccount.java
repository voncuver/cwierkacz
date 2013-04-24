package com.pk.cwierkacz.processor.handlers;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.AddTweeAccRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.UserService;
import com.pk.cwierkacz.twitter.OAuthAuthentication;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class WireTweetAccount implements Handler
{

    private final UserService userService;

    public WireTweetAccount() {
        userService = ServiceRepo.getInstance().getService(UserService.class);
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.ADDTWEETACCOUNT);
    }

    Map<Long, OAuthAuthentication> map = new HashMap<>();

    @Override
    public void handle( ApplicationData appData ) {
        AddTweeAccRequest accRequest = (AddTweeAccRequest) appData.getRequest();

        UserDao user = userService.getByUserName(accRequest.getFunctionalUserName());
        if ( user != null && user.getSession().getCurrentToken() != accRequest.getTokenId() ) {
            Response response = ResponseImpl.create(Status.DENY, "Invalid Token", accRequest.getTokenId());
            appData.setResponse(response);
            return;
        }
        List<String> accountsName = new ArrayList<>();
        for ( TwitterAccountDao accountDao : user.getAccounts() ) {
            accountsName.add(accountDao.getAccountName());
        }

        if ( accountsName.contains(accRequest.getAccountTweet()) ) {
            Response response = ResponseImpl.create(Status.DENY,
                                                    "User already has this accout",
                                                    accRequest.getTokenId());
            appData.setResponse(response);
            return;
        }

        TwitterAccountDao account = TwitterAccountDao.create(0,
                                                             user,
                                                             accRequest.getAccountTweet(),
                                                             null,
                                                             null);
        account.setId(1l);
        OAuthAuthentication userAuthentication = null;
        if ( map.containsKey(accRequest.getTokenId()) ) {
            userAuthentication = map.get(accRequest.getTokenId());
        }
        else {
            userAuthentication = new OAuthAuthentication(account);
            map.put(accRequest.getTokenId(), userAuthentication);
        }

        try {
            //String sessionUrl = "authenticity_token=%s&oauth_token=%s&username_or_email=%s&password=%s";

            if ( accRequest.getPin() == null ) {

                String url = userAuthentication.getAuthenticationURL();
                Response response = ResponseImpl.create(Status.OK, url, accRequest.getTokenId());
                appData.setResponse(response);
                return;
            }
            else {

                Long pin = accRequest.getPin();
                account = userAuthentication.authenticate(pin.toString(), true);
            }

            //            
            //            String authUrl = "https://api.twitter.com/oauth/authorize";
            //
            //            BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(getUrlConnection(url,
            //                                                                                                                      false,
            //                                                                                                                      null).getInputStream()),
            //                                                                             "UTF-8"));
            //            String token = extractToken(reader);
            //            String outhToken = url.split("=")[ 1 ];
            //            String postData = String.format(sessionUrl,
            //                                            token,
            //                                            outhToken,
            //                                            accRequest.getAccountTweet(),
            //                                            accRequest.getPassTweet());
            //            authUrl = authUrl + "?" + postData;
            //            reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(getUrlConnection(authUrl,
            //                                                                                                       true,
            //                                                                                                       null).getInputStream()),
            //                                                              "UTF-8"));
            //            String line;
            //            StringBuilder stringBuilder = new StringBuilder();
            //            while ( null != ( line = reader.readLine() ) ) {
            //                stringBuilder.append(line);
            //            }
            //            reader.close();

        }
        catch ( TwitterAuthenticationException e ) {
            Response response = ResponseImpl.create(Status.ERROR, e.getMessage(), accRequest.getTokenId());
            appData.setResponse(response);
            return;
        }
        user.getAccounts().add(account);
        userService.saveOrUpdate(user);

        Response response = ResponseImpl.create(Status.OK,
                                                "Account succesfully wired",
                                                accRequest.getTokenId());
        appData.setResponse(response);
        return;
    }

    private String extractToken( BufferedReader reader ) throws IOException {
        StringBuilder res = new StringBuilder();
        String line = "";
        while ( ( line = reader.readLine() ) != null ) {
            res.append(line);
            if ( line.contains("authenticity_token") ) {
                String[] splited = line.split("\\s");
                for ( String part : splited ) {
                    if ( part.contains("value") ) {
                        return part.split("\"")[ 1 ];

                    }
                }
                break;
            }
        }
        return null;
    }

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
