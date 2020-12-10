import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        // Число от 1 до 20
        final int from = 1;
        final int to = 20;
        Scanner scan = new Scanner(System.in);
        // Просьба ввести имя игрока
        System.out.printf("Enter player name: ");
        Player player = new Player(scan.nextLine());
        // Просьба ввести имя врага
        System.out.printf("Enter the name of the enemy: ");
        Enemy enemy = new Enemy(scan.nextLine());
        // Настроить автоматическую игру?
        boolean avtomat = false;
        System.out.printf("Set up automatic play yes/no?: ");
        if (scan.nextLine().equals("yes"))
            avtomat = true;
        int numPlayer = 0, numEnemy = 0;
        // Пока HP имеется хотябы у 1 игрока
        while (enemy.lives > 0 && player.lives > 0) {
            // Число врага
            enemy.randNum = from + (int) (Math.random() * to);
            // Число игрока
            player.randNum = from + (int) (Math.random() * to);
            // Пока никто не угадал число
            while (numPlayer != enemy.randNum && numEnemy != player.randNum) {
                // Если ползователь не выбрал автоматический режим
                System.out.printf("enter a number from %d to %d: ", from, to);
                if (avtomat == false)
                    // Будет ввести в ручную
                    numPlayer = scan.nextInt();
                
                    else { 
                    numPlayer = from + (int) (Math.random() * to); 
                    System.out.println("\n" + numPlayer + " ");
                }
                // Обращаемся к классу врага и проверяем введенное число
                Enemy.checkRandom(numPlayer, player, enemy);
                // Враг загадывает число
                numEnemy = from + (int) (Math.random() * to);
                // Проверям в классе пользователя загаданное врагам число
                Player.checkRandom(numEnemy, enemy, player);
            }
        }
        scan.close();
        System.out.println("Game over");
        if (enemy.lives == 0 && player.lives == 0)
            System.out.println("draw");
        else if (enemy.lives == 0)
            System.out.printf("player %s wins!", player.name);
        else if (player.lives == 0)
            System.out.printf("player %s wins!", enemy.name);
    }
}