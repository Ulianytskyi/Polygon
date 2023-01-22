

public class Battle3 {

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

                System.out.println(p1.name + "[" + p1.power + "/" + p1.health + "] => " +
                        "(" + attackModP1 + ") => " +
                        p2.name + "[" + p2.power + "/" + p2.health + "]\nPunch in " + bodyPart);

                p2.health -= attackModP1;

                System.out.println("--------------------------------------------------");
                state = false;
            } else {

                System.out.println(p1.name + "[" + p1.power + "/" + p1.health + "] <= " +
                        "(" + attackModP1 + ") <= " +
                        p2.name + "[" + p2.power + "/" + p2.health + "]\nPunch in " + bodyPart);

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
}
