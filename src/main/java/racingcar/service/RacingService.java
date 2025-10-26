package racingcar.service;

import racingcar.domain.Car;
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

    public void initCars(String carNames) {
        carManager.createCars(carNames);
    }

    public void racing() {
        List<Car> cars = carManager.getCars();
        cars.forEach(car -> car.move(generateMoveDistance()));
    }

    public int generateMoveDistance() {
        return randomGenerator.getRandomNumber();
    }
}
