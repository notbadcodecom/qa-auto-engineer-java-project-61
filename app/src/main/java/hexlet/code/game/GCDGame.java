package hexlet.code.game;

public final class GCDGame extends Game {

    private static final String RULE = "Find the greatest common divisor of given numbers.";
    private static final String QUESTION_PATTERN = "%d %d";
    private static final int UPPER_BOUND = 7; // small for test

    public GCDGame() {
        super(RULE);
    }

    @Override
    protected String[] generateGameData() {
        GCDNumber gcd = generateGCDNumber(
                getRandom(LOWER_BOUND, UPPER_BOUND),
                getRandom(LOWER_BOUND, UPPER_BOUND)
        );
        String question = String.format(QUESTION_PATTERN, gcd.first(), gcd.second());
        return new String[]{question, Integer.toString(gcd.gcd())};
    }

    private GCDNumber generateGCDNumber(int firstMultiplier, int secondMultiplier) {
        int gcd = getRandom(LOWER_BOUND, UPPER_BOUND);
        if (firstMultiplier == secondMultiplier) {
            gcd = firstMultiplier;
            return new GCDNumber(gcd, firstMultiplier, secondMultiplier);
        }
        return new GCDNumber(gcd, gcd * firstMultiplier, gcd *  secondMultiplier);
    }

    private record GCDNumber(
            Integer gcd,
            Integer first,
            Integer second
    ) {
    }
}
