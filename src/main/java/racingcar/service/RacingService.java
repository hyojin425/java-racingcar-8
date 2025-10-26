package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.validator.Validator;

import java.util.List;

public class RacingService {

    private final CarManager carManager;
    private RandomGenerator randomGenerator;
    private final Validator validator;

    public RacingService(CarManager carManager, RandomGenerator randomGenerator, Validator validator) {
        this.carManager = carManager;
        this.randomGenerator = randomGenerator;
        this.validator = validator;
    }

    public void initCars(List<String> carNames) {
        List<Car> carList = carManager.createCarList(carNames);
        carManager.createCars(carList);
    }

    public Cars racing() {
        Cars cars = carManager.getCars();
        cars.getCarList().forEach(car -> car.move(generateMoveDistance()));
        return cars;
    }

    private int generateMoveDistance() {
        return randomGenerator.getRandomNumber();
    }

    public void validRepeatCount(int repeatCount) {
        validator.validRepeatCount(repeatCount);
    }

    public Cars getWinner() {
        Cars cars = carManager.getCars();
        return carManager.getWinner(cars);
    }
}
