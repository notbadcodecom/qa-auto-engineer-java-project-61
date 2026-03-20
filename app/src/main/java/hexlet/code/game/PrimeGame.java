package hexlet.code.game;

import java.util.Map;

public final class PrimeGame extends Game {

    private static final String RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_PRIME_VALUE = 997;
    private static final int MIN_EVEN = 2;
    private static final int MIN_ODD = 3;
    private final Map<Boolean, String> primeToAnswerMap = Map.of(true, "yes", false, "no");

    public PrimeGame() {
        super(RULE);
    }

    @Override
    protected String[] generateSingleGameData() {
        int randomNumber = getRandom(LOWER_BOUND, MAX_PRIME_VALUE);
        String answer = primeToAnswerMap.get(isPrime(randomNumber));
        return new String[]{Integer.toString(randomNumber), answer};
    }

    /*
      Вынес переменные в поля класса из-за падений тестов на проверку магических чисел:
      - MIN_EVEN
      - MIN_ODD
    */
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
