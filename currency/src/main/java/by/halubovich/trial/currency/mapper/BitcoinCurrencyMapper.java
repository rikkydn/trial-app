package by.halubovich.trial.currency.mapper;

import by.halubovich.trial.common.domain.exchange.CurrentPriceIndex;
import by.halubovich.trial.common.domain.exchange.HistoricalPriceIndex;
import by.halubovich.trial.common.dto.currency.CurrencyInfo;
import java.util.Comparator;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BitcoinCurrencyMapper {

  /**
   * Build dto object based on current index value and historical data.
   *
   * @param current    {@link CurrentPriceIndex}
   * @param historical {@link List of {@link HistoricalPriceIndex}}
   * @return {@link CurrencyInfo}
   */
  public static CurrencyInfo toDto(final CurrentPriceIndex current,
      final List<HistoricalPriceIndex> historical) {
    final var highestValue = historical.stream()
        .max(Comparator.comparing(HistoricalPriceIndex::getValue))
        .map(HistoricalPriceIndex::getValue).orElse(null);
    final var lowestValue = historical.stream()
        .min(Comparator.comparing(HistoricalPriceIndex::getValue))
        .map(HistoricalPriceIndex::getValue).orElse(null);
    return CurrencyInfo.builder()
        .current(current.getValue())
        .highest(highestValue)
        .lowest(lowestValue)
        .build();
  }

}
