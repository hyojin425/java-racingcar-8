package racingcar.domain;

public class Car {

    private String name;
    private int moveDistance;

    public Car(String name) {
        this.name = name;
    }

    public int move(int n) {
        return this.moveDistance += n;
    }
}
