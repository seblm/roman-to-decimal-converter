package fr.xebia;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanToDecimalConverterTest {
    @Test
    public void should_convert_zero() {
        int decimal = RomanToDecimalConverter.convert("");

        assertThat(decimal).isEqualTo(0);
    }
}
