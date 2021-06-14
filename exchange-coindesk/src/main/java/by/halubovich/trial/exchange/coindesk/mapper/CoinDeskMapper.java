package by.halubovich.trial.exchange.coindesk.mapper;

import static lombok.AccessLevel.PRIVATE;

import by.halubovich.trial.common.domain.exchange.CurrentPriceIndex;
import by.halubovich.trial.common.domain.exchange.HistoricalPriceIndex;
import by.halubovich.trial.exchange.coindesk.dto.CurrentBpiDto;
import by.halubovich.trial.exchange.coindesk.dto.CurrentBpiDto.Bpi;
import by.halubovich.trial.exchange.coindesk.dto.HistoricalBpiDto;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class CoinDeskMapper {

  /**
   * Map CoinDesk current BPI DTO to Domain object.
   *
   * @param dto current rate DTO from CoinDesk
   * @return {@link CurrentPriceIndex}
   */
  public static CurrentPriceIndex toDomain(final CurrentBpiDto dto) {
    final var bpi = dto.getBpi().values()
        .stream()
        .reduce((first, second) -> second)
        .orElse(Bpi.builder().build());
    return CurrentPriceIndex.builder()
        .value(bpi.getRate())
        .build();
  }

  /**
   * Map CoinDesk historical BPI DTO to Domain object.
   *
   * @param dto historical rate DTO from CoinDesk
   * @return {@link HistoricalPriceIndex}
   */
  public static List<HistoricalPriceIndex> toDomainList(final HistoricalBpiDto dto) {
    return dto.getBpi().entrySet().stream()
        .map(entry -> HistoricalPriceIndex.builder()
            .value(entry.getValue())
            .time(LocalDate.parse(entry.getKey()).atTime(23, 59).atZone(ZoneId.of("UTC")))
            .build())
        .collect(Collectors.toList());
  }
}
