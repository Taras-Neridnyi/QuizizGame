package quiz;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Taras
 * @version 1.0
 */
class Quiziz {

    /*
        Fields
     */
    private String username;
    private Topic topic;
    private int score;

    Question math1 = new Question("Скільки буде 2+2*32+4-2 =", "68");
    Question math2 = new Question("Прямий кут дорівнює (градусів) =", "90");
    Question math3 = new Question("(2+6)-(3+4) * ((3+4)-(2+3)) =", "2");

    Question programming1 = new Question("Хто створив java ?", "Джеймс Гослінг");
    Question programming2 = new Question("У котрому році ? ", "1995");
    Question programing3 = new Question("У java є oop ?", "так");

    Question football1 = new Question("Мессі і .......", "Роналду");
    Question football2 = new Question("Зінченко у команді .......", "Арсенал");
    Question football3 = new Question("Гравців у полі ..", "22");

    List<Question> questionListMath = new LinkedList<>(List.of(
            math1, math2, math3
    ));

    List<Question> questionListProgramming = new LinkedList<>(List.of(
            programming1, programming2, programing3
    ));

    List<Question> questionListFootball = new LinkedList<>(List.of(
            football1, football2, football3
    ));
    final Topic MATH_TOPIC = new Topic("Math", questionListMath);
    final Topic FOOTBALL_TOPIC = new Topic("Football", questionListFootball);
    final Topic PROGRAMMING_TOPIC = new Topic("Programming", questionListProgramming);

    List<Topic> topics = new LinkedList<>(List.of(
            MATH_TOPIC, PROGRAMMING_TOPIC, FOOTBALL_TOPIC
    ));
/*
        getters and setters
     */

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    /*
        other methods
     */
    protected void run() {
        boolean status = true;
        Scanner scanner = new Scanner(System.in);
        askUsername();
        greet();
        while (status) {
            askTopic();
            askQuestion();
            if (!(getScore() == 3)) {
                System.out.println("""
                        Бажаєте покращити результати ?
                        Для пордовження виберіть одну з поданих літер (y/n)
                        y -> так/yes
                        n -> ні/no""");
                System.out.print("Введіть : ");
                String s = scanner.nextLine();
                status = !s.equals("n");
            } else {
                status = false;
            }
        }
        System.out.println("Toді до зустрічі");
    }

    private void askUsername() {
        line();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Перед тим як почати , напишіть своє ім'я :  ");
        String name = scanner.nextLine();
        setName(name);
    }

    private void greet() {
        System.out.println("Привіт " + getName() + """
                 Це Quiz zoo гра !
                """);
    }

    private void askTopic() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Виберіть одну з трьох тем для квізу:
                 1 - Math
                 2 - Football
                 3 - Programming
                        Для вибору можете написати цифру або одне з слів навпроти цифр""");
        System.out.print("Введіть : ");
        String topic = scanner.nextLine();
        calibrateTopic(topic);
    }

    private void calibrateTopic(String calibratedName) {
        if (calibratedName.contentEquals("1") || calibratedName.matches("[Mm]ath")) {
            line();
            setTopic(MATH_TOPIC);
        } else if (calibratedName.contentEquals("2") || calibratedName.matches("[Ff]ootball")) {
            line();
            setTopic(FOOTBALL_TOPIC);
        } else if (calibratedName.contentEquals("3") || calibratedName.matches("[Pp]rogramming")) {
            line();
            setTopic(PROGRAMMING_TOPIC);
        } else {
            askTopic();
        }
    }

    private void askQuestion() {
        int note = 0;
        List<Question> results = getTopic().getQuestions();

        Scanner scanner = new Scanner(System.in);
        for (var question :
                results) {
            System.out.println(question.getQuestion() + " ");
            String userResponse = scanner.nextLine();
            note += userResponse.equals(question.getAnswer()) ? 1 : 0;
        }
        setScore(note);
        line();
        System.out.println("Ваш результат : " + note + " з 3 ." + " " + (note == 0
                ? "Це справді поганий результат :( . Думаю вам потрібно Спробувати знову ."
                : note == 1 ? "Погано , постарайтесь краще :| . Не здавайтесь :=)" : note == 2
                ? " Непогано ,  ще трохи і ви усе знатимете ! " : "Неймовірно! Ваш результат вражає :)"));
    }

    private void line() {
        System.out.println("-".repeat(50));
    }


}

