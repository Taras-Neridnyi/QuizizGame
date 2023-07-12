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
        System.out.println("Привіт " + getPlayerName() + """
                 Це Quiz zoo гра !
                """);
    }

}
