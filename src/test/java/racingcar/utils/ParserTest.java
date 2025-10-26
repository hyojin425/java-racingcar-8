package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ParserTest {

    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser();
    }

    @DisplayName("문자열이 들어올 경우 콤마를 기준으로 구분된 문자열 리스트로 반환한다.")
    @Test
    void parseCarName_ShouldReturnListOfCarNames() {
        // given
        String carNames = "pobi,woni,jun";

        // when
        List<String> result = parser.parseCarName(carNames);

        // then
        assertThat(result.size()).isEqualTo(3);
    }

    @DisplayName("정수 문자열이 들어올 경우 int로 변환하여 반환한다.")
    @Test
    void parseRepeatCountAsInt_ShouldReturnInt() {
        // given
        String repeatCount = "4";

        // when
        int result = parser.parseRepeatCountAsInt(repeatCount);

        // then
        assertThat(result).isEqualTo(4);
    }
}
