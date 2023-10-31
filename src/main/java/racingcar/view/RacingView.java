package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.RacingMessage;
import racingcar.dto.CarInfo;
import racingcar.dto.CarNames;
import racingcar.dto.RacingStatus;
import racingcar.dto.TryCount;
import racingcar.model.Racing;

public class RacingView {

    private static final String RACING_PROGRESS_FORMAT = "%s : %s";
    private static final String RACING_PROGRESS_BAR = "-";
    private static final String NEW_LINE = "\n";
    private static final String WINNER_NAME_SEPARATOR = ", ";
    private final InputView inputView;

    public RacingView(InputView inputView) {
        this.inputView = inputView;
    }

    public CarNames inputCarNames() {
        System.out.println(RacingMessage.INPUT_CAR_NAME);
        return inputView.readCarNames();
    }

    public TryCount inputTryCount() {
        System.out.println(RacingMessage.INPUT_TRY_COUNT);
        return inputView.readTryCount();
    }

    public void startPrintTryResult() {
        System.out.println(RacingMessage.TRY_RESULT);
    }

    public void showRacingStatus(RacingStatus racingStatus) {
        System.out.println(getRacingStatusMessage(racingStatus));
    }

    public void showRacingWinner(Racing racing) {
        List<String> winnerNames = racing.getWinningCarNames();
        System.out.println(RacingMessage.RACING_WINNER + winnerNames.stream()
            .collect(Collectors.joining(WINNER_NAME_SEPARATOR)));
    }

    private String getRacingStatusMessage(RacingStatus racingStatus) {
        return racingStatus.getCarInfos().stream().map(this::getCarInfoMessage)
            .collect(Collectors.joining(NEW_LINE)) + NEW_LINE;
    }

    private String getCarInfoMessage(CarInfo carInfo) {
        return String.format(RACING_PROGRESS_FORMAT, carInfo.getName(),
            RACING_PROGRESS_BAR.repeat(carInfo.getMoveCount()));
    }
}
