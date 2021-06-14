package by.halubovich.trial.exchange.coindesk.support.configuration;

import by.halubovich.trial.exchange.coindesk.client.CoinDeskClient;
import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class CoinDeskClientWireMockConfiguration {

  /**
   * Initialize {@link CoinDeskClient} wire mock server.
   *
   * @return server
   */
  @Bean
  WireMockServer coinDeskWireMockServer(
      @Value("${exchange.client.coindesk.wiremock.port}") int port
  ) {
    final var wireMockServer = new WireMockServer(port);
    wireMockServer.start();
    return wireMockServer;
  }
}
