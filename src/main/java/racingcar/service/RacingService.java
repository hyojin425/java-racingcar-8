package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.validator.Validator;

import java.util.List;
import java.util.stream.IntStream;

public class RacingService {
    private final Parser parser;
    private Cars cars;
    private RandomGenerator randomGenerator;
    private final Validator validator;
    private final int MIN_NUMBER = 4;

    public RacingService(Parser parser, RandomGenerator randomGenerator, Validator validator) {
        this.parser = parser;
        this.randomGenerator = randomGenerator;
        this.validator = validator;
    }

    public List<Car> initCars(String carNames) {
        this.cars = new Cars(parser.parseCarName(carNames)
                        .stream()
                        .map(Car::new)
                        .toList());
        return cars.getCars();
    }

    public void racing() {
        cars.getCars().forEach(car -> {
            car.move(generateMoveDistance());
        });
    }

    public int generateMoveDistance() {
        return randomGenerator.getRandomNumber();
    }
}
