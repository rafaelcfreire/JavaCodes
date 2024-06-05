package fpij.chp9;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

final class PickStockImperative {
    public static void main(String[] args) {
        final List<StockInfo> stocks = new ArrayList<>();

        for(String symbol : FinanceData.symbols) {
            stocks.add(StockUtil.getPrice(symbol));
        }
        final Predicate<StockInfo> isPriceLessThan500 = StockUtil.isPriceLessThan(500);
        final List<StockInfo> stocksPriceUnder500 = new ArrayList<>();

        for (StockInfo stock : stocks) {
            if (isPriceLessThan500.test(stock))
                stocksPriceUnder500.add(stock);
        }
        StockInfo highPriced = new StockInfo("", BigDecimal.ZERO);
        for (StockInfo stock : stocksPriceUnder500) {
            highPriced = StockUtil.pickHigh(highPriced, stock);
        }
    }
}
