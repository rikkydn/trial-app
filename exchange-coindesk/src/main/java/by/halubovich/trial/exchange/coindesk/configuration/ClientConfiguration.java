package by.halubovich.trial.exchange.coindesk.configuration;

import by.halubovich.trial.exchange.coindesk.client.CoinDeskClient;
import feign.Logger;
import feign.Logger.Level;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients(
    clients = CoinDeskClient.class,
    defaultConfiguration = ClientConfiguration.class)
class ClientConfiguration {

  @Bean
  Logger.Level logLevel() {
    return Level.FULL;
  }
}
