package Session11.MiniProject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== ARENA OF HEROES ===");

        List<GameCharacter> characters = new ArrayList<>();

        Warrior yasuo = new Warrior("Yasuo", 500, 50, 20);
        Mage veigar = new Mage("Veigar", 300, 25, 200);

        GameCharacter goblin = new GameCharacter("Goblin", 100, 10) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("[Quái vật] Goblin tấn công!");
                System.out.println("Goblin cắn trộm...");
                target.takeDamage(10);
            }
        };

        characters.add(yasuo);
        characters.add(veigar);
        characters.add(goblin);

        System.out.println("Đã khởi tạo " + GameCharacter.count + " nhân vật tham gia đấu trường.\n");

        yasuo.attack(goblin);
        System.out.println();

        veigar.useUltimate(yasuo);
        System.out.println();

        goblin.attack(veigar);

        System.out.println("\n=== THÔNG SỐ SAU LƯỢT ĐẤU ===");
        for (GameCharacter c : characters) {
            c.displayInfo();
        }
    }
}
