package by.halubovich.trial.exchange.coindesk.configuration;

import by.halubovich.trial.common.properties.ExchangeClientProperties;
import by.halubovich.trial.exchange.coindesk.property.CoinDeskProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

class PropertiesConfiguration {

  @Bean
  ExchangeClientProperties coinDeskExchangeProperties() {
    @ConfigurationProperties(CoinDeskProperties.PROPERTY_PREFIX)
    class SpringExchangeProperties extends CoinDeskProperties {

    }

    return new SpringExchangeProperties();
  }
}
