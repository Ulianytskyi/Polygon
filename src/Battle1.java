import java.util.Random;

public class Battle1 {
    public static void main(String[] args) {


        Person person1 = new Person("Batman", 8, 50);
        Person person2 = new Person("Joker", 10, 40);

        System.out.println(person1.name + " versus " + person2.name);

        while (person1.health > 0 && person2.health > 0) {
            Random random = new Random();
            int turn = random.nextInt(10) + 1;
            if (turn >= 5) {
                person1.health -= person2.power;
                System.out.println(person2.name + " [" + person2.health + "] beats " + person1.name + " [" + person1.health + "]");
            } else {
                person2.health -= person1.power;
                System.out.println(person1.name + " [" + person1.health + "] beats " + person2.name + " [" + person2.health + "]");
            }
        }
        if (person1.health > 0) {
            System.out.println(person1.name + " win!");
        } else if (person2.health > 0) {
            System.out.println(person2.name + " win!");
        }
    }
}

class Person {
    String name;
    int power;
    int health;
    Person(String name, int power, int health) {
        this.name = name;
        this.power = power;
        this.health = health;

    }
}