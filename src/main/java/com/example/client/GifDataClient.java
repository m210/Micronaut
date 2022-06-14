package com.example.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("${gif-data-client.url}")
public interface GifDataClient {

	@Get("/{id}/giphy.gif")
	byte[] getGifData(String id);
	
}
