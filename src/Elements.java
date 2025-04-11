import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Elements {
    private static final String[] SUFFIXES = {
            "Thou", "Mill", "Bill", "Tril", "Quad", "Quin", "Sext", "Sept", "Octi", "Noni", "Deci",
            "Unde", "Duod", "Tred", "Quat", "Quin", "Sexd", "Sept", "Octo", "Nove", "Vigi", "Cent"
    };

    private static final BigDecimal THOUSAND = new BigDecimal("1000");
    private static final BigDecimal TEN = new BigDecimal("10");
    private static final MathContext MC = new MathContext(20, RoundingMode.HALF_UP);

    public String formatNumber(double num) {
        if (Double.isNaN(num) || Double.isInfinite(num) || num < 0) {
            return "Unknown";
        }

        BigDecimal value = BigDecimal.valueOf(num);
        if (value.compareTo(THOUSAND) < 0) {
            return new DecimalFormat("#,##0.00").format(value);
        }

        int suffixIndex = 0;
        BigDecimal scaled = new BigDecimal(value.toString());

        while (scaled.compareTo(THOUSAND) >= 0 && suffixIndex < SUFFIXES.length - 1) {
            scaled = scaled.divide(THOUSAND, MC);
            suffixIndex++;
        }

        if (suffixIndex >= SUFFIXES.length) {
            return scaled.setScale(2, RoundingMode.HALF_UP) + " ???";
        }

        return scaled.setScale(2, RoundingMode.HALF_UP) + " " + SUFFIXES[suffixIndex];
    }
}