package quiz;

public class Topic {

    private String title ;

    private final String MATH_TOPIC = "Math";
    private final String PROGRAMMING_TOPIC = "Programming";
    private final String FOOTBALL_TOPIC = "Football";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
