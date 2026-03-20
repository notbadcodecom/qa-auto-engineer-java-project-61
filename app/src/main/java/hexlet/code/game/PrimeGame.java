package hexlet.code.game;

import java.util.Map;

public final class PrimeGame extends Game {

    private static final String RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_PRIME_VALUE = 997;
    private final Map<Boolean, String> primeToAnswerMap = Map.of(true, "yes", false, "no");
    private static final int ODD = 3;

    public PrimeGame() {
        super(RULE);
    }

    /*
        Использовал отдельную переменную ODD = 3, так как получаю ошибку тестов на магические числа:
            Error: | [ant:checkstyle] [ERROR] /project/code/app/src/main/java/hexlet/code/game/PrimeGame.java:28:19: '3'
            is a magic number. [MagicNumber]
     */
    @Override
    protected String[] generateSingleGameData() {
        int randomNumber = getRandom(LOWER_BOUND, MAX_PRIME_VALUE);
        String answer = primeToAnswerMap.get(isPrime(randomNumber));
        return new String[]{Integer.toString(randomNumber), answer};
    }

    private boolean isPrime(int number) {
        if (number < 2 || number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = ODD; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
