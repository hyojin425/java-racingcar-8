package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class RacingService {
    private final Parser parser;
    private Cars cars;
    private RandomGenerator randomGenerator;

    public RacingService(Parser parser, RandomGenerator randomGenerator) {
        this.parser = parser;
        this.randomGenerator = randomGenerator;
    }

    public List<Car> initCars(String carNames) {
        this.cars = new Cars(parser.parseCarName(carNames)
                        .stream()
                        .map(Car::new)
                        .toList());
        return cars.getCars();
    }

    public void racing() {
        cars.getCars().forEach(car -> car.move(randomGenerator.getRandomNumber()));
    }
}
