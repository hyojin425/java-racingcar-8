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

    public void createCars(String carNames) {
        List<Car> carList = parser.parseCarName(carNames)
                .stream()
                .map(Car::new)
                .toList();

        validator.validateDuplicateNames(carList);
        this.cars = new Cars(carList);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
