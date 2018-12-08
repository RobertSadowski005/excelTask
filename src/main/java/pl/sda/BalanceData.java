package pl.sda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BalanceData {

    private List<BigDecimal> incomes = new ArrayList<>();
    private List<BigDecimal> outcomes = new ArrayList<>();

    BalanceData(){

    }

    public BalanceData(List<BigDecimal> incomes, List<BigDecimal> outcomes) {
        this.incomes = incomes;
        this.outcomes = outcomes;
    }

    public List<BigDecimal> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<BigDecimal> incomes) {
        this.incomes = incomes;
    }

    public List<BigDecimal> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<BigDecimal> outcomes) {
        this.outcomes = outcomes;
    }


}
