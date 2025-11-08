package patterns.task4;

public abstract class WeaponFactory {
    public abstract Weapon createWeapon();

    public void create(){
        Weapon weapon = createWeapon();
        weapon.attack();
    }
}
