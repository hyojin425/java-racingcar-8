package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
    private final NumberGenerator numberGenerator;
    private Cars cars;

    public CarManager(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Cars getCars() {
        return cars;
    }

    public Cars createCars(List<Car> carList) {
        cars = new Cars(carList);
        return cars;
    }

    public List<Car> createCarList(List<String> carNames) {
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();
        return carList;
    }

    public Cars moveCars() {
        cars.getCarList().forEach(
                car -> car.move(numberGenerator.getRandomNumber()));
        return cars;
    }

    public Cars getWinner() {
        int maxDistance = cars.getMaxDistance();

        List<Car> winner = cars.getCarList().stream()
                .filter(car -> car.getMoveDistance() == maxDistance)
                .collect(Collectors.toList());

        return new Cars(winner);
    }
}
