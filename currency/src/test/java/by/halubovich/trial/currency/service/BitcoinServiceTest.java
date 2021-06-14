package by.halubovich.trial.currency.service;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import by.halubovich.trial.common.api.ExchangeService;
import by.halubovich.trial.common.domain.exchange.CurrentPriceIndex;
import by.halubovich.trial.common.domain.exchange.HistoricalPriceIndex;
import by.halubovich.trial.currency.configuration.property.BitcoinCurrencyProperties;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BitcoinServiceTest {

  private BitcoinService service;
  private ExchangeService exchangeService;
  private BitcoinCurrencyProperties properties;

  @BeforeEach
  void init() {
    properties = new BitcoinCurrencyProperties();
    properties.setHistoricalDepthDays(30);

    exchangeService = Mockito.mock(ExchangeService.class);

    service = new BitcoinService(exchangeService, properties);
  }

  @Test
  void getPriceIndexInfoTest() {
    final var currency = "usd";
    final var current = CurrentPriceIndex.builder()
        .value(ONE)
        .build();
    final var historical = List.of(
        HistoricalPriceIndex.builder().value(TEN).build(),
        HistoricalPriceIndex.builder().value(ZERO).build()
    );
    Mockito.when(exchangeService.getCurrentPriceIndex(currency)).thenReturn(Optional.of(current));
    Mockito.when(exchangeService.getHistoricalCloseValues(
        currency, now().minusDays(properties.getHistoricalDepthDays()), now()))
        .thenReturn(historical.stream());

    final var result = service.getCurrencyInfo(currency);

    assertEquals(ONE, result.getCurrent());
    assertEquals(ZERO, result.getLowest());
    assertEquals(TEN, result.getHighest());
  }

  @Test
  void getPriceIndexInfoCurrentIsEmptyTest() {
    final var currency = "usd";
    Mockito.when(exchangeService.getCurrentPriceIndex(currency)).thenReturn(Optional.empty());

    assertThrows(
        RuntimeException.class,
        () -> service.getCurrencyInfo(currency));
  }
}
