package by.halubovich.trial.currency.support.configuration;

import static java.math.BigDecimal.ONE;
import static java.time.LocalDate.now;

import by.halubovich.trial.common.api.ExchangeService;
import by.halubovich.trial.common.domain.exchange.CurrentPriceIndex;
import by.halubovich.trial.common.domain.exchange.HistoricalPriceIndex;
import by.halubovich.trial.currency.configuration.property.BitcoinCurrencyProperties;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeServiceMock {

  @Bean
  ExchangeService exchangeService() {
    return Mockito.mock(ExchangeService.class);
  }

  @Bean
  OngoingStubbing<Optional<CurrentPriceIndex>> getCurrentPriceIndexUsd() {
    return Mockito.when(exchangeService().getCurrentPriceIndex("usd"))
        .thenReturn(Optional.of(CurrentPriceIndex.builder().value(ONE).build()));
  }

  @Bean
  OngoingStubbing<Stream<HistoricalPriceIndex>> getHistoricalDataValuesUsd(
      final BitcoinCurrencyProperties properties) {
    return Mockito.when(exchangeService().getHistoricalCloseValues("usd",
        now().minusDays(properties.getHistoricalDepthDays()), now()))
        .thenReturn(List.of(
            HistoricalPriceIndex.builder().value(BigDecimal.ZERO).build(),
            HistoricalPriceIndex.builder().value(BigDecimal.TEN).build()
        ).stream());
  }
}
