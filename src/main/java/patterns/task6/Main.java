package patterns.task6;

public class Main {
    public static void main(String[] args) {
        GUIFactory guiFactory;
        guiFactory = new MacFactory();
        Elements elements = new Elements(guiFactory);
        elements.paint();

        guiFactory = new WindowsFactory();
        Elements elements2 = new Elements(guiFactory);
        elements2.paint();
    }
}
