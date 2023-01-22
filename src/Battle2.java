import java.util.Random;

public class Battle2 {

    static boolean state = true;

    public static void main(String[] args) {
        Person p1 = new Person("Batman", 8, 100);
        Person p2 = new Person("Joker", 10, 80);

        Battle2 value = new Battle2();

        state = value.StartTurn();

        while (p1.health > 0 && p2.health > 0) {
            String bodyPart = value.Attack();
            int blockChance = value.Block();
            int attackModP1 = (int) Math.round((double) p1.power / 100 * blockChance);
            int attackModP2 = (int) Math.round((double) p2.power / 100 * blockChance);

            if (state) {

                System.out.println(p1.name + "[" + p1.power + "/" + p1.health + "] kicks " +
                        "(" + attackModP1 + ") => " +
                        p2.name + "[" + p2.power + "/" + p2.health + "] in " + bodyPart);

                p2.health -= attackModP1;

                System.out.println("--------------------------------------------------");
                state = false;
            } else {

                System.out.println(p2.name + "[" + p2.power + "/" + p2.health + "] kicks " +
                        "(" + attackModP2 + ") => " +
                        p1.name + "[" + p1.power + "/" + p1.health + "] in " + bodyPart);

                p1.health -= attackModP2;

                System.out.println("--------------------------------------------------");
                state = true;
            }
        }
        if (p1.health > p2.health) {
            System.out.println("\nWinner is " + p1.name);
        } else {
            System.out.println("\nWinner is " + p2.name);
        }

    }

    public boolean StartTurn() {
        Random rn = new Random();
        int rnTurn = rn.nextInt(10)+1;
        if (rnTurn >= 5) {
            return true;
        } else {
            return false;
        }

    }
    public String Attack() {
        String attackedPart;
        Random rn = new Random();
        int rnAttack = rn.nextInt(6);
        switch (rnAttack) {
            case 0:
                attackedPart = "head";
                break;
            case 1:
                attackedPart = "left hand";
                break;
            case 2:
                attackedPart = "right hand";
                break;
            case 3:
                attackedPart = "body";
                break;
            case 4:
                attackedPart = "left leg";
                break;
            case 5:
                attackedPart = "right leg";
                break;
            default:
                attackedPart = null;
                break;
        }
        return attackedPart;
    }
    public int Block() {
        int blockRange;
        Random rn = new Random();
        int rnBlock = rn.nextInt(6);
        switch (rnBlock) {
            case 0:
                blockRange = 10;
                break;
            case 1:
                blockRange = 30;
                break;
            case 2:
                blockRange = 50;
                break;
            case 3,4,5:
                blockRange = 100;
                break;
            default:
                blockRange = 0;
                break;
        }
        return blockRange;
    }
}
