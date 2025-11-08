package patterns.test8;

public class Character {
    private String health;
    private String damage;
    private String armor;
    private String magic;

    private Character(CharacterBuilder characterBuilder) {
        this.armor = characterBuilder.armor;
        this.magic = characterBuilder.magic;
        this.damage = characterBuilder.damage;
        this.health = characterBuilder.health;
    }

    public static class CharacterBuilder {
        private String health;
        private String damage;
        private String armor;
        private String magic;

        public CharacterBuilder health(String health) {
            this.health = health;
            return this;
        }

        public CharacterBuilder damage(String damage) {
            this.damage = damage;
            return this;
        }

        public CharacterBuilder armor(String armor) {
            this.armor = armor;
            return this;
        }

        public CharacterBuilder magic(String magic) {
            this.magic = magic;
            return this;
        }

        public Character build() {
            return new Character(this);
        }
    }

    @Override
    public String toString() {
        return "Character{" +
                "health='" + health + '\'' +
                ", damage='" + damage + '\'' +
                ", armor='" + armor + '\'' +
                ", magic='" + magic + '\'' +
                '}';
    }
}
