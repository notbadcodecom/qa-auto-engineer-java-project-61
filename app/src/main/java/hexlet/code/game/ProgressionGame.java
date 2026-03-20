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
    protected String[] generateSingleGameData() {
        int numberOfTerms = getRandom(SEQUENCE_MIN_BOUND, SEQUENCE_MAX_BOUND);
        List<Integer> sequence = generateSequence(numberOfTerms);
        int answerIndex = getRandom(0, numberOfTerms);
        String question = IntStream.range(0, sequence.size())
                .mapToObj(index -> index == answerIndex ? ".." : sequence.get(index).toString())
                .collect(Collectors.joining(" "));
        String answer = sequence.get(answerIndex).toString();
        return new String[]{question, answer};
    }

    public List<Integer> generateSequence(int numberOfTerms) {
        int firstElement = getRandom(LOWER_BOUND, FIRST_ELEMENT_BOUND);
        int difference = getRandom(LOWER_BOUND, DIFFERENCE_BOUND);
        return IntStream.iterate(firstElement, elem -> elem + difference)
                .limit(numberOfTerms)
                .boxed()
                .toList();
    }
}
