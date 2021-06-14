package by.halubovich.trial.common.domain.exchange;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class HistoricalPriceIndex {

  BigDecimal value;
  ZonedDateTime time;
}
