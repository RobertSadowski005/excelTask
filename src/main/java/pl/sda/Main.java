package pl.sda;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws IOException {
        BalanceReader reader = new BalanceReader();
        BalanceCalculator calculator = new BalanceCalculator();

        BalanceData data = reader.read();
        BigDecimal balance = calculator.calculate(data);
        System.out.println("Saldo wynosi: " + balance);
    }
}
