package com.classic.vullks.casinoslots.api.requests.product;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("product")
	private String product;

	public String getProduct(){
		return product;
	}
}