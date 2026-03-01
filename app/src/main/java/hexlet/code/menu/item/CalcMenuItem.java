package hexlet.code.menu.item;

import hexlet.code.menu.service.UserInteractionService;

import java.util.List;

public final class CalcMenuItem extends MenuItem {

    private static final String RULES_MESSAGE = "What is the result of the expression?";

    private static final List<String> MATH_OPERATORS = List.of("+", "-", "*");
    private static final String MATH_EXPRESSION_PATTERN = "%d %s %d";
    private static final int MIN_MATH_OPERATORS_INDEX = 0;
    private static final int MAX_MATH_OPERATORS_INDEX = MATH_OPERATORS.size() - 1;

    private final UserInteractionService userInteractionService;

    public CalcMenuItem(UserInteractionService interactionService) {
        super(MenuTextOrder.CALC);
        this.userInteractionService = interactionService;
    }

    @Override
    public void execute() {
        String userName = userInteractionService.getUserName();
        userInteractionService.writeMessage(RULES_MESSAGE);
        int correctAnswerCounter = 0;
        while (correctAnswerCounter < NUMBER_OF_GAMES) {
            int first = generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            int second = generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            String operator = MATH_OPERATORS.get(generateRandomInt(MIN_MATH_OPERATORS_INDEX, MAX_MATH_OPERATORS_INDEX));
            Integer expressionResult = switch (operator) {
                case "+" -> first + second;
                case "-" -> first - second;
                case "*" -> first * second;
                default -> throw new IllegalStateException("Unexpected value: " + operator);
            };
            String questionMessage = String.format(MATH_EXPRESSION_PATTERN, first, operator, second);
            correctAnswerCounter = userInteractionService.checkAndCountCorrectAnswer(
                    questionMessage,
                    expressionResult.toString(),
                    correctAnswerCounter,
                    userName
            );
            if (correctAnswerCounter == 0) {
                return;
            }
        }
        userInteractionService.writeCongratulateMessage(userName);
    }
}
