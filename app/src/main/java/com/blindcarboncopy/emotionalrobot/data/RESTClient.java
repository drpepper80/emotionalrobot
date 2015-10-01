package com.blindcarboncopy.emotionalrobot.data;

import android.util.Log;

import com.blindcarboncopy.emotionalrobot.event.CloudantMessagesEvent;
import com.blindcarboncopy.emotionalrobot.model.cloudant.ids.CloudantIDPackage;
import com.blindcarboncopy.emotionalrobot.model.cloudant.messages.CloudantMessagePackage;
import com.blindcarboncopy.emotionalrobot.model.cloudant.messages.CloudantMessageRecord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;

import de.greenrobot.event.EventBus;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by DrPepper80 on 01/10/2015.
 */


public class RESTClient{

    private Gson gson = new GsonBuilder().create();
    private static final String BASE_URL = "https://b38bff61-03fc-445c-86ca-9b9f91b43eaf-bluemix.cloudant.com/feedme/";
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private IRESTClient irestClient = retrofit.create(IRESTClient.class);

    public RESTClient() {
    }

    public void getAllMessages() {
        Call<CloudantMessagePackage> messageRecord = irestClient.getAllMessages();
        messageRecord.enqueue(new Callback<CloudantMessagePackage>() {
            @Override
            public void onResponse(Response<CloudantMessagePackage> response, Retrofit retrofit) {
                EventBus.getDefault().post(new CloudantMessagesEvent(new ArrayList<CloudantMessageRecord>(Arrays.asList(response.body().getRows()))));
                Log.d("ALLMESSAGES", "Got " + String.valueOf(response.body().getTotal_rows()) + " messages ");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("ALLMESSAGES", "Failed to get all messages", t);
            }
        });
    }


}
