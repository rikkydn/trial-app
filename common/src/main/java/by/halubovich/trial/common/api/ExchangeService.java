package by.halubovich.trial.common.api;

import by.halubovich.trial.common.domain.exchange.CurrentPriceIndex;
import by.halubovich.trial.common.domain.exchange.HistoricalPriceIndex;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

public interface ExchangeService {

  Optional<CurrentPriceIndex> getCurrentPriceIndex(String currency);

  Stream<HistoricalPriceIndex> getHistoricalCloseValues(String currency,
      LocalDate from, LocalDate to);
}
