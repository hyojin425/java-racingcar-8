package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator implements NumberGenerator{

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
