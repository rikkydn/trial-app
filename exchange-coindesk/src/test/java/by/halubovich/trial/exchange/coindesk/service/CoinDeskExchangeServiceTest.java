package by.halubovich.trial.exchange.coindesk.service;

import static java.time.LocalDate.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import by.halubovich.trial.common.api.ExchangeService;
import by.halubovich.trial.common.domain.exchange.CurrentPriceIndex;
import by.halubovich.trial.common.domain.exchange.HistoricalPriceIndex;
import by.halubovich.trial.exchange.coindesk.client.CoinDeskClient;
import by.halubovich.trial.exchange.coindesk.dto.CurrentBpiDto;
import by.halubovich.trial.exchange.coindesk.dto.HistoricalBpiDto;
import by.halubovich.trial.exchange.coindesk.mapper.CoinDeskMapper;
import com.google.common.collect.ImmutableMap;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CoinDeskExchangeServiceTest {

  private ExchangeService service;
  private CoinDeskClient client;

  @BeforeEach
  void init() {
    client = Mockito.mock(CoinDeskClient.class);
    service = new CoinDeskExchange(client);
  }

  @Test
  void canGetCurrentRate() {
    final var currency = "EUR";
    Mockito.when(client.getCurrentRate(currency)).thenReturn(CurrentBpiDto.builder()
        .bpi(ImmutableMap.of())
        .build());

    final var result = service.getCurrentPriceIndex(currency);

    assertTrue(result.isPresent());
  }

  @Test
  void canGetHistoricalRates() {
    final var currency = "EUR";
    Mockito.when(client.getHistoricalClose("2021-01-01", "2021-01-31", currency)).thenReturn(
        HistoricalBpiDto.builder()
            .bpi(ImmutableMap.of(
                "2021-01-31", BigDecimal.ONE,
                "2021-01-30", BigDecimal.TEN)
            )
            .build());

    final var result = service.getHistoricalCloseValues(
        currency,
        of(2021, 1, 1),
        of(2021, 1, 31));

    assertEquals(2, result.count());
  }
}
