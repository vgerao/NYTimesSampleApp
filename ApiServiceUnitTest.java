package com.example.nytimesarticleapp.api;

import com.example.nytimesarticleapp.common.Constants;
import com.example.nytimesarticleapp.model.remotedata.services.ApiService;
import com.example.nytimesarticleapp.model.remotedata.services.RequestInterceptor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ApiServiceUnitTest {

   private ApiService apiService;


    @Before
    public void createService() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(Constants.READ_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.addInterceptor(new RequestInterceptor());
        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        apiService = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build()
                .create(ApiService.class);
    }


    @Test
    public void getPopularArticles() {
        try {
            Response response = apiService.loadPopularArticles().execute();
            assertEquals(response.code(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
