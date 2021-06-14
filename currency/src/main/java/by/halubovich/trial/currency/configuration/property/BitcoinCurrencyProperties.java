package by.halubovich.trial.currency.configuration.property;

import by.halubovich.trial.common.properties.CurrencyProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(BitcoinCurrencyProperties.PROPERTY_PREFIX)
public class BitcoinCurrencyProperties {

  static final String PROPERTY_PREFIX = CurrencyProperties.PREFIX + ".bitcoin";

  private Integer historicalDepthDays = 30;
}
