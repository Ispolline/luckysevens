package com.classic.vullks.casinoslots.api.network.apiClients;

import com.classic.vullks.casinoslots.api.network.apiServise.ApiServiceSmsGorod;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClientSmsGorod {

    private static ApiClientSmsGorod mInstance;
    private static final String BASE_URL = "https://new.smsgorod.ru/apiSms/";
    private final Retrofit mRetrofit;

    private ApiClientSmsGorod(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public static ApiClientSmsGorod getInstance(){
        if(mInstance == null) {
            mInstance = new ApiClientSmsGorod();
        }
        return mInstance;
    }

    public ApiServiceSmsGorod getApiServiceSmsGorod(){
        return mRetrofit.create(ApiServiceSmsGorod.class);
    }


}