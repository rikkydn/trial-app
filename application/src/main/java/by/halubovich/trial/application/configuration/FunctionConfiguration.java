package by.halubovich.trial.application.configuration;

import by.halubovich.trial.common.api.CurrencyService;
import by.halubovich.trial.common.dto.currency.CurrencyInfo;
import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class FunctionConfiguration {

  @Bean
  Function<String, CurrencyInfo> getCurrencyInfoFunction(
      final CurrencyService currencyService
  ) {
    return currencyService::getCurrencyInfo;
  }
}
