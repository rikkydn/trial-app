package by.halubovich.trial.exchange.coindesk;

import static java.math.BigDecimal.valueOf;

import by.halubovich.trial.common.api.ExchangeService;
import by.halubovich.trial.exchange.coindesk.support.ModuleTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@ModuleTest
@RequiredArgsConstructor
public class GetCurrentPriceIndexTest {

  private final ExchangeService exchangeService;

  @Test
  void getCurrentPriceIndexUsd() {
    final var usd = exchangeService.getCurrentPriceIndex("usd")
        .orElseThrow();

    Assertions.assertEquals(valueOf(36900.92), usd.getValue());
  }

  @Test
  void getCurrentPriceIndexEur() {
    final var eur = exchangeService.getCurrentPriceIndex("eur")
        .orElseThrow();

    Assertions.assertEquals(valueOf(31181.6441), eur.getValue());
  }
}
