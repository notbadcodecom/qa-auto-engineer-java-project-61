package hexlet.code.menu.service;

import java.util.Scanner;

public final class UserInteractionService {

    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    private static final String INPUT_QUESTION_MESSAGE = "May I have your name? ";
    private static final String HELLO_TEXT_PATTERN = "Hello, %s!";

    private static final String INPUT_ANSWER_MESSAGE = "Your answer: ";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String QUESTION_MESSAGE_PATTEN = "Question: %s";
    private static final String WRONG_ANSWER_MESSAGE_PATTERN = "'%s' is wrong answer ;(. Correct answer was '%s'";
    private static final String TRY_AGAIN_MESSAGE_PATTERN = "Let's try again, %s!";
    private static final String CONGRATULATION_MESSAGE_PATTERN = "Congratulations, %s!";

    private final Scanner scanner;

    public UserInteractionService() {
        this.scanner = new Scanner(System.in);
    }

    public Integer readInt(String question) {
        System.out.print(question);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (RuntimeException e) {
            return null;
        }
    }

    public String readString(String question) {
        System.out.print(question);
        return scanner.nextLine().trim();
    }

    public String getUserName() {
        writeMessage("");
        writeMessage(WELCOME_MESSAGE);
        String userName = readString(INPUT_QUESTION_MESSAGE);
        String helloMessage = String.format(HELLO_TEXT_PATTERN, userName);
        writeMessage(helloMessage);
        return userName;
    }

    public void writeMessage(String message) {
        System.out.println(message);
    }

    public void writeWrongAnswerMessage(String wrongAnswer, String correctAnswer, String userName) {
        String wrongAnswerMessage = String.format(WRONG_ANSWER_MESSAGE_PATTERN, wrongAnswer, correctAnswer);
        writeMessage(wrongAnswerMessage);
        String tryAgainMessage = String.format(TRY_AGAIN_MESSAGE_PATTERN, userName);
        writeMessage(tryAgainMessage);
    }

    public void writeCongratulateMessage(String userName) {
        String congratulationMessage = String.format(CONGRATULATION_MESSAGE_PATTERN, userName);
        writeMessage(congratulationMessage);
    }

    public void writeQuestionMessage(String question) {
        String questionMessage = String.format(QUESTION_MESSAGE_PATTEN, question);
        writeMessage(questionMessage);
    }

    public String getAnswer() {
        return readString(INPUT_ANSWER_MESSAGE).trim();
    }

    public void writeCorrectMessage() {
        writeMessage(CORRECT_ANSWER_MESSAGE);
    }

    public int checkAndCountCorrectAnswer(
            String question,
            String correctAnswer,
            Integer currentCorrectAnswerCounter,
            String userName
    ) {
        writeQuestionMessage(question);
        String answer = getAnswer().trim();
        if (correctAnswer.equals(answer)) {
            currentCorrectAnswerCounter++;
            writeCorrectMessage();
        } else {
            currentCorrectAnswerCounter = 0;
            writeWrongAnswerMessage(answer, correctAnswer, userName);
        }
        return currentCorrectAnswerCounter;
    }
}
