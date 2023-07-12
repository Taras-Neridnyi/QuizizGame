package quiz;

public class Question {

    public Question(String question , String answer) {
        this.answer = answer;
        this.question = question;
    }
    public Question() {
    }

    private String answer;
    private String question;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "answer='" + answer + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}
