package by.halubovich.trial.exchange.coindesk;

import by.halubovich.trial.common.api.ExchangeService;
import by.halubovich.trial.exchange.coindesk.support.ModuleTest;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@ModuleTest
@RequiredArgsConstructor
class GetHistoricalCloseValuesTest {

  private final ExchangeService exchangeService;

  @Test
  void getHistoricalCloseValuesMonth() {
    final var history = exchangeService.getHistoricalCloseValues(
        "eur",
        LocalDate.of(2021, 1, 1),
        LocalDate.of(2021, 1, 31)
    );

    Assertions.assertNotNull(history);
  }
}
