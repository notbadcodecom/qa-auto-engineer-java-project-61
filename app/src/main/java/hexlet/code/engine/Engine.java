package hexlet.code.engine;

import java.util.Scanner;

public final class Engine {

    public static final int GAMES_COUNT = 3;

    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    private static final String ASK_NAME_MESSAGE = "May I have your name? ";
    private static final String INPUT_ANSWER_MESSAGE = "Your answer: ";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";

    private static final String HELLO_TEXT_PATTERN = "Hello, %s!%n";
    private static final String QUESTION_MESSAGE_PATTEN = "Question: %s";
    private static final String WRONG_ANSWER_MESSAGE_PATTERN = "'%s' is wrong answer ;(. Correct answer was '%s'%n";
    private static final String TRY_AGAIN_MESSAGE_PATTERN = "Let's try again, %s!%n";
    private static final String CONGRATULATION_MESSAGE_PATTERN = "Congratulations, %s!%n";

    private Scanner scanner;

    public void run(String rule, String[][] gameData) {
        scanner = new Scanner(System.in);
        String userName = getUserName();
        if (gameData[0].length == 0) {
            scanner.close();
            return;
        }
        System.out.println(rule);
        for (String[] data : gameData) {
            String question = String.format(QUESTION_MESSAGE_PATTEN, data[0]);
            String correctAnswer = data[1];
            System.out.println(question);
            String userAnswer = readString(INPUT_ANSWER_MESSAGE).trim();
            if (!correctAnswer.equals(userAnswer)) {
                System.out.printf(WRONG_ANSWER_MESSAGE_PATTERN, userAnswer, correctAnswer);
                System.out.printf(TRY_AGAIN_MESSAGE_PATTERN, userName);
                scanner.close();
                return;
            }
            System.out.println(CORRECT_ANSWER_MESSAGE);
        }
        System.out.printf(CONGRATULATION_MESSAGE_PATTERN, userName);
        scanner.close();
    }

    private String getUserName() {
        System.out.println();
        System.out.println(WELCOME_MESSAGE);
        String userName = readString(ASK_NAME_MESSAGE).trim();
        System.out.printf(HELLO_TEXT_PATTERN, userName);
        return userName;
    }

    private String readString(String question) {
        System.out.print(question);
        return scanner.nextLine().trim();
    }
}
