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
    public void should_convert_two() {
        int decimal = convert("II");

        assertThat(decimal).isEqualTo(2);
    }

    @Test
    public void should_convert_three() {
        int decimal = convert("III");

        assertThat(decimal).isEqualTo(3);
    }

    @Test
    public void should_convert_five() {
        int decimal = convert("V");

        assertThat(decimal).isEqualTo(5);
    }

    @Test
    public void should_convert_ten() {
        int decimal = convert("X");

        assertThat(decimal).isEqualTo(10);
    }

    @Test
    public void should_convert_fifty() {
        int decimal = convert("L");

        assertThat(decimal).isEqualTo(50);
    }

    @Test
    public void should_convert_one_hundred() {
        int decimal = convert("C");

        assertThat(decimal).isEqualTo(100);
    }

    @Test
    public void should_convert_five_hundred() {
        int decimal = convert("D");

        assertThat(decimal).isEqualTo(500);
    }

    @Test
    public void should_convert_one_thousand() {
        int decimal = convert("M");

        assertThat(decimal).isEqualTo(1000);
    }
}
