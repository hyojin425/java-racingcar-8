package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.RandomGenerator;
import racingcar.validator.Validator;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingServiceTest {

    private CarManager carManager;
    private RandomGenerator randomGenerator;
    private Validator validator;
    private RacingService racingService;

    @BeforeEach
    void setUp() {
        validator = new Validator();
        carManager = new CarManager(randomGenerator);
        randomGenerator = new RandomGenerator();
        racingService = new RacingService(carManager, validator);
    }

    @DisplayName("자동차 이름 리스트로 자동차 목록이 초기화되어야 한다.")
    @Test
    void initCars_ShouldPass() {
        //given
        List<String> carNames = List.of("pobi", "woni", "jun");

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
        int repeatCount = 0;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> racingService.validRepeatCount(repeatCount));

        assertEquals("반복 횟수는 양의 정수입니다.", exception.getMessage());
    }

    @DisplayName("유효한 반복 횟수가 들어왔을 경우 통과한다.")
    @Test
    void validRepeatCount_ShouldPass_WhenValidCount() {
        //given
        int repeatCount = 2;

        // when & then
        racingService.validRepeatCount(repeatCount);
    }

    @DisplayName("우승자가 한 명일 경우 가장 많이 이동한 한 명을 구한다.")
    @Test
    void getWinner_ShouldReturnMaxDistanceCar_WhenOnlyOneCarHasMaxDistance() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");
        racingService.initCars(carNames);

        List<Car> carsList = carManager.getCars().getCarList();
        carsList.get(0).move(5);
        carsList.get(1).move(6);
        carsList.get(2).move(7);

        // when
        Cars winner = racingService.getWinner();

        // then
        assertThat(winner.getCarList().get(0).getName()).isEqualTo("jun");
    }

    @DisplayName("우승자가 여러 명일 경우 가장 많이 이동한 여러 명을 구한다.")
    @Test
    void getWinner_ShouldReturnMaxDistanceCar_WhenManyCarHasMaxDistance() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");
        racingService.initCars(carNames);

        List<Car> carsList = carManager.getCars().getCarList();
        carsList.get(0).move(5);
        carsList.get(1).move(7);
        carsList.get(2).move(7);

        // when
        Cars winner = racingService.getWinner();

        // then
        assertThat(winner.getCarList().get(0).getName()).isEqualTo("woni");
        assertThat(winner.getCarList().get(1).getName()).isEqualTo("jun");
    }
}