package hexlet.code.menu.item;

import hexlet.code.menu.service.UserInteractionService;

import java.util.Map;

public final class EvenMenuItem extends MenuItem {

    private static final String RULES_MESSAGE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private final Map<Boolean, String> isEvenToAnswerMap = Map.of(true, "yes", false, "no");
    private static final int EVEN = 2;

    private final UserInteractionService userInteractionService;

    public EvenMenuItem(UserInteractionService interactionService) {
        super(MenuTextOrder.EVEN);
        this.userInteractionService = interactionService;
    }

    @Override
    public void execute() {
        String userName = userInteractionService.getUserName();
        userInteractionService.writeMessage(RULES_MESSAGE);
        int correctAnswerCounter = 0;
        while (correctAnswerCounter < NUMBER_OF_GAMES) {
            int randomNumber = generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            correctAnswerCounter = userInteractionService.checkAndCountCorrectAnswer(
                    Integer.toString(randomNumber),
                    isEvenToAnswerMap.get(randomNumber % EVEN == 0),
                    correctAnswerCounter,
                    userName
            );
            if (correctAnswerCounter == 0) {
                return;
            }
        }
        userInteractionService.writeCongratulateMessage(userName);
    }
}
