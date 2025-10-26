package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.utils.Parser;
import racingcar.utils.RandomGenerator;
import racingcar.validator.Validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingServiceTest {

    private CarManager carManager;
    private RandomGenerator randomGenerator;
    private Validator validator;
    private RacingService racingService;
    private Parser parser;

    @BeforeEach
    void setUp() {
        validator = new Validator();
        carManager = new CarManager(randomGenerator);
        randomGenerator = new RandomGenerator();
        parser = new Parser();
        racingService = new RacingService(carManager, validator, parser);
    }

    @DisplayName("자동차 이름 리스트로 자동차 목록이 초기화되어야 한다.")
    @Test
    void initCars_ShouldPass() {
        //given
        String carNames = "pobi,woni,jun";

        // when
        racingService.initCars(carNames);
        Cars cars = carManager.getCars();

        // then
        assertThat(cars.getCarList().size()).isEqualTo(3);
        assertThat(cars.getCarList().get(0).getName()).isEqualTo("pobi");
        assertThat(cars.getCarList().get(1).getName()).isEqualTo("woni");
        assertThat(cars.getCarList().get(2).getName()).isEqualTo("jun");
    }

    @DisplayName("반복 횟수 0이 들어왔을 경우 IllegalArgumentException 발생시킨다.")
    @Test
    void repeatCountZero_ShouldThrowException() {
        //given
        String repeatCount = "0";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> racingService.getValidRepeatCount(repeatCount));

        assertThat(exception.getMessage()).isEqualTo("반복 횟수는 양의 정수입니다.");
    }

    @DisplayName("유효한 반복 횟수가 들어왔을 경우 통과한다.")
    @Test
    void validRepeatCount_ShouldPass_WhenValidCount() {
        //given
        String repeatCount = "2";

        // when
        int repeatCountAsInt = racingService.getValidRepeatCount(repeatCount);

        // then
        assertThat(repeatCountAsInt).isEqualTo(2);
    }

    @DisplayName("길이가 5이상인 이름이 포함된 경우 IllegalArgumentException 발생시킨다.")
    @Test
    void getValidCarNames_ShouldThrowException_WhenContainsInvalidName() {
        //given
        String carNames = "pobiasas,woni,jun";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> racingService.initCars(carNames));

        // then
        assertThat(exception.getMessage()).isEqualTo("자동차 이름이 최대 글자 수를 초과합니다: pobiasas");
    }

    @DisplayName("중복된 이름이 포함된 경우 IllegalArgumentException 발생시킨다.")
    @Test
    void validateDuplicateNames_ShouldThrowException_WhenContainsDuplicateNames() {
        //given
        String carNames = "woni,woni,jun";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> racingService.initCars(carNames));

        // then
        assertThat(exception.getMessage()).isEqualTo("중복된 자동차 이름이 존재합니다: woni");
    }
}