package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.service.Parser;
import racingcar.service.RacingService;
import racingcar.service.RandomGenerator;
import racingcar.view.InputView;

public class AppConfig {

    private final RacingController racingController;

    public AppConfig() {
        InputView inputView = new InputView();
        Parser parser = new Parser();
        RandomGenerator randomGenerator = new RandomGenerator();
        RacingService racingService = new RacingService(parser, randomGenerator);

        this.racingController = new RacingController(inputView, racingService);
    }

    public RacingController getRacingController() {
        return racingController;
    }
}
