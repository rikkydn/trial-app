package by.halubovich.trial.exchange.coindesk.mapper;

import by.halubovich.trial.exchange.coindesk.dto.CurrentBpiDto;
import by.halubovich.trial.exchange.coindesk.dto.CurrentBpiDto.Bpi;
import by.halubovich.trial.exchange.coindesk.dto.HistoricalBpiDto;
import by.halubovich.trial.exchange.coindesk.mapper.CoinDeskMapper;
import com.google.common.collect.ImmutableMap;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoinDeskMapperTest {

  @Test
  void coinDeskCurrentBpiDtoToDomainTest() {
    final var bpi = ImmutableMap.<String, Bpi>builder()
        .put("key1", Bpi.builder().rate(BigDecimal.TEN).build())
        .put("key2", Bpi.builder().rate(BigDecimal.ONE).build())
        .build();
    final var dto = CurrentBpiDto.builder()
        .bpi(bpi).build();

    final var result = CoinDeskMapper.toDomain(dto);

    Assertions.assertEquals(BigDecimal.ONE, result.getValue());
  }

  @Test
  void coinDeskCurrentBpiDtoToDomainEmptyMapTest() {
    final var dto = CurrentBpiDto.builder()
        .bpi(ImmutableMap.of())
        .build();

    final var result = CoinDeskMapper.toDomain(dto);

    Assertions.assertNull(result.getValue());
  }

  @Test
  void coinDeskHistoricalBpiDtoToDomainTest() {
    final var dto = HistoricalBpiDto.builder()
        .bpi(ImmutableMap.of(
            "2021-01-31", BigDecimal.ONE,
            "2021-01-30", BigDecimal.TEN)
        )
        .build();

    final var result = CoinDeskMapper.toDomainList(dto);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(2, result.size());
  }

  @Test
  void coinDeskHistoricalBpiDtoToDomainEmptyMapTest() {
    final var dto = HistoricalBpiDto.builder()
        .bpi(ImmutableMap.of())
        .build();

    final var result = CoinDeskMapper.toDomainList(dto);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(0, result.size());
  }
}
