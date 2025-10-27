package racingcar.domain;

import java.util.List;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getMaxDistance() {
        return carList.stream()
                .mapToInt(Car::getMoveDistance)
                .max()
                .orElse(0);
    }
}
