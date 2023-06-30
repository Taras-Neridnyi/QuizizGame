package quiz;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/**
 * @author Taras
 * @version 1.0
 */
class Quiziz {

    /*
        Fields
     */
    private String username;
    private String topic;
    private int note;
    private final String MATH_TOPIC = "Math";
    private final String PROGRAMMING_TOPIC = "Programming";
    private final String FOOTBALL_TOPIC = "Football";
    private final Map<String, String> questionsAndAnswersMath = new HashMap<>(
            Map.of("Скільки буде 2+2*32+4-2 =", "68",
                    "Прямий кут дорівнює (градусів) =", "90",
                    "(2+6)-(3+4) * ((3+4)-(2+3)) =", "2"));

    private final Map<String, String> questionsAndAnswersProgramming = new HashMap<>(
            Map.of("Хто створив java ?", "Джеймс Гослінг",
                    "У котрому році ? ", "1995",
                    "У java є oop ?", "так"));

    private final Map<String, String> questionsAndAnswersFootball = new HashMap<>(
            Map.of("Мессі і .......", "Роналду",
                    "Зінченко у команді .......", "Арсенал",
                    "Гравців у полі ..", "22"));

    private final Map<String, Map<String, String>> topicsToQuestions = new HashMap<>(
            Map.of(MATH_TOPIC, questionsAndAnswersMath,
                    PROGRAMMING_TOPIC, questionsAndAnswersProgramming,
                    FOOTBALL_TOPIC, questionsAndAnswersFootball));

    /*
        getters and setters
     */

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
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
            if (getNote() == 3) {
                status = false;
            } else if (getNote() < 3) {
                System.out.println("""
                        Бажаєте покращити результати ?
                        Для пордовження виберіть одну з поданих літер (y/n)
                        y -> так/yes
                        n -> ні/no""");
                System.out.print("Введіть : ");
                String userResponse = scanner.nextLine().strip().toLowerCase();
                if (!(userResponse.equals("y"))) {
                    System.out.println("Тоді до зустрічі !");
                    status = false;
                }
            }
        }
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
            System.out.print("Вибраної тема не існує . ");
            askTopic();
        }
    }

    private void askQuestion() {
        int note = 0;
        Map<String, String> result = topicsToQuestions.get(getTopic());

        Scanner scanner = new Scanner(System.in);
        for (var question : result.keySet()) {
            System.out.print(question + " ");
            String userResponse = scanner.nextLine();
            if (userResponse.equals(result.get(question))) {
                note++;
            }
        }
        setNote(note);
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

