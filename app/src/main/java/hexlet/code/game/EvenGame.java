package hexlet.code.game;

import java.util.Map;

public final class EvenGame extends Game {

    private static final String RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private final Map<Boolean, String> isEvenToAnswerMap = Map.of(true, "yes", false, "no");

    public EvenGame() {
        super(RULE);
    }

    @Override
    protected String[] generateGameData() {
        int randomNumber = getRandom(LOWER_BOUND, UPPER_BOUND);
        String answer = isEvenToAnswerMap.get(randomNumber % 2 == 0);
        return new String[]{Integer.toString(randomNumber), answer};
    }
}
