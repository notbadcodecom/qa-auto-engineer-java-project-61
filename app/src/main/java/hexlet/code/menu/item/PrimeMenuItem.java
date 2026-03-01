package hexlet.code.menu.item;

import hexlet.code.menu.service.UserInteractionService;

import java.util.Map;

public final class PrimeMenuItem extends MenuItem {

    private static final String RULES_MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_PRIME_VALUE = 997;
    private static final int MIN_EVEN = 2;
    private static final int MIN_ODD = 3;
    private final Map<Boolean, String> primeToAnswerMap = Map.of(true, "yes", false, "no");

    private final UserInteractionService userInteractionService;

    public PrimeMenuItem(UserInteractionService interactionService) {
        super(MenuTextOrder.PRIME);
        this.userInteractionService = interactionService;
    }

    @Override
    public void execute() {
        String userName = userInteractionService.getUserName();
        userInteractionService.writeMessage(RULES_MESSAGE);
        int correctAnswerCounter = 0;
        while (correctAnswerCounter < NUMBER_OF_GAMES) {
            int randomNumber = generateRandomInt(LOWER_BOUND, MAX_PRIME_VALUE);
            correctAnswerCounter = userInteractionService.checkAndCountCorrectAnswer(
                    Integer.toString(randomNumber),
                    primeToAnswerMap.get(isPrime(randomNumber)),
                    correctAnswerCounter,
                    userName
            );
            if (correctAnswerCounter == 0) {
                return;
            }
        }
        userInteractionService.writeCongratulateMessage(userName);
    }

    private boolean isPrime(int number) {
        if (number < MIN_EVEN || number % MIN_EVEN == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = MIN_ODD; i <= sqrt; i += MIN_EVEN) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
