package com.blindcarboncopy.emotionalrobot.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.Path;

/**
 * Created by chris on 01/10/2015.
 */


public class RESTClient implements IRESTClient {

        private Gson gson = new GsonBuilder().create();
        private static final String BASE_URL = "https://b38bff61-03fc-445c-86ca-9b9f91b43eaf-" +
                "                               bluemix.cloudant.com/feedme/";
        private Retrofit retrofit  = new Retrofit.Builder()
                                                .baseUrl(BASE_URL)
                                                .addConverterFactory(GsonConverterFactory.create())
                                                .build();



        @Override
        public void getAllMessageIDs() {

        }

        @Override
        public void getMessageByID(@Path("id") String id) {

        }
}
