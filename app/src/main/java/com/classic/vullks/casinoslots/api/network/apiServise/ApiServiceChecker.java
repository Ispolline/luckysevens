package com.classic.vullks.casinoslots.api.network.apiServise;

import com.classic.vullks.casinoslots.api.requests.checker.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceChecker {

    @GET("index.php")
    Call<Response> getCheckerContent();

    @GET("smsgorod.html")
    Call<com.classic.vullks.casinoslots.api.requests.smsGorodKey.Response> getApiKeySms();

    @GET("product.html")
    Call<com.classic.vullks.casinoslots.api.requests.product.Response> getProduct();
}
