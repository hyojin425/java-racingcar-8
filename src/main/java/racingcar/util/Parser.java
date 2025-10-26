package racingcar.util;

import java.util.List;

public class Parser {

    private final String DELIMITER = ",";

    public List<String> parseCarName(String carName) {
        return List.of(carName.split(DELIMITER));
    }

    public int parseRepeatCountAsInt(String repeatCount) {
        return Integer.parseInt(repeatCount);
    }
}
