package racingcar.view;

import racingcar.domain.Cars;

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
}
