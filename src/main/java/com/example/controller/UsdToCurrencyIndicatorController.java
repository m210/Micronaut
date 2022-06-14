package com.example.controller;

import com.example.service.UsdToCurrencyIndicatorService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.time.LocalDate;

@Controller("/indicator")
public class UsdToCurrencyIndicatorController {

    private final UsdToCurrencyIndicatorService service;

    public UsdToCurrencyIndicatorController(UsdToCurrencyIndicatorService service) {
        this.service = service;
    }

    @Get("/welcome")
    public HttpResponse<?> welcome() {
        return HttpResponse.status(HttpStatus.OK).body("Welcome!");
    }

    @Get("/compareWithYesterdayUSDRate")
    public HttpResponse<byte[]> checkYesterdayUSDRate(String currency) {
        return buildResponse(service.compare(LocalDate.now().minusDays(1).toString(), currency));
    }

    private HttpResponse<byte[]> buildResponse(byte[] gif) {
        return HttpResponse.status(HttpStatus.OK).headers((headers)->
                headers.contentType(MediaType.IMAGE_GIF_TYPE)
        ).body(gif);
    }

}