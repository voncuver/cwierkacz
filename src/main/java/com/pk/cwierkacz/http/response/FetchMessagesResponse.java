package com.pk.cwierkacz.http.response;

import java.util.List;

import com.pk.cwierkacz.http.response.dto.Message;

public interface FetchMessagesResponse extends Response
{
    List<Message> getMessages( );

}
