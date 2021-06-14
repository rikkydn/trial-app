package by.halubovich.trial.currency.mapper;

import static java.math.BigDecimal.ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import by.halubovich.trial.common.domain.exchange.CurrentPriceIndex;
import by.halubovich.trial.common.domain.exchange.HistoricalPriceIndex;
import java.util.List;
import org.junit.jupiter.api.Test;

class BitcoinCurrencyMapperTest {

  @Test
  void currentAndHistoricalToDtoEmptyHistoryTest() {
    final var current = CurrentPriceIndex.builder()
        .value(ONE)
        .build();
    final var historical = List.<HistoricalPriceIndex>of();
    final var result = BitcoinCurrencyMapper.toDto(current, historical);

    assertEquals(ONE, result.getCurrent());
    assertNull(result.getLowest());
    assertNull(result.getHighest());
  }
}
