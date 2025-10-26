package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.RandomGenerator;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarManagerTest {

    private CarManager carManager;
    private RandomGenerator randomGenerator;

    @BeforeEach
    void setUp() {
        randomGenerator = new RandomGenerator();
        carManager = new CarManager(randomGenerator);
    }

    @DisplayName("우승자를 반환한다.")
    @Test
    void getWinner_ShouldReturnCarsWithMaxDistance() {
        // given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.move(3);
        woni.move(5);
        jun.move(5);

        List<Car> carList = List.of(pobi, woni, jun);
        carManager.createCars(carList);

        // when
        Cars winners = carManager.getWinner();

        // then
        assertThat(winners.getCarList().get(0).getName()).isEqualTo("woni");
        assertThat(winners.getCarList().get(1).getName()).isEqualTo("jun");
    }
}