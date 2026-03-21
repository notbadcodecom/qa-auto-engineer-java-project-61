package hexlet.code.game;

public final class GCDGame extends Game {

    private static final String RULE = "Find the greatest common divisor of given numbers.";
    private static final String QUESTION_PATTERN = "%d %d";
    private static final int UPPER_BOUND = 300;
    private static final int MIN_GCD_VALUE = 2;

    public GCDGame() {
        super(RULE);
    }

    @Override
    protected String[] generateGameData() {
        int firstMultiplier = getRandom(LOWER_BOUND, UPPER_BOUND);
        int secondMultiplier  = getRandom(LOWER_BOUND, UPPER_BOUND);
        int gcdNumber = getGCDNumber(firstMultiplier, secondMultiplier);

        while (gcdNumber < MIN_GCD_VALUE) {
            secondMultiplier = getRandom(LOWER_BOUND, UPPER_BOUND);
            gcdNumber = getGCDNumber(firstMultiplier, secondMultiplier);
        }

        String question = String.format(QUESTION_PATTERN, firstMultiplier, secondMultiplier);
        return new String[]{question, Integer.toString(gcdNumber)};
    }

    private int getGCDNumber(int firstMultiplier, int secondMultiplier) {
        if (secondMultiplier == 0) {
            return firstMultiplier;
        }
        return getGCDNumber(secondMultiplier, firstMultiplier % secondMultiplier);
    }
}
