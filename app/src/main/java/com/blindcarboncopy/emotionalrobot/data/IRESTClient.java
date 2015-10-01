package com.blindcarboncopy.emotionalrobot.data;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by chris on 01/10/2015.
 */
public interface IRESTClient {

    @GET("/feedme/_all_docs?include_docs=true")
    void getAllMessages();

    @GET("/feedme/_all_docs")
    void getAllMessageIDs();

    @GET("/feedme/{msgId}")
    void getMessageByID(@Path("id") String id);
}
