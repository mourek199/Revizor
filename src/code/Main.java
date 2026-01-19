package code;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.innit();
        game.revizor.setCurrentLocation(game.gameData.getGameMap().getLocations()[5]);
        System.out.println(game.revizor.getCurrentLocation().getName());
        System.out.println(game.revizor.toString());
    }
}