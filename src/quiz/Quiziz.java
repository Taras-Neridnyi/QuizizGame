package quiz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

/**
 * @author Taras
 * @version 1.0
 */
class Quiziz {

    /*
        Fields
     */
    private static String username;
    private static String topic;
    private static int note;

    private static final String MATH_TOPIC = "Math";
    private static final String PROGRAMMING_TOPIC = "Programming";
    private static final String FOOTBALL_TOPIC = "Football";

    private static LinkedList<String> topics =
            new LinkedList<>(List.of(MATH_TOPIC, PROGRAMMING_TOPIC, FOOTBALL_TOPIC));
    private static Map<String, String> questionsAndAnswersMath = new HashMap<>(
            Map.of("Скільки буде 2+2*32+4-2 ? ", "68",
                    "Прямий кут дорівнює (градусів)", "90",
                    "(2+6)-(3+4) * ((3+4)-(2+3)) =", "2"));

    private static Map<String, String> questionsAndAnswersProgramming = new HashMap<>(
            Map.of("Хто створив java ?", "Джеймс Гослінг",
                    "У котрому році ? ", "1995",
                    "У java є oop ?", "так"));

    private static Map<String, String> questionsAndAnswersFootball = new HashMap<>(
            Map.of("Мессі і .......", "Роналду",
                    "Зінченко у команді .......", "Арсенал",
                    "Гравців у полі ..", "22"));

    private static final Map<String, Map<String, String>> topicsToQuestions = new HashMap<>(
            Map.of(MATH_TOPIC, questionsAndAnswersMath,
                    PROGRAMMING_TOPIC, questionsAndAnswersProgramming,
                    FOOTBALL_TOPIC, questionsAndAnswersFootball));

    /*
        getters and setters
     */

    public static int getNote() {
        return note;
    }

    public static void setNote(int note) {
        Quiziz.note = note;
    }

    public static String getTopic() {
        return topic;
    }

    public static void setTopic(String topic) {
        Quiziz.topic = topic;
    }

    public static String getName() {
        return username;
    }

    public static void setName(String name) {
        Quiziz.username = name;
    }

    /*
        other methods
     */

    protected static void run() {
        boolean status = true;
        Scanner scanner = new Scanner(System.in);
        askUsername();
        greet();
        while (status) {
            askTopic();
            askQuestion();
            if (getNote() == 3){
                status = false;
            }
            else if (getNote() < 3) {
                System.out.println("Бажаєте покращити результати ?(y/n)");
                String userResponse = scanner.nextLine().strip().toLowerCase();
                if (!(userResponse.equals("y"))) {
                    System.out.println("Тоді до зустрічі !");
                    status = false;
                }
            }
        }
    }
    private static void askUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Перед тим як почати , напиши своє ім'я :  ");
        String name = scanner.nextLine();
        setName(name);
    }

    private static void greet() {
        System.out.println("Привіт " + getName() + """
                 Це Quizizoo гра !
                """);
    }

    private static void askTopic() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
               виберіть одну з трьох тем для квізу:
                1 - Math
                2 - Football
                3 - Programming
                       Для вибору можеш писати цифру або одне з слів навпроти цифр
                """);
        String topic = scanner.nextLine();
        calibrateTopic(topic);
    }

    private static void calibrateTopic(String calibratedName) {
        if (calibratedName.contentEquals("1") || calibratedName.matches("[Mm]ath")) {
            System.out.println("-------------------------------------------------------------------------------------");
            setTopic(MATH_TOPIC);
        } else if (calibratedName.contentEquals("2") || calibratedName.matches("[Ff]ootball")) {
            System.out.println("-------------------------------------------------------------------------------------");
            setTopic(FOOTBALL_TOPIC);
        } else if (calibratedName.contentEquals("3") || calibratedName.matches("[Pp]rogramming")) {
            System.out.println("-------------------------------------------------------------------------------------");
            setTopic(PROGRAMMING_TOPIC);
        } else {
            System.out.print("Вибраної тема не існує . ");
            askTopic();
        }
    }

        private static void askQuestion () {
            int note = 0;
            Map<String , String> result = topicsToQuestions.get(getTopic());

            Scanner scanner = new Scanner(System.in);
            for (var question : result.keySet()) {
                System.out.print(question + " ");
                String userResponse = scanner.nextLine();
                if (userResponse.equals(result.get(question))) {
                    note++;
                }
            }
            setNote(note);
            System.out.println("Твій результат : " + note + " з 3 ." + " " + (note > 0 && note < 3 ? "Це теж позитивна оцінка !"
                    : note == 0 ? "Погано" : "Супер!"));
        }

    }

