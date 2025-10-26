package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomGeneratorTest {

    private RandomGenerator randomGenerator;

    @BeforeEach
    void setUp() {
        randomGenerator = new RandomGenerator();
    }

    @DisplayName("랜덤 숫자가 0 이상 9 이하의 범위를 벗어나지 않아야 한다.")
    @Test
    void getRandomNumber_ShouldReturnNumberInRange() {
        // given & when
        int number = randomGenerator.getRandomNumber();

        // then
        assertThat(number).isBetween(0, 9);
    }
}