package patterns.task4;

public class GunFactory extends WeaponFactory{
    @Override
    public Weapon createWeapon() {
        return new Gun();
    }
}
