package patterns.task4;

public class Main {
    public static void main(String[] args) {
        WeaponFactory weaponFactory;
        weaponFactory = new BowFactory();
        weaponFactory.create();

        weaponFactory = new GunFactory();
        weaponFactory.create();

        weaponFactory = new SwordFactory();
        weaponFactory.create();
    }
}
