package hexlet.code.game;

import hexlet.code.engine.Engine;

import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public abstract class Game {

    protected static final int UPPER_BOUND = 100;
    protected static final int LOWER_BOUND = 1;

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    private final Engine engine;
    private final String rule;

    protected Game(String gameRule) {
        this.rule = gameRule;
        this.engine = new Engine();
    }

    public final void run() {
        String[][] gameData = IntStream.range(0, Engine.GAMES_COUNT)
                .mapToObj(i -> this.generateGameData())
                .toArray(String[][]::new);
        engine.run(rule, gameData);
    }

    protected abstract String[] generateGameData();

    public static int getRandom(int min, int max) {
        return RANDOM.nextInt(min, max);
    }
}
