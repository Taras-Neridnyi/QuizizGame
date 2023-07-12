package quiz;

public class Topic {

    Topic (){
    }
    Topic(String title , Question question){
        setTitle(title);
    }

    private String title ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "title='" + title + '\'' +
                '}';
    }
}
