package com.example.service;

import io.micronaut.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

@Bean
public class UsdToCurrencyIndicatorServiceImpl implements UsdToCurrencyIndicatorService {

    private final GifSearchService gifSearchService;
    private final ExchangeRateService exchangeService;
    private final Logger logger = LoggerFactory.getLogger(UsdToCurrencyIndicatorServiceImpl.class);

    public UsdToCurrencyIndicatorServiceImpl(GifSearchService gifSearchService, ExchangeRateService exchangeService) {
        this.gifSearchService = gifSearchService;
        this.exchangeService = exchangeService;
    }

    @Override
    public byte[] compare(String date, String currency) {
        logger.info("Compare USD with {} on {}", currency.toUpperCase(), date);
        double todayRate = exchangeService.getHistoricalRate(LocalDate.now().toString(), currency);
        double targetRate = exchangeService.getHistoricalRate(date, currency);

        logger.debug("Today rate is {}", todayRate);
        logger.debug("Target rate is {}", targetRate);

        if (todayRate > targetRate) {
            return gifSearchService.findGif("rich");
        }

        return gifSearchService.findGif("broke");
    }

}
