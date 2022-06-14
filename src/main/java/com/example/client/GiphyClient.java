package com.example.client;

import com.example.model.GiphyApiResult;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client("${gif-client.url}")
public interface GiphyClient {
	
	@Get("/search")
	GiphyApiResult search(@QueryValue String api_key,
						  @QueryValue String q,
						  @QueryValue int limit);
}
