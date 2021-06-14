package by.halubovich.trial.currency.service;

import static java.time.LocalDate.now;

import by.halubovich.trial.common.api.CurrencyService;
import by.halubovich.trial.common.api.ExchangeService;
import by.halubovich.trial.common.dto.currency.CurrencyInfo;
import by.halubovich.trial.currency.configuration.property.BitcoinCurrencyProperties;
import by.halubovich.trial.currency.mapper.BitcoinCurrencyMapper;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BitcoinService implements CurrencyService {

  private final ExchangeService exchangeService;
  private final BitcoinCurrencyProperties properties;

  @Override
  public CurrencyInfo getCurrencyInfo(final String currency) {
    final var current = exchangeService.getCurrentPriceIndex(currency)
        .orElseThrow(() -> new RuntimeException("Can't get current rate for " + currency));
    final var historical = exchangeService.getHistoricalCloseValues(currency,
        now().minusDays(properties.getHistoricalDepthDays()), now()).collect(Collectors.toList());

    return BitcoinCurrencyMapper.toDto(current, historical);
  }
}
