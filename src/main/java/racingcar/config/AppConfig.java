package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.service.CarManager;
import racingcar.util.Parser;
import racingcar.service.RacingService;
import racingcar.service.RandomGenerator;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    private final RacingController racingController;

    public AppConfig() {
        Parser parser = new Parser();
        InputView inputView = new InputView(parser);
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        RandomGenerator randomGenerator = new RandomGenerator();
        CarManager carManager = new CarManager(validator);
        RacingService racingService = new RacingService(carManager, randomGenerator, validator);

        this.racingController = new RacingController(racingService, inputView, outputView);
    }

    public RacingController getRacingController() {
        return racingController;
    }
}
