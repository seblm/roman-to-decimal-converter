package fr.xebia;

import org.junit.Test;

import static fr.xebia.RomanToDecimalConverter.convert;
import static org.assertj.core.api.Assertions.assertThat;

public class RomanToDecimalConverterTest {
    @Test
    public void should_convert_zero() {
        int decimal = convert("");

        assertThat(decimal).isEqualTo(0);
    }

    @Test
    public void should_convert_one() {
        int decimal = convert("I");

        assertThat(decimal).isEqualTo(1);
    }

    @Test
    public void should_convert_five() {
        int decimal = convert("V");

        assertThat(decimal).isEqualTo(5);
    }
}
