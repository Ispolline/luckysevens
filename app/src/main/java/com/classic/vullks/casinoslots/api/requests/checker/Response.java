package com.classic.vullks.casinoslots.api.requests.checker;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("content")
    private int content;

    public int getContent(){
        return content;
    }
}