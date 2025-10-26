package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.validator.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
    private final Validator validator;
    private Cars cars;

    public CarManager(Validator validator) {
        this.validator = validator;
    }

    public Cars getCars() {
        return cars;
    }

    public Cars createCars(List<Car> carList) {
        cars = new Cars(carList);
        return cars;
    }

    public List<Car> createCarList(List<String> carNames) {
        carNames.forEach(validator::validateNameLength);
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();
        validator.validateDuplicateNames(carList);
        return carList;
    }

    public Cars getWinner(Cars cars) {
        List<Car> carList = cars.getCarList();
        int maxDistance = findMacDistance(carList);

        List<Car> winner = carList.stream()
                .filter(car -> car.getMoveDistance() == maxDistance)
                .collect(Collectors.toList());

        return new Cars(winner);
    }

    private int findMacDistance(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getMoveDistance)
                .max()
                .orElse(0);
    }
}
