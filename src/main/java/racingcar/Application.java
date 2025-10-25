package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.Parser;
import racingcar.service.RacingService;
import racingcar.service.RandomGenerator;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new InputView(), new RacingService(new Parser(), new RandomGenerator()));
        racingController.racingStart();
    }
}

