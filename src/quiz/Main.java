package quiz;


public class Main {
    public static void main(String[] args) {
        printAll();




    }

    private static void printAll(){
        GameSession gameSession = new GameSession();
        gameSession.greet();
        gameSession.askUsername();
    }
}
