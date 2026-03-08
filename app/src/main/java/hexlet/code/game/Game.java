package hexlet.code.game;

import java.util.random.RandomGenerator;

public abstract class Game {

    protected static final int UPPER_BOUND = 100;
    protected static final int LOWER_BOUND = 1;

    private static final int GAMES_COUNT = 3;
    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    protected final String rule;

    public Game(String gameRule) {
        this.rule = gameRule;
    }

    public abstract GameDataNode generateGameDataNode();

    public final String getRule() {
        return rule;
    }

    public final GameDataNode getGameDataLinkedList() {
        GameDataNode head = generateGameDataNode();
        GameDataNode current = head;
        for (int i = 1; i < GAMES_COUNT && current != null; i++) {
            current.setNext(generateGameDataNode());
            current = current.getNext();
        }
        return head;
    }

    public static int getRandom(int min, int max) {
        return RANDOM.nextInt(min, max);
    }
}
