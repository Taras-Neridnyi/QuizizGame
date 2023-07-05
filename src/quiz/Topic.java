package quiz;

public class Topic {

    Topic (){

    }
    Topic(String title){
        setTitle(title);
    }

    private String title ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
