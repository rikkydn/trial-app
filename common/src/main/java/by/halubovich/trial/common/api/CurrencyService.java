package by.halubovich.trial.common.api;

import by.halubovich.trial.common.dto.currency.CurrencyInfo;

public interface CurrencyService {

  /**
   * Fetches price index data for currency.
   *
   * @param currency The code of fetching currency
   * @return {@link CurrencyInfo}
   */
  CurrencyInfo getCurrencyInfo(final String currency);
}
