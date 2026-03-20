package hexlet.code.game;

import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public abstract class Game {

    protected static final int UPPER_BOUND = 100;
    protected static final int LOWER_BOUND = 1;

    private static final int GAMES_COUNT = 3;
    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    private final String rule;

    protected Game(String gameRule) {
        this.rule = gameRule;
    }

    public final String getRule() {
        return rule;
    }

    public final String[][] generateMultipleGameData() {
        return IntStream.range(0, GAMES_COUNT)
                .mapToObj(i -> generateSingleGameData())
                .toArray(String[][]::new);
    }

    protected abstract String[] generateSingleGameData();

    public static int getRandom(int min, int max) {
        return RANDOM.nextInt(min, max);
    }
}
