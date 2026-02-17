package Session11.MiniProject;

public abstract class GameCharacter {
    protected String name;
    protected int hp;
    protected int attackPower;

    static int count = 0;

    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        count++;
    }

    public abstract void attack(GameCharacter target);

    public void takeDamage(int amount) {
        this.hp -= amount;
        if (hp < 0) {
            hp = 0;
            System.out.println(name + " đã bị hạ gục!");
        } else {
            System.out.println(name + " mất " + amount + " máu, còn lại " + hp + " HP.");
        }
    }

    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp);
    }

    public String getName() {
        return name;
    }
}
