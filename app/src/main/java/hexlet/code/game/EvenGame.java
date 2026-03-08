package hexlet.code.game;

import java.util.Map;

public final class EvenGame extends Game {

    private static final String RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private final Map<Boolean, String> isEvenToAnswerMap = Map.of(true, "yes", false, "no");
    private static final int EVEN = 2;

    public EvenGame() {
        super(RULE);
    }

    @Override
    public GameDataNode generateGameDataNode() {
        int randomNumber = getRandom(LOWER_BOUND, UPPER_BOUND);
        String question = String.valueOf(randomNumber);
        String answer = isEvenToAnswerMap.get(randomNumber % EVEN == 0);
        return new GameDataNode(question, answer);
    }
}
