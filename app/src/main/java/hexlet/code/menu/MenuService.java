package hexlet.code.menu;

import hexlet.code.game.CalcGame;
import hexlet.code.game.EvenGame;
import hexlet.code.game.GCDGame;
import hexlet.code.game.Game;
import hexlet.code.game.GreetGame;
import hexlet.code.game.PrimeGame;
import hexlet.code.game.ProgressionGame;
import hexlet.code.engine.EngineService;

import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

public final class MenuService {

    private static final String INTRO_MESSAGE = "Please enter the game number and press Enter.%n";
    private static final String USER_CHOICE = "Your choice: ";
    private static final String MENU_ITEM_TEXT_PATTERN = "%d - %s%n";

    private final Map<MenuItem, Game> games = new EnumMap<>(MenuItem.class);
    private final EngineService engine = new EngineService();
    private final Scanner scanner = new Scanner(System.in);

    public MenuService() {
        initGames();
    }

    public void start() {
        displayMenu();
        Game game = games.get(readChoice());
        if (game != null) {
            engine.runGame(game.getRule(), game.getGameDataLinkedList());
        }
    }

    private void initGames() {
        for (MenuItem item : MenuItem.values()) {
            games.put(item, createGame(item));
        }
    }

    private Game createGame(MenuItem menuItem) {
        return switch (menuItem) {
            case GREET -> new GreetGame();
            case EVEN -> new EvenGame();
            case CALC -> new CalcGame();
            case GCD -> new GCDGame();
            case PRIME -> new PrimeGame();
            case PROGRESSION -> new ProgressionGame();
            default -> null;
        };
    }

    private void displayMenu() {
        writeMessage(INTRO_MESSAGE);
        for (MenuItem menuItem : MenuItem.values()) {
            writeMessage(MENU_ITEM_TEXT_PATTERN, menuItem.getOrder(), menuItem.getText());
        }
    }

    private MenuItem readChoice() {
        writeMessage(USER_CHOICE);
        try {
            return MenuItem.fromOrderValue(Integer.parseInt(scanner.nextLine().trim()));
        } catch (RuntimeException e) {
            return MenuItem.EXIT;
        }
    }

    private void writeMessage(String message, Object... values) {
        System.out.printf(message, values);
    }
}
