package hexlet.code;

import hexlet.code.engine.Engine;
import hexlet.code.game.CalcGame;
import hexlet.code.game.EvenGame;
import hexlet.code.game.GCDGame;
import hexlet.code.game.Game;
import hexlet.code.game.GreetGame;
import hexlet.code.game.PrimeGame;
import hexlet.code.game.ProgressionGame;
import hexlet.code.menu.MenuItem;

import java.util.Scanner;

public class App {

    private static final String INTRO_MESSAGE = "Please enter the game number and press Enter.%n";
    private static final String USER_CHOICE = "Your choice: ";
    private static final String MENU_ITEM_TEXT_PATTERN = "%d - %s%n";

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        displayMenu();
        MenuItem userChoice = readChoice();
        if (userChoice == MenuItem.EXIT) {
            return;
        }
        try {
            Game game = createGame(userChoice);
            new Engine().runGame(game);
        } catch (IllegalArgumentException e) {
            System.out.printf(e.getMessage());
        }
        scanner.close();
    }

    private static Game createGame(MenuItem menuItem) {
        return switch (menuItem) {
            case GREET -> new GreetGame();
            case EVEN -> new EvenGame();
            case CALC -> new CalcGame();
            case GCD -> new GCDGame();
            case PRIME -> new PrimeGame();
            case PROGRESSION -> new ProgressionGame();
            default -> throw new IllegalArgumentException(String.format("Could not create a game for %s", menuItem));
        };
    }

    private static void displayMenu() {
        System.out.printf(INTRO_MESSAGE);
        for (MenuItem menuItem : MenuItem.values()) {
            System.out.printf(MENU_ITEM_TEXT_PATTERN, menuItem.getOrder(), menuItem.getText());
        }
    }

    private static MenuItem readChoice() {
        System.out.printf(USER_CHOICE);
        try {
            return MenuItem.fromOrderValue(Integer.parseInt(scanner.nextLine().trim()));
        } catch (RuntimeException e) {
            return MenuItem.EXIT;
        }
    }
}
