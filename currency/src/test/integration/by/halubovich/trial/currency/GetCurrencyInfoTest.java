package by.halubovich.trial.currency;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;

import by.halubovich.trial.currency.service.BitcoinService;
import by.halubovich.trial.currency.support.ModuleTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@ModuleTest
@RequiredArgsConstructor
class GetCurrencyInfoTest {

  private final BitcoinService service;

  @Test
  void canGetCurrencyInfo() {
    final var currencyInfo = service.getCurrencyInfo("usd");

    assertEquals(ONE, currencyInfo.getCurrent());
    assertEquals(ZERO, currencyInfo.getLowest());
    assertEquals(TEN, currencyInfo.getHighest());
  }
}
