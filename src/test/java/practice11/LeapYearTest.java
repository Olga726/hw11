package practice11;
//Обычные невисокосные годы: 2019, 2021, 2022 → false
//Високосные годы: 2020, 2000, 1600 → true
//Года, делящиеся на 100, но не на 400: 1900, 2100 → false
//Граничные случаи: 0, 4, 400 → true

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeapYearTest {
    private LeapYear leapYear;

    @BeforeEach
    void setUp() {
        leapYear = new LeapYear();
    }

    @ParameterizedTest
    @ValueSource(ints = {
            2019, 2021, 2022}
    )
    @DisplayName("Обычные невисокосные годы")
    public void userCanCheckNotLeapYears(int year) {
        assertFalse(leapYear.isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            2020, 2000, 1600}
    )
    @DisplayName("Високосные годы")
    public void userCanCheckLeapYears(int year) {
        assertTrue(leapYear.isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            1900, 2100}
    )
    @DisplayName("Года, делящиеся на 100, но не на 400")
    public void userCanCheckNotLeapYearsDivided100(int year) {
        assertFalse(leapYear.isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            0, 4, 400}
    )
    @DisplayName("Граничные случаи: 0, 4, 400")
    public void userCanCheckLeapYearsBoundaryValues(int year) {
        assertTrue(leapYear.isLeapYear(year));
    }

}
