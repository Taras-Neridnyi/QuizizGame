package quiz;

import java.util.Scanner; 

public class GameSession {

    public GameSession(int score, String playerName, Topic selectedTopic) {
        this.score = score;
        this.playerName = playerName;
        this.selectedTopic = selectedTopic;
    }

    public GameSession() {
    }

    private int score;
    private String playerName;
    private Topic selectedTopic;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Topic getSelectedTopic() {
        return selectedTopic;
    }

    public void setSelectedTopic(Topic selectedTopic) {
        this.selectedTopic = selectedTopic;
    }


    protected void greet() {
        System.out.println("\nПривіт " + getPlayerName() + """
                 Це Quiz zoo гра !
                """);
    }
    protected String askUsername() {
        line();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Перед тим як почати , напишіть своє ім'я :  ");
        String name = scanner.nextLine();
        setPlayerName(name);
        return name;
    }
        protected void line() {
            System.out.println("-".repeat(50));


    }
}
