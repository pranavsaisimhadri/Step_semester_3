class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health = Math.max(health - amount, 0);
    }

    public void heal(int amount) {
        health = Math.min(health + amount, maxHealth);
    }

    public int getHealth() {
        return health;
    }
}

public class HealthBarDemo {
    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("After 30 damage: " + c.getHealth());
        c.heal(50);
        System.out.println("After healing 50: " + c.getHealth());
        c.takeDamage(150);
        System.out.println("After 150 damage: " + c.getHealth());
    }
}