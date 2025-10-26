package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.Parser;
import racingcar.utils.RandomGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarManagerTest {

    private Parser parser;
    private CarManager carManager;
    private RandomGenerator randomGenerator;

    @BeforeEach
    void setUp() {
        parser = new Parser();
        randomGenerator = new RandomGenerator();
        carManager = new CarManager(randomGenerator);
    }

    @DisplayName("자동차 이름에 중복이 없는 경우 List<Car>를 생성한다.")
    @Test
    void createCarList_ShouldReturnCarList_WhenNamesAreUnique() {
        // given
        List<String> carNames = parser.parseCarName("pobi,woni,jun");

        // when
        List<Car> carList = assertDoesNotThrow(() -> carManager.createCarList(carNames));

        // then
        assertEquals(3, carList.size());
        assertEquals("pobi", carList.get(0).getName());
        assertEquals("woni", carList.get(1).getName());
        assertEquals("jun", carList.get(2).getName());
    }
}