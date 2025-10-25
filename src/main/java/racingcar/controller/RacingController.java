package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;

public class RacingController {

    private final RacingService racingService;

    public RacingController(InputView inputView, RacingService racingService) {
        this.inputView = inputView;
        this.racingService = racingService;
    }

    private final InputView inputView;

    public void racingStart() {
        racingService.initCars(inputView.getCarNames());
        racingService.racing();
    }
}
