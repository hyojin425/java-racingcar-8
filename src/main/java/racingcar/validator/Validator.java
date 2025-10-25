package racingcar.validator;

public class Validator {

    private final int MIN_NUMBER = 4;

    public boolean isAtLeastMin(int number) {
        return number >= MIN_NUMBER;
    }
}
