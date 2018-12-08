package pl.sda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BalanceReaderTest {

    @Test
    void read() throws IOException {
        BalanceReader reader = new BalanceReader();
        BalanceData data = reader.read();

        Assertions.assertEquals(data.getIncomes().size(), 3);
        Assertions.assertTrue(data.getIncomes().contains(new BigDecimal("20000.0")));

        Assertions.assertEquals(data.getOutcomes().size(), 16);
        Assertions.assertTrue(data.getOutcomes().contains(new BigDecimal("126.0")));
    }
}