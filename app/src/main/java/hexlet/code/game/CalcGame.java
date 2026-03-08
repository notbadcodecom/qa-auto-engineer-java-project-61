package hexlet.code.game;

import java.util.List;

public final class CalcGame extends Game {

    private static final String RULE = "What is the result of the expression?";
    private static final List<String> MATH_OPERATORS = List.of("+", "-", "*");
    private static final String MATH_EXPRESSION_PATTERN = "%d %s %d";
    private static final int MIN_MATH_OPERATORS_INDEX = 0;
    private static final int MAX_MATH_OPERATORS_INDEX = MATH_OPERATORS.size() - 1;

    public CalcGame() {
        super(RULE);
    }

    @Override
    public GameDataNode generateGameDataNode() {
        int first = getRandom(LOWER_BOUND, UPPER_BOUND);
        int second = getRandom(LOWER_BOUND, UPPER_BOUND);
        String operator = MATH_OPERATORS.get(getRandom(MIN_MATH_OPERATORS_INDEX, MAX_MATH_OPERATORS_INDEX));
        Integer answer = switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
        String question = String.format(MATH_EXPRESSION_PATTERN, first, operator, second);
        return new GameDataNode(question, answer.toString());
    }
}
