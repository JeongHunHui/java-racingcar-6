package racingcar.controller;

import java.util.List;
import racingcar.dto.CarNames;
import racingcar.model.Racing;
import racingcar.view.RacingView;

public class RacingController {

    private final RacingView view;

    public RacingController(RacingView view) {
        this.view = view;
    }

    public void run() {
        final CarNames carNames = view.inputCarNames();
        final Racing racing = Racing.makeRacingByCarNames(carNames);
        Integer tryCount = view.inputTryCount();
        view.startPrintTryResult();
        for (Integer i = 0; i < tryCount; i++) {
            racing.tryCarsMoveForward();
            view.showRacingStatus(racing.getRacingStatus());
        }
        view.showRacingWinner(racing);
    }
}
