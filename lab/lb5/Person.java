public class Person {
    public int randNum;
    public int lives;
    String name;

    // Присвоение имени и количества HP каждому персонажу
    public Person(String name) {
        this.name = name;
        this.lives = 100;
    }

    // Функция вызывающяя для отнятия жизни персонажа при угадывании числа
    public static void loseLives(Person HP) {
        HP.lives -= 10;
    }
}