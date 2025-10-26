package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final RacingService racingService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(RacingService racingService, InputView inputView, OutputView outputView) {
        this.racingService = racingService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        initCars();
        startRepeatRacing();
    }

    private void initCars() {
        racingService.initCars(inputView.getCarNames());
    }

    private void startRepeatRacing() {
        int repeatCount = Integer.parseInt(inputView.getRepeatCount());
        outputView.printResultHeader();
        printRepeatResult(repeatCount);
    }

    private void printRepeatResult(int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            outputView.printRacing(racingService.racing());
        }
    }
}
