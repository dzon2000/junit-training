package pl.com.pw;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by pwykowski
 */
class StringCalculatorTest {

	private final StringCalculator calculator = new StringCalculator();

	@DisplayName("Should return 0 for an empty String")
	@Test
	public void shouldReturn0ForEmptyString() {
		// given

		// when
		final int result = calculator.add("");
		// then
		assertEquals(0, result);
	}

	@Test
	public void shouldReturn5For1And4CommaSeparatedNumbers() {
		// given

		// when
		final int result = calculator.add("1,4");
		// then
		assertEquals(5, result);
	}

	@Test
	public void shouldReturn10ForOnlyOneNumberWhichIs10() {
		// given

		// when
		final int result = calculator.add("10");
		// then
		assertEquals(10, result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"2,3,1,4", "1,9", "2,2,2,2,2", "4,1,5"})
	public void shouldReturn10For2And3And1And4(String numbers) {
		// given

		// when
		final int result = calculator.add(numbers);
		// then
		assertEquals(10, result);
	}

	@ParameterizedTest
	@CsvSource(delimiter = ':', value = {
		"1,4,6,12:23",
		"88,12,4,9:113"
	})
	public void shouldReturn10For2And3And1And4(String numbers, int sum) {
		// given

		// when
		final int result = calculator.add(numbers);
		// then
		assertEquals(sum, result);
	}

	@Test
	public void shouldReturn6For1And2And3WithNewLineAndCommaSeparator() {
		// given

		// when
		final int result = calculator.add("1\n2,3");
		// then
		assertEquals(6, result);
	}

	@Test
	public void shouldThrowExceptionWhenInputHas2SeparatorsAndOnly1Number() {
		// given

		// when
		// then
		final InvalidInputException exception = assertThrows(InvalidInputException.class, () -> calculator.add("1,\n"));
	}

}