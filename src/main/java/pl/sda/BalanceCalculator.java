package pl.sda;

import java.math.BigDecimal;
import java.util.List;

public class BalanceCalculator {

    BigDecimal calculate(BalanceData data) {
        BigDecimal result = BigDecimal.ZERO;
        List<BigDecimal> incomes = data.getIncomes();
        List<BigDecimal> outcomes = data.getOutcomes();
        for (BigDecimal nextIncome : incomes) {
            result = result.add(nextIncome);
        }
        for (BigDecimal nextOutcome : outcomes) {
            result = result.subtract(nextOutcome);
        }
        return result;
    }
}
