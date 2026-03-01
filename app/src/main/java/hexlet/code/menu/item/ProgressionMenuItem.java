package hexlet.code.menu.item;

import hexlet.code.menu.service.UserInteractionService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class ProgressionMenuItem extends MenuItem {

    private static final String RULES_MESSAGE = "What number is missing in the progression?";

    private static final int FIRST_ELEMENT_BOUND = 50;
    private static final int DIFFERENCE_BOUND = 9;
    private static final int SEQUENCE_MAX_BOUND = 10;
    private static final int SEQUENCE_MIN_BOUND = 5;
    private static final int MIN_INDEX_VALUE = 0;

    private final UserInteractionService userInteractionService;

    public ProgressionMenuItem(UserInteractionService interactionService) {
        super(MenuTextOrder.PROGRESSION);
        this.userInteractionService = interactionService;
    }

    @Override
    public void execute() {
        String userName = userInteractionService.getUserName();
        userInteractionService.writeMessage(RULES_MESSAGE);
        int correctAnswerCounter = 0;
        while (correctAnswerCounter < NUMBER_OF_GAMES) {
            int firstElement = generateRandomInt(LOWER_BOUND, FIRST_ELEMENT_BOUND);
            int difference = generateRandomInt(LOWER_BOUND, DIFFERENCE_BOUND);
            int numberOfTerms = generateRandomInt(SEQUENCE_MIN_BOUND, SEQUENCE_MAX_BOUND);
            List<Integer> sequence = IntStream.iterate(firstElement, elem -> elem + difference)
                    .limit(numberOfTerms)
                    .boxed()
                    .toList();
            int answerIndex = generateRandomInt(MIN_INDEX_VALUE, numberOfTerms);
            Integer correctAnswer = sequence.get(answerIndex);
            String questionMessage = IntStream.range(MIN_INDEX_VALUE, sequence.size())
                    .mapToObj(index -> index == answerIndex ? ".." : sequence.get(index).toString())
                    .collect(Collectors.joining(" "));
            correctAnswerCounter = userInteractionService.checkAndCountCorrectAnswer(
                    questionMessage,
                    correctAnswer.toString(),
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
