package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.Parser;
import racingcar.validator.Validator;

import java.util.List;

public class RacingService {

    private final CarManager carManager;
    private final Validator validator;
    private final Parser parser;

    public RacingService(CarManager carManager, Validator validator, Parser parser) {
        this.carManager = carManager;
        this.validator = validator;
        this.parser = parser;
    }

    public void initCars(String carNames) {
        List<String> carNameList = getValidCarNames(carNames);
        validateDuplicateNames(carNameList);
        List<Car> carList = carManager.createCarList(carNameList);
        carManager.createCars(carList);
    }

    public Cars racing() {
        return carManager.moveCars();
    }

    public int getValidRepeatCount(String repeatCount) {
        int repeatCountAsInt = parser.parseRepeatCountAsInt(repeatCount);
        validator.validRepeatCount(repeatCountAsInt);
        return repeatCountAsInt;
    }

    public Cars getWinner() {
        return carManager.getWinner();
    }

    private List<String> getValidCarNames(String carNames) {
        List<String> carNameList = parser.parseCarName(carNames);
        carNameList.forEach(validator::validateNameLength);
        return carNameList;
    }

    private void validateDuplicateNames(List<String> carNameList) {
        validator.validateDuplicateNames(carNameList);
    }
}
