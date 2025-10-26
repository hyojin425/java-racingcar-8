package racingcar.validator;

import racingcar.domain.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private final String ERROR_DUPLICATE_NAMES = "중복된 자동차 이름이 존재합니다: ";
    private final String ERROR_CAR_NAME_TOO_LONG = "자동차 이름이 최대 글자 수를 초과합니다: ";
    private final int MAX_NAME_LENGTH = 5;

    public void validateDuplicateNames(List<Car> cars) {
        Set<String> names = new HashSet<>();

        cars.stream()
                .map(Car::getName)
                .filter(name -> !names.add(name))
                .findFirst()
                .ifPresent(duplicateName -> {
                    throw new IllegalArgumentException(ERROR_DUPLICATE_NAMES + duplicateName);
                });
    }

    public void validateNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_TOO_LONG + carName);
        }
    }
}
