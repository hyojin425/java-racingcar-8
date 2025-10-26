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

    public Cars createCars(List<Car> carList) {
        cars = new Cars(carList);
        return cars;
    }

    public List<Car> createCarList(String carNames) {
        List<Car> carList = parseCarNames(carNames).stream()
                .map(Car::new)
                .toList();
        validator.validateDuplicateNames(carList);
        return carList;
    }

    private List<String> parseCarNames(String carNames) {
        List<String> names = parser.parseCarName(carNames);
        names.forEach(validator::validateNameLength);
        return names;
    }
}
