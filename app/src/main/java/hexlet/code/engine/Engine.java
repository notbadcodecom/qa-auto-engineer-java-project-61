package hexlet.code.engine;

import hexlet.code.game.Game;

import java.util.Scanner;

public final class Engine {

    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    private static final String ASK_NAME_MESSAGE = "May I have your name? ";
    private static final String INPUT_ANSWER_MESSAGE = "Your answer: ";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";

    private static final String HELLO_TEXT_PATTERN = "Hello, %s!";
    private static final String QUESTION_MESSAGE_PATTEN = "Question: %s";
    private static final String WRONG_ANSWER_MESSAGE_PATTERN = "'%s' is wrong answer ;(. Correct answer was '%s'";
    private static final String TRY_AGAIN_MESSAGE_PATTERN = "Let's try again, %s!";
    private static final String CONGRATULATION_MESSAGE_PATTERN = "Congratulations, %s!";

    private final Scanner scanner;

    public Engine() {
        this.scanner = new Scanner(System.in);
    }

    public void runGame(Game game) {
        String userName = getUserName();
        String[][] gameData = game.generateMultipleGameData();
        if (gameData[0].length == 0) {
            return;
        }
        writeMessage(game.getRule());
        for (String[] data : gameData) {
            String question = String.format(QUESTION_MESSAGE_PATTEN, data[0]);
            String correctAnswer = data[1];
            writeMessage(question);
            String userAnswer = readString(INPUT_ANSWER_MESSAGE).trim();
            if (!correctAnswer.equals(userAnswer)) {
                writeMessage(String.format(WRONG_ANSWER_MESSAGE_PATTERN, userAnswer, correctAnswer));
                writeMessage(String.format(TRY_AGAIN_MESSAGE_PATTERN, userName));
                return;
            }
            writeMessage(CORRECT_ANSWER_MESSAGE);
        }
        writeMessage(String.format(CONGRATULATION_MESSAGE_PATTERN, userName));
    }

    private String getUserName() {
        writeMessage("");
        writeMessage(WELCOME_MESSAGE);
        String userName = readString(ASK_NAME_MESSAGE).trim();
        String helloMessage = String.format(HELLO_TEXT_PATTERN, userName);
        writeMessage(helloMessage);
        return userName;
    }

    /*
        Обертку оставил, так как Sonar помечает System.out как 'Code smell' и просит заменить на логи
        Спорно конечно уменьшать через отдельный метод, но в целом не кажется, что метод усложняет чтение кода
     */
    private void writeMessage(String message) {
        System.out.println(message);
    }

    private String readString(String question) {
        System.out.print(question);
        return scanner.nextLine().trim();
    }
}
