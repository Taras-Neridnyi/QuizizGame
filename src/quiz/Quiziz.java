package quiz;

/**
 * @author Taras
 * @version 1.0
 */
class Quiziz {

    /*
        Fields
     */
    private Character topic;
    private String name;

    /*
        Constructors
     */
    public Quiziz(Character topic, String name) {
        this.topic = topic;
        this.name = name;
    }

    public Quiziz() {
    }

    public Character getTopic() {
        return topic;
    }

    /*
        Getters and setters
     */
    public void setTopic(Character topic) {
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
