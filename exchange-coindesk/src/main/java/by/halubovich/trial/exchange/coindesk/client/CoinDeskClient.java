package by.halubovich.trial.exchange.coindesk.client;

import by.halubovich.trial.exchange.coindesk.dto.CurrentBpiDto;
import by.halubovich.trial.exchange.coindesk.dto.HistoricalBpiDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "coinDeskClient", url = "${exchange.client.coindesk.url}")
public interface CoinDeskClient {

  @GetMapping(value = "/v1/bpi/currentprice/{currency}.json",
      consumes = "application/json")
  CurrentBpiDto getCurrentRate(@PathVariable("currency") String currency);

  @GetMapping("/v1/bpi/historical/close.json")
  HistoricalBpiDto getHistoricalClose(
      @RequestParam("start") String start,
      @RequestParam("end") String end,
      @RequestParam("currency") String currency
  );
}
