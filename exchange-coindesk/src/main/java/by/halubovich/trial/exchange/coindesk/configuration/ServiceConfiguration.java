package by.halubovich.trial.exchange.coindesk.configuration;

import by.halubovich.trial.common.api.ExchangeService;
import by.halubovich.trial.exchange.coindesk.client.CoinDeskClient;
import by.halubovich.trial.exchange.coindesk.service.CoinDeskExchange;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

class ServiceConfiguration {

  @Bean
  ExchangeService coinDeskExchangeService(final CoinDeskClient client) {
    return new CoinDeskExchange(client);
  }
}
