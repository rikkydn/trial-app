package by.halubovich.trial.exchange.coindesk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CurrentBpiDto {

  ImmutableMap<String, Bpi> bpi;

  @Value
  @Builder
  public static class Bpi {

    @JsonProperty("rate_float")
    BigDecimal rate;
  }
}
