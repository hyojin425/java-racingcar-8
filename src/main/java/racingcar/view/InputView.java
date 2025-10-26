package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Parser;

import java.util.List;

public class InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_REPEAT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private final Parser parser;

    public InputView(Parser parser) {
        this.parser = parser;
    }

    public List<String> getCarNames() {
        System.out.print(INPUT_CAR_NAMES_MESSAGE);
        return parser.parseCarName(Console.readLine());
    }

    public int getRepeatCount() {
        System.out.print(INPUT_REPEAT_COUNT_MESSAGE);
        return parser.parseRepeatCountAsInt(Console.readLine());
    }
}
