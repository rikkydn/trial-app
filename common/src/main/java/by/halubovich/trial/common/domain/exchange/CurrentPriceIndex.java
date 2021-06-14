package by.halubovich.trial.common.domain.exchange;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CurrentPriceIndex {

  BigDecimal value;
}
