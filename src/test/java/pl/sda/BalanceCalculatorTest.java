package pl.sda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BalanceCalculatorTest {

    @ParameterizedTest
    @MethodSource("getData")
    void testCalculate(BalanceData data, BigDecimal result) {
        //given
        BalanceCalculator calculator = new BalanceCalculator();
        //when
        BigDecimal balance = calculator.calculate(data);
        //then
        Assertions.assertEquals(result, balance);
    }

    static Stream<Arguments> getData() {
        return Stream.of(Arguments.of(
                new BalanceData(), BigDecimal.ZERO),

                Arguments.of(new BalanceData(
                                Arrays.asList(BigDecimal.ONE,
                                        new BigDecimal("120")),
                                Arrays.asList(new BigDecimal("50"))
                        ),
                        new BigDecimal("71")
                )
        );
    }
}