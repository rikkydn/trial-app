package by.halubovich.trial.currency.configuration;

import by.halubovich.trial.common.api.ExchangeService;
import by.halubovich.trial.currency.configuration.property.BitcoinCurrencyProperties;
import by.halubovich.trial.currency.service.BitcoinService;
import org.springframework.context.annotation.Bean;

class ModuleConfiguration {

  @Bean
  BitcoinCurrencyProperties bitcoinCurrencyProperties() {
    return new BitcoinCurrencyProperties();
  }

  @Bean
  BitcoinService bitcoinService(final BitcoinCurrencyProperties properties,
      final ExchangeService exchangeService) {
    return new BitcoinService(exchangeService, properties);
  }
}
