package hexlet.code.menu.item;

import hexlet.code.menu.service.UserInteractionService;

public final class GreetMenuItem extends MenuItem {

    private final UserInteractionService userInteractionService;

    public GreetMenuItem(UserInteractionService interactionService) {
        super(MenuTextOrder.GREET);
        this.userInteractionService = interactionService;
    }

    @Override
    public void execute() {
        userInteractionService.getUserName();
    }
}
