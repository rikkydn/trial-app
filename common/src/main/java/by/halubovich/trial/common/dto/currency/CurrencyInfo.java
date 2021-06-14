package by.halubovich.trial.common.dto.currency;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CurrencyInfo {

  BigDecimal current;
  BigDecimal lowest;
  BigDecimal highest;

}
