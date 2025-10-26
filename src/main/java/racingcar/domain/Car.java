package racingcar.domain;

public class Car {

    private final int MIN_NUMBER = 4;
    private String name;
    private int moveDistance;

    public Car(String name) {
        this.name = name;
    }

    public int move(int n) {
        if(n >= MIN_NUMBER) {
            this.moveDistance += n;
        }
        return this.moveDistance;
    }
}
