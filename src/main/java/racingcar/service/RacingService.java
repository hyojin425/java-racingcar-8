package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.validator.Validator;

import java.util.List;

public class RacingService {

    private final CarManager carManager;
    private final Validator validator;

    public RacingService(CarManager carManager, Validator validator) {
        this.carManager = carManager;
        this.validator = validator;
    }

    public void initCars(List<String> carNames) {
        List<Car> carList = carManager.createCarList(carNames);
        carManager.createCars(carList);
    }

    public Cars racing() {
        return carManager.moveCars();
    }

    public void validRepeatCount(int repeatCount) {
        validator.validRepeatCount(repeatCount);
    }

    public Cars getWinner() {
        return carManager.getWinner();
    }
}
