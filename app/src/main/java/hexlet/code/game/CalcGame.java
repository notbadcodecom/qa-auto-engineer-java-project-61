package hexlet.code.game;

import java.util.List;

public final class CalcGame extends Game {

    private static final String RULE = "What is the result of the expression?";
    private static final List<String> MATH_OPERATORS = List.of("+", "-", "*");
    private static final String MATH_EXPRESSION_PATTERN = "%d %s %d";

    public CalcGame() {
        super(RULE);
    }

    @Override
    protected String[] generateGameData() {
        int first = getRandom(LOWER_BOUND, UPPER_BOUND);
        int second = getRandom(LOWER_BOUND, UPPER_BOUND);
        String operator = MATH_OPERATORS.get(getRandom(0, MATH_OPERATORS.size() - 1));
        String question = String.format(MATH_EXPRESSION_PATTERN, first, operator, second);
        return new String[]{question, getAnswer(first, second, operator)};
    }

    private String getAnswer(int first, int second, String operator) {
        Integer result = switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
        return result.toString();
    }
}
