package patterns.task6;

public class Elements {
    private Button button;
    private Window window;
    private Menu menu;

    public Elements(GUIFactory guiFactory) {
        this.button = guiFactory.createButton();
        this.menu = guiFactory.createMenu();
        this.window = guiFactory.createWindow();
    }

    public void paint() {
        button.click();
        window.draw();
        menu.open();
    }

}
