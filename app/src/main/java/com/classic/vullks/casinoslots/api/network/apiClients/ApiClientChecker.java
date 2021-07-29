package com.classic.vullks.casinoslots.api.network.apiClients;

import com.classic.vullks.casinoslots.api.network.apiServise.ApiServiceChecker;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientChecker {
    private static ApiClientChecker mInstance;
    private static final String BASE_URL = "http://luckysevens.fun/content/";
    private final Retrofit mRetrofit;

    private static class UserAgentInterceptor implements Interceptor {

        private final String userAgent;

        public UserAgentInterceptor(String userAgent) {
            this.userAgent = userAgent;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request requestWithUserAgent = originalRequest.newBuilder()
                    .header("User-Agent", userAgent)
                    .build();
            return chain.proceed(requestWithUserAgent);
        }
    }

    private ApiClientChecker(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new UserAgentInterceptor(System.getProperty("http.agent")));

        OkHttpClient client = httpClient.build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public static ApiClientChecker getInstance(){
        if(mInstance == null){
            mInstance = new ApiClientChecker();
        }
        return mInstance;
    }

    public ApiServiceChecker getApiServiceChecker(){
        return mRetrofit.create(ApiServiceChecker.class);
    }


}
