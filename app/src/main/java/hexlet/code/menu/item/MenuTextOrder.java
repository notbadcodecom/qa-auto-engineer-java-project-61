package hexlet.code.menu.item;

public enum MenuTextOrder {
    GREET(1, "Greet"),
    EVEN(2, "Even"),
    CALC(3, "Calc"),
    GCD(4, "GCD"),
    PROGRESSION(5, "Progression"),
    PRIME(6, "Prime"),
    EXIT(0, "Exit");

    private final int order;
    private final String text;

    MenuTextOrder(int orderValue, String orderText) {
        this.order = orderValue;
        this.text = orderText;
    }

    public int getOrder() {
        return order;
    }

    public String getText() {
        return text;
    }
}
