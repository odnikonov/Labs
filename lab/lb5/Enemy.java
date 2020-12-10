public class Enemy extends Person {
	String name;

	public Enemy(String name) {
		super(name);
		this.name = name;
	}

	// Проверка попадания игрока по врагу
	public static void checkRandom(int num, Player player, Enemy enemy) {
		// Если игрок попал
		if (enemy.randNum == num) {
			Person.loseLives(enemy);// Отнимаем 10 жизней
			System.out.printf("You guessed it, now the enemy named %s has %d lives left!\n", enemy.name, enemy.lives);
		} else if (enemy.randNum > num)
			System.out.println("You didn't guess! The number you are trying to guess is larger");
		else if (enemy.randNum < num)
			System.out.println("You didn't guess! The number you are trying to guess is less");
	}
}