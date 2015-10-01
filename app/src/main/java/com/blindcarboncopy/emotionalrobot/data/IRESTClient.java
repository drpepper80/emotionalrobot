package com.blindcarboncopy.emotionalrobot.data;

import com.blindcarboncopy.emotionalrobot.model.cloudant.ids.CloudantIDPackage;
import com.blindcarboncopy.emotionalrobot.model.cloudant.messages.CloudantMessagePackage;
import com.blindcarboncopy.emotionalrobot.model.nodered.NodeRedMessage;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by DrPepper80 on 01/10/2015.
 */
public interface IRESTClient {

    @GET("/feedme/_all_docs?include_docs=true")
    Call<CloudantMessagePackage> getAllMessages();

    @GET("/feedme/_all_docs")
    Call<CloudantIDPackage> getAllMessageIDs();

    @GET("/feedme/{msgId}")
    Call<NodeRedMessage> getMessageByID(@Path("id") String id);
}
