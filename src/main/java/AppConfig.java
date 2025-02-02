import domain.game.LadderGameMapDecorator;
import domain.game.LadderGameMapDecoratorImpl;
import domain.game.LadderGameService;
import domain.game.LadderGameServiceImpl;
import view.input.InputView;
import view.input.InputViewImpl;
import view.input.Validator;
import view.input.ValidatorImpl;
import view.output.OutputView;
import view.output.OutputViewImpl;

public class AppConfig {

    private static AppConfig instance = new AppConfig();

    private AppConfig() {}

    public static AppConfig getInstance() {
        return instance;
    }

    public LadderGameService ladderGameService() {
        return LadderGameServiceImpl.getInstance(ladderGameMapDecorator());
    }

    public LadderGameMapDecorator ladderGameMapDecorator() {
        return LadderGameMapDecoratorImpl.getInstance();
    }

    public Validator validator() {
        return ValidatorImpl.getInstance();
    }

    public InputView inputView() {
        return InputViewImpl.getInstance(validator());
    }

    public OutputView outputView() {
        return OutputViewImpl.getInstance();
    }

    public void close() {
        try {
            inputView().close();
        } catch (Exception e) {
            System.out.println("자원 반환 실패");
        }
    }
}
