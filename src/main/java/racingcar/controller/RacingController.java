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
        printWinner();
    }

    private void initCars() {
        racingService.initCars(inputView.getCarNames());
    }

    private void startRepeatRacing() {
        int repeatCount = inputView.getRepeatCount();
        racingService.validRepeatCount(repeatCount);
        printRepeatResult(repeatCount);
    }

    private void printRepeatResult(int repeatCount) {
        outputView.printResultHeader();
        for (int i = 0; i < repeatCount; i++) {
            outputView.printRacing(racingService.racing());
        }
    }

    private void printWinner() {
        outputView.printWinner(racingService.getWinner());
    }
}
