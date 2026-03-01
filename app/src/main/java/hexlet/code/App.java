package hexlet.code;

import hexlet.code.menu.item.CalcMenuItem;
import hexlet.code.menu.item.EvenMenuItem;
import hexlet.code.menu.item.ExitMenuItem;
import hexlet.code.menu.item.GCDMenuItem;
import hexlet.code.menu.item.GreetMenuItem;
import hexlet.code.menu.item.PrimeMenuItem;
import hexlet.code.menu.item.ProgressionMenuItem;
import hexlet.code.menu.service.MenuService;
import hexlet.code.menu.service.UserInteractionService;

public class App {
    public static void main(String[] args) {
        UserInteractionService userInteractionService = new UserInteractionService();
        MenuService menuService = new MenuService(
                userInteractionService,
                new GreetMenuItem(userInteractionService),
                new EvenMenuItem(userInteractionService),
                new CalcMenuItem(userInteractionService),
                new GCDMenuItem(userInteractionService),
                new ProgressionMenuItem(userInteractionService),
                new PrimeMenuItem(userInteractionService),
                new ExitMenuItem()
        );
        menuService.start();
    }
}
