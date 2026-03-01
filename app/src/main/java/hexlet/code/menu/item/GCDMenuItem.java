package hexlet.code.menu.item;

import hexlet.code.dto.GCDNumber;
import hexlet.code.menu.service.UserInteractionService;

public final class GCDMenuItem extends MenuItem {

    private static final String RULES_MESSAGE = "Find the greatest common divisor of given numbers.";

    private static final String QUESTION_PATTERN = "%d %d";
    private static final int REDUCED_RANDOM_NUMBER_BOUND = 4; // small for test
    private static final int UPPER_GDC_BOUND = 7; // small for tests

    private final UserInteractionService userInteractionService;

    public GCDMenuItem(UserInteractionService interactionService) {
        super(MenuTextOrder.GCD);
        this.userInteractionService = interactionService;
    }

    @Override
    public void execute() {
        String userName = userInteractionService.getUserName();
        userInteractionService.writeMessage(RULES_MESSAGE);
        int correctAnswerCounter = 0;
        while (correctAnswerCounter < NUMBER_OF_GAMES) {
            GCDNumber gcdNumber = generateGCDNumber();
            String questionMessage = String.format(QUESTION_PATTERN, gcdNumber.first(), gcdNumber.second());
            correctAnswerCounter = userInteractionService.checkAndCountCorrectAnswer(
                    questionMessage,
                    Integer.toString(gcdNumber.gcd()),
                    correctAnswerCounter,
                    userName
            );
            if (correctAnswerCounter == 0) {
                return;
            }
        }
        userInteractionService.writeCongratulateMessage(userName);
    }

    private GCDNumber generateGCDNumber() {
        int first = generateRandomInt(LOWER_BOUND, REDUCED_RANDOM_NUMBER_BOUND);
        int second = generateRandomInt(LOWER_BOUND, REDUCED_RANDOM_NUMBER_BOUND);
        while (first == second) {
            second = generateRandomInt(LOWER_BOUND, REDUCED_RANDOM_NUMBER_BOUND);
        }
        int gcd = generateRandomInt(LOWER_BOUND, UPPER_GDC_BOUND);
        return new GCDNumber(gcd, gcd * first, gcd *  second);
    }
}
