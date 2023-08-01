package quiz;

import java.util.LinkedList;
import java.util.List;

public class Topic {

    List<Question> questionList = new LinkedList<>();

    Topic (){
    }

    Topic(String title , Question question){
        setTitle(title);
    }
    Topic(String title){
        setTitle(title);
    }
    Topic(String title , List<Question> questionList){
        this.questionList = questionList;
    }

    private String title ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questionList;
    }

    public void setQuestions(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "title='" + title + '\'' +
                '}';
    }
}
