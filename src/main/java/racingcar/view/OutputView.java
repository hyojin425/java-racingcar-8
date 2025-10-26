package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    public void printResultHeader() {
        System.out.println("실행 결과");
    }

    public void printRacing(Cars cars) {
        cars.getCarList().stream()
                .forEach(car -> {
                    System.out.print(car.getName() + " : ");
                    printMoveDistance(car.getMoveDistance());
                    System.out.println();
                });
        System.out.println();
    }

    private void printMoveDistance(int moveDistance) {
        for (int i = 0; i < moveDistance; i++) {
            System.out.print("-");
        }
    }

    public void printWinner(Cars cars) {
        String winnerNames = createWinnerNames(cars.getCarList());
        System.out.print("최종 우승자 : " + winnerNames);
    }

    private String createWinnerNames(List<Car> carList) {
        return String.join(", ",
                carList.stream()
                        .map(Car::getName)
                        .toList());
    }
}
