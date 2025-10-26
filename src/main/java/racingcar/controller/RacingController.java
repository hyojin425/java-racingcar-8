package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;

public class RacingController {

    private final RacingService racingService;
    private final InputView inputView;

    public RacingController(InputView inputView, RacingService racingService) {
        this.inputView = inputView;
        this.racingService = racingService;
    }

    public void start() {
        initCars();
        startRepeatRacing();
    }

    private void initCars() {
        racingService.initCars(inputView.getCarNames());
    }

    private void startRepeatRacing() {
        racingService.racing();
    }
}
