package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    private final String RESULT_HEADER = "실행 결과";
    private final String MOVE_DISTANCE = "-";
    private final String WINNER = "최종 우승자 : ";
    public void printResultHeader() {
        System.out.println(RESULT_HEADER);
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
            System.out.print(MOVE_DISTANCE);
        }
    }

    public void printWinner(Cars cars) {
        String winnerNames = createWinnerNames(cars.getCarList());
        System.out.print(WINNER + winnerNames);
    }

    private String createWinnerNames(List<Car> carList) {
        return String.join(", ",
                carList.stream()
                        .map(Car::getName)
                        .toList());
    }
}
