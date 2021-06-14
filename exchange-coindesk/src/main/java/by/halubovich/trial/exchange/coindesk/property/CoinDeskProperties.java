package by.halubovich.trial.exchange.coindesk.property;

import by.halubovich.trial.common.properties.ExchangeClientProperties;
import lombok.Data;

@Data
public class CoinDeskProperties implements ExchangeClientProperties {

  public static final String PROPERTY_PREFIX = ExchangeClientProperties.PREFIX + ".coindesk";

  private String url;
}
