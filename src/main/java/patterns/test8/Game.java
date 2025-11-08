package patterns.test8;

public class Game {
    public static void main(String[] args) {
        Character character = new Character.CharacterBuilder()
                .armor("100%")
                .damage("15%")
                .magic("46%")
                .health("97%")
                .build();
        System.out.println(character);
    }
}
