package fpij.chp9;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class FinanceData {
    static final List<String> symbols = Arrays.asList("AMD", "HPQ", "IBM", "TXN", "VWM", "XRX", "AAPL", "ADBE",
            "AMZN", "CRAY", "CSCO", "SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN", "RIVN");
    static final BigDecimal HUNDRED = new BigDecimal("100");
    public static BigDecimal getPrice(final String ticker) {
        Map<String, String> fakePrices = new HashMap<>() {
            {
                put("AMD", "81"); put("HPQ", "33"); put("IBM", "135");
                put("TXN", "150"); put("VWM", "116"); put("XRX", "15");
                put("AAPL", "131"); put("ADBE", "360"); put("AMZN", "106");
                put("CRAY", "130"); put("CSCO", "43"); put("SNE", "72");
                put("GOOG", "2157"); put("INTC", "36"); put("INTU", "369");
                put("MSFT", "247"); put("ORCL", "67"); put("TIBX", "24");
                put("VRSN", "157"); put("RIVN", "26");
            }
        };
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            System.out.println("Delay");
        }
        return new BigDecimal(fakePrices.get(ticker));
    }

    public static void main(String[] args) {
        System.out.println(symbols.stream()
                .filter(symbol -> getPrice(symbol).compareTo(HUNDRED) > 0)
                .sorted()
                .collect(joining(",")));
    }
}
