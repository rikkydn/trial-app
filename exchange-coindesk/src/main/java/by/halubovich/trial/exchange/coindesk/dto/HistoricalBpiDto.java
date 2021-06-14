package by.halubovich.trial.exchange.coindesk.dto;

import com.google.common.collect.ImmutableMap;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class HistoricalBpiDto {

  ImmutableMap<String, BigDecimal> bpi;
}
