package pl.sda;

import com.sun.org.apache.xpath.internal.Arg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SmsConverterTest {

    @ParameterizedTest
    @MethodSource ("getData")
    void testConvert() {
        SmsConverter converter = new SmsConverter();


    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.of("Obiad gotowy, czekam","ObiadGotowy,Czekam"),
                Arguments.of("Pies biega jak szalony","PiesBiegaJakSzalony"),
                Arguments.of("Programowanie to kupa pracy gdy dopiero zaczynasz","ProgramowanieToKupaPracyGdyDopieroZaczynasz"),
                Arguments.of("Robert","Robert")
        );
    }

}