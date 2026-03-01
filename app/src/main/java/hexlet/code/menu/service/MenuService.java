package hexlet.code.menu.service;

import hexlet.code.menu.item.MenuItem;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public final class MenuService {

    private static final String INTRO_MESSAGE = "Please enter the game number and press Enter.";
    private static final String CHOICE_INPUT_QUESTION = "Your choice: ";
    private static final String MENU_ITEM_TEXT_PATTERN = "%d - %s";

    private final Map<Integer, MenuItem> menuItems = new LinkedHashMap<>();

    private final UserInteractionService userInteractionService;

    public MenuService(
            UserInteractionService interactionService,
            MenuItem... items
    ) {
        this.userInteractionService = interactionService;
        initMenu(items);
    }

    public void start() {
        displayMenu();
        Optional.ofNullable(userInteractionService.readInt(CHOICE_INPUT_QUESTION))
                .map(menuItems::get)
                .ifPresent(MenuItem::execute);
    }

    private void initMenu(MenuItem... items) {
        for (MenuItem item : items) {
            menuItems.put(item.getOrderNumber(), item);
        }
    }

    private void displayMenu() {
        userInteractionService.writeMessage(INTRO_MESSAGE);
        menuItems.forEach((orderNumber, menuItem) -> {
            String menuItemText = String.format(MENU_ITEM_TEXT_PATTERN, orderNumber, menuItem.getText());
            userInteractionService.writeMessage(menuItemText);
        });
    }
}
