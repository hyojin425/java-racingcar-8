package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.validator.Validator;

import java.util.List;

public class CarManager {
    private final Parser parser;
    private final Validator validator;
    private Cars cars;

    public CarManager(Parser parser, Validator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    public Cars getCars() {
        return cars;
    }

    public List<Car> createCarList(String carNames) {
        List<Car> carList = parser.parseCarName(carNames)
                .stream()
                .map(Car::new)
                .toList();
        validator.validateDuplicateNames(carList);
        return carList;
    }

    public Cars createCars(List<Car> carList) {
        cars = new Cars(carList);
        return cars;
    }
}
