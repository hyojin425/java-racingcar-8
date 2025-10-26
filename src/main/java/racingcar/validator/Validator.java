package racingcar.validator;

import racingcar.domain.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateDuplicateNames(List<Car> cars) {
        Set<String> names = new HashSet<>();

        cars.stream()
                .map(Car::getName)
                .filter(name -> !names.add(name))
                .findFirst()
                .ifPresent(duplicateName -> {
                    throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다: " + duplicateName);
                });
    }
}
