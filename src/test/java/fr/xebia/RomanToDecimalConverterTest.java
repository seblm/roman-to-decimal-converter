package fr.xebia;

import org.junit.Test;

import static fr.xebia.RomanToDecimalConverter.convert;
import static org.assertj.core.api.Assertions.assertThat;

public class RomanToDecimalConverterTest {
    @Test
    public void should_convert_zero() {
        assertThat(convert("")).isEqualTo(0);
    }

    @Test
    public void should_convert_single_numeral() {
        assertThat(convert("I")).isEqualTo(1);
        assertThat(convert("V")).isEqualTo(5);
        assertThat(convert("X")).isEqualTo(10);
        assertThat(convert("L")).isEqualTo(50);
        assertThat(convert("C")).isEqualTo(100);
        assertThat(convert("D")).isEqualTo(500);
        assertThat(convert("M")).isEqualTo(1000);
    }

    @Test
    public void should_convert_two_or_three_numerals() {
        assertThat(convert("II")).isEqualTo(2);
        assertThat(convert("III")).isEqualTo(3);
    }

    @Test
    public void should_convert_numerals_with_substraction() {
        assertThat(convert("IV")).isEqualTo(4);
        assertThat(convert("IX")).isEqualTo(9);
    }

    @Test
    public void should_convert_numerals_until_thousand() {
        assertThat(convert("MLXVI")).isEqualTo(1066);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_add_more_than_tree_numerals() {
        convert("IIII");
        convert("XXXX");
        convert("CCCC");
        convert("MMMM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_add_numerals() {
        convert("VV");
        convert("LL");
        convert("DD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_substract_two_next_higher_value() {
        convert("IL");
        convert("XM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_substract_more_than_one_numeral() {
        convert("XXC");
    }
}