package enums;

import java.math.BigDecimal;

public enum CurrencyTypeEnum {
    TRY,
    USD,
    EUR;

    final BigDecimal dollarToTry = new BigDecimal("26.10");
    final BigDecimal euroToTry = new BigDecimal("28.72");
    final BigDecimal tryToDollar = new BigDecimal("0.0383");
    final BigDecimal tryToEuro = new BigDecimal("0.0348");
    final BigDecimal euroToDollar = new BigDecimal("1.1");
    final BigDecimal dollarToEuro = new BigDecimal("0.91");

    public BigDecimal convertTo(BigDecimal value, CurrencyTypeEnum fromCurrency, CurrencyTypeEnum toCurrency) {

        if (fromCurrency == CurrencyTypeEnum.USD && toCurrency == CurrencyTypeEnum.TRY) {
            return value.multiply(dollarToTry);
        } else if (fromCurrency == CurrencyTypeEnum.EUR && toCurrency == CurrencyTypeEnum.TRY) {
            return value.multiply(euroToTry);
        } else if (fromCurrency == CurrencyTypeEnum.EUR && toCurrency == CurrencyTypeEnum.USD) {
            return value.multiply(euroToDollar);
        } else if (fromCurrency == CurrencyTypeEnum.TRY && toCurrency == CurrencyTypeEnum.USD) {
            return value.multiply(tryToDollar);
        } else if (fromCurrency == CurrencyTypeEnum.TRY && toCurrency == CurrencyTypeEnum.EUR) {
            return value.multiply(tryToEuro);
        } else if (fromCurrency == CurrencyTypeEnum.USD && toCurrency == CurrencyTypeEnum.EUR) {
            return value.multiply(dollarToEuro);
        }
        return value;
    }
}
