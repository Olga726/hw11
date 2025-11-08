package patterns.task6;

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Window createWindow() {
        return new MacWindow();
    }

    @Override
    public Menu createMenu() {
        return new MacMenu();
    }
}
