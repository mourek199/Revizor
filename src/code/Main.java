package code;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        try {


            game.loadMap();
            System.out.println(game.gameMap.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}