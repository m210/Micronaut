package com.example.service;

import java.time.LocalDate;

public interface UsdToCurrencyIndicatorService {

    byte[] compare(String date, String currency);
}
