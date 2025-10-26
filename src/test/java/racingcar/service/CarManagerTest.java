package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.Parser;
import racingcar.validator.Validator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarManagerTest {

    private Parser parser;
    private Validator validator;
    private CarManager carManager;

    @BeforeEach
    void setUp() {
        parser = new Parser();
        validator = new Validator();
        carManager = new CarManager(validator);
    }

    @DisplayName("자동차 이름에 중복이 없는 경우 List<Car>를 생성한다.")
    @Test
    void createCarList_WithUniqueNames_ShouldSucceed() {
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

    @DisplayName("자동차 이름에 중복이 있는 경우 IllegalArgumentException 발생한다.")
    @Test
    void createCarList_WithDuplicateNames_ShouldThrowException() {
        // given
        List<String> carNames = parser.parseCarName("pobi,woni,jun");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carManager.createCarList(carNames));

        assertEquals("중복된 자동차 이름이 존재합니다: pobi", exception.getMessage());
    }

    @DisplayName("자동차 이름이 최대 글자 수를 초과하는 경우 IllegalArgumentException 발생한다.")
    @Test
    void createCarList_WithNameTooLong_ShouldThrowException() {
        // given
        List<String> carNames = parser.parseCarName("pobi,woni,jun");

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carManager.createCarList(carNames));

        // then
        assertEquals("자동차 이름이 최대 글자 수를 초과합니다: pobighgh", exception.getMessage());
    }
}