package hexlet.code.menu.item;

import java.util.random.RandomGenerator;

public abstract class MenuItem {

    protected static final int UPPER_BOUND = 100;
    protected static final int LOWER_BOUND = 1;
    protected static final int NUMBER_OF_GAMES = 3;
    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    private final MenuTextOrder menuTextOrder;

    protected MenuItem(MenuTextOrder menuData) {
        this.menuTextOrder = menuData;
    }

    public static int generateRandomInt(int lowerBound, int upperBound) {
        return Math.max(RANDOM.nextInt(upperBound), lowerBound);
    }

    /**
     * Returns the order number of this menu item.
     * This method can be overridden by subclasses to provide custom ordering behavior.
     *
     * @return the order number as an integer
     */
    public int getOrderNumber() {
        return menuTextOrder.getOrder();
    }

    /**
     * Returns the display text of this menu item.
     * Subclasses may override this method to provide dynamic or localized text.
     *
     * @return the menu item text as a String
     */
    public String getText() {
        return menuTextOrder.getText();
    }

    public abstract void execute();

}
