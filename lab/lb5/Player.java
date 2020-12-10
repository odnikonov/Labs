public class Player extends Person {
	String name;
	
	public Player(String name) {
		super(name);
		this.name = name;
	}

	// Проверка попадания врага по игроку
	public static void checkRandom(int num, Enemy enemy, Player player) {
		// Если попал
		if (player.randNum == num) {
			//Отнимаем 10 жизней
			Person.loseLives(player);
			System.out.printf("The enemy has hit you! %s has %d lives left!\n", player.name, player.lives);
		} else
			System.out.println("The enemy did not guess the number");
	}
}