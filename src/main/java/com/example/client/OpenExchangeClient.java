package com.example.client;

import com.example.model.ExchangeApiResult;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client("${exchange-client.url}")
public interface OpenExchangeClient {

    @Get("/historical/{date}.json")
    ExchangeApiResult historical(String date, @QueryValue String app_id, @QueryValue String base);

}
