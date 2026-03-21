package hexlet.code.game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class ProgressionGame extends Game {

    private static final String RULE = "What number is missing in the progression?";

    private static final int FIRST_ELEMENT_BOUND = 50;
    private static final int DIFFERENCE_BOUND = 9;
    private static final int SEQUENCE_MAX_BOUND = 10;
    private static final int SEQUENCE_MIN_BOUND = 5;

    public ProgressionGame() {
        super(RULE);
    }

    @Override
    protected String[] generateGameData() {
        int firstElement = getRandom(LOWER_BOUND, FIRST_ELEMENT_BOUND);
        int difference = getRandom(LOWER_BOUND, DIFFERENCE_BOUND);
        int numberOfTerms = getRandom(SEQUENCE_MIN_BOUND, SEQUENCE_MAX_BOUND);
        List<String> sequence = generateSequence(firstElement, difference, numberOfTerms);
        int answerIndex = getRandom(0, numberOfTerms);
        String answer = sequence.get(answerIndex);
        sequence.set(answerIndex, "..");
        return new String[]{String.join(" ", sequence), answer};
    }

    public List<String> generateSequence(
            int firstElement,
            int difference,
            int numberOfTerms
    ) {
        return IntStream.iterate(firstElement, elem -> elem + difference)
                .limit(numberOfTerms)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
