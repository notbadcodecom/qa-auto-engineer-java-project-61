package hexlet.code.engine;

import hexlet.code.game.GameDataNode;

import java.util.Scanner;

public final class EngineService {

    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    private static final String ASK_NAME_MESSAGE = "May I have your name? ";
    private static final String HELLO_TEXT_PATTERN = "Hello, %s!";
    private static final String INPUT_ANSWER_MESSAGE = "Your answer: ";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String QUESTION_MESSAGE_PATTEN = "Question: %s";
    private static final String WRONG_ANSWER_MESSAGE_PATTERN = "'%s' is wrong answer ;(. Correct answer was '%s'";
    private static final String TRY_AGAIN_MESSAGE_PATTERN = "Let's try again, %s!";
    private static final String CONGRATULATION_MESSAGE_PATTERN = "Congratulations, %s!";

    private final Scanner scanner;

    public EngineService() {
        this.scanner = new Scanner(System.in);
    }

    public void runGame(String rules, GameDataNode gameData) {
        String userName = getUserName();
        if (gameData == null) {
            return;
        }
        writeMessage(rules);
        while (gameData != null) {
            writeQuestionMessage(gameData.getQuestion());
            String userAnswer = getAnswer();
            if (!gameData.getAnswer().equals(userAnswer)) {
                writeWrongAnswerMessage(userAnswer, gameData.getAnswer(), userName);
                return;
            }
            gameData = gameData.getNext();
            writeCorrectMessage();
        }
        writeCongratulateMessage(userName);
    }

    private String getUserName() {
        writeMessage("");
        writeMessage(WELCOME_MESSAGE);
        String userName = readString(ASK_NAME_MESSAGE);
        String helloMessage = String.format(HELLO_TEXT_PATTERN, userName);
        writeMessage(helloMessage);
        return userName;
    }

    private void writeMessage(String message) {
        System.out.println(message);
    }

    private String readString(String question) {
        System.out.print(question);
        return scanner.nextLine().trim();
    }

    private void writeWrongAnswerMessage(String wrongAnswer, String correctAnswer, String userName) {
        writeMessage(String.format(WRONG_ANSWER_MESSAGE_PATTERN, wrongAnswer, correctAnswer));
        writeMessage(String.format(TRY_AGAIN_MESSAGE_PATTERN, userName));
    }

    private void writeCongratulateMessage(String userName) {
        String congratulationMessage = String.format(CONGRATULATION_MESSAGE_PATTERN, userName);
        writeMessage(congratulationMessage);
    }

    private void writeQuestionMessage(String question) {
        String questionMessage = String.format(QUESTION_MESSAGE_PATTEN, question);
        writeMessage(questionMessage);
    }

    private String getAnswer() {
        return readString(INPUT_ANSWER_MESSAGE).trim();
    }

    private void writeCorrectMessage() {
        writeMessage(CORRECT_ANSWER_MESSAGE);
    }
}
