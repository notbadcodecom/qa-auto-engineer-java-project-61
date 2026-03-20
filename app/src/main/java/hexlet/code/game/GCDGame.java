package hexlet.code.game;

public final class GCDGame extends Game {

    private static final String RULE = "Find the greatest common divisor of given numbers.";
    private static final String QUESTION_PATTERN = "%d %d";
    private static final int REDUCED_RANDOM_NUMBER_BOUND = 4; // small for test
    private static final int UPPER_GDC_BOUND = 7; // small for tests

    public GCDGame() {
        super(RULE);
    }

    @Override
    protected String[] generateSingleGameData() {
        GCDNumber gcdNumber = generateGCDNumber();
        String question = String.format(QUESTION_PATTERN, gcdNumber.first(), gcdNumber.second());
        return new String[]{question, Integer.toString(gcdNumber.gcd())};
    }

    private GCDNumber generateGCDNumber() {
        int first = getRandom(LOWER_BOUND, REDUCED_RANDOM_NUMBER_BOUND);
        int second = getRandom(LOWER_BOUND, REDUCED_RANDOM_NUMBER_BOUND);
        while (first == second) {
            second = getRandom(LOWER_BOUND, REDUCED_RANDOM_NUMBER_BOUND);
        }
        int gcd = getRandom(LOWER_BOUND, UPPER_GDC_BOUND);
        return new GCDNumber(gcd, gcd * first, gcd *  second);
    }

    private record GCDNumber(
            Integer gcd,
            Integer first,
            Integer second
    ) {
    }
}
