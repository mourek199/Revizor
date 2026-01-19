package code;

public class Game {
    GameData gameData = new GameData();
    Revizor revizor = new Revizor("revizor1");

    public void innit(){
        try {
            gameData.loadMap();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
