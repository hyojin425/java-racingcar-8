package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("Cars 객체 생성 시 carList 저장한다.")
    @Test
    void constructor_ShouldStoreCarList_WhenCarsCreated() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        Cars cars = new Cars(List.of(car1, car2, car3));

        // when
        List<Car> result = cars.getCarList();

        // then
        assertThat(result).containsExactly(car1, car2, car3);
    }
}