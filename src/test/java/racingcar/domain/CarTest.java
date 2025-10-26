package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @DisplayName("moveDistance 값이 최소값 이상이면 이동 거리 증가")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_ShouldIncreaseMoveDistance_WhenAboveMinValue(int randomNumber) {
        // given
        Car car = new Car("pobi");

        // when
        int moveDistance = car.move(randomNumber);

        // then
        assertThat(moveDistance).isEqualTo(randomNumber);
    }

    @DisplayName("moveDistance 값이 최소값 이하이면 이동 거리는 그대로")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void move_ShouldNotIncreaseMoveDistance_WhenBelowMinValue(int randomNumber) {
        // given
        Car car = new Car("pobi");

        // when
        int moveDistance = car.move(randomNumber);

        // then
        assertThat(moveDistance).isEqualTo(0);
    }
}