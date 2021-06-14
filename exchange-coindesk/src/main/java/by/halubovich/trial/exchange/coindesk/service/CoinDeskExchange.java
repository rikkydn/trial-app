package by.halubovich.trial.exchange.coindesk.service;

import by.halubovich.trial.common.api.ExchangeService;
import by.halubovich.trial.common.domain.exchange.CurrentPriceIndex;
import by.halubovich.trial.common.domain.exchange.HistoricalPriceIndex;
import by.halubovich.trial.exchange.coindesk.client.CoinDeskClient;
import by.halubovich.trial.exchange.coindesk.mapper.CoinDeskMapper;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CoinDeskExchange implements ExchangeService {

  private final CoinDeskClient client;

  @Override
  public Optional<CurrentPriceIndex> getCurrentPriceIndex(final String currency) {
    return Optional.of(client.getCurrentRate(currency))
        .map(CoinDeskMapper::toDomain);
  }

  @Override
  public Stream<HistoricalPriceIndex> getHistoricalCloseValues(
      final String currency,
      final LocalDate from,
      final LocalDate to) {
    return Optional.of(client.getHistoricalClose(from.toString(), to.toString(), currency))
        .map(CoinDeskMapper::toDomainList)
        .stream().flatMap(Collection::stream);
  }
}
