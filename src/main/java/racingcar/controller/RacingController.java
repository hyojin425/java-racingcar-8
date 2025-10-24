package racingcar.controller;

import racingcar.view.InputView;

public class RacingController {

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    private final InputView inputView;



    public void racingStart() {
        String carNames = inputView.getCarName();
    }
}
