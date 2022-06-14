package com.example.service;

import com.example.client.OpenExchangeClient;
import com.example.model.ExchangeApiResult;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Value;

@Bean
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final OpenExchangeClient client;

    @Value("${exchange-client.appid}")
    private String appid;

    @Value("${exchange-client.base}")
    private String base;

    public ExchangeRateServiceImpl(OpenExchangeClient client) {
        this.client = client;
    }

    @Override
    public Double getHistoricalRate(String date, String currency) {
    	ExchangeApiResult result = client.historical(date, appid, base);

        return result.getRates().get(currency.toUpperCase());
    }
}
