package quiz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

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
    private static byte note;
    private static LinkedList<String> topics = new LinkedList<>() {{
        add("Math");
        add("Programming");
        add("football");
    }};

    public static void returnIndex() {
        System.out.println("1 " + topics.get(0));
        System.out.println("2 " + topics.get(1));
        System.out.println("3 " + topics.get(2));
    }

    private static HashMap<String, String> questionsAndAnswersMath = new HashMap<>() {{
        put("Скільки буде 2+2*32+4-2 ? ", "68");
        put("Прямий кут дорівнює (градусів)", "90");
        put("(2+6)-(3+4) * ((3+4)-(2+3)) =", "2");
    }};

    private static HashMap<String, String> questionsAndAnswersProgramming = new HashMap<>() {{
        put("Хто створив java ?", "Джеймс Гослінг");
        put("У котрому році ? ", "1995");
        put("У java є oop ?", "так");
    }};

    private static HashMap<String, String> questionsAndAnswersFootball = new HashMap<>() {{
        put("Мессі і .......", "Роналду");
        put("Зінченко у команді .......", "Арсенал");
        put("Гравців у полі ..", "22");
    }};

    /*
        getters and setters
     */
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

    public static byte getNote() {
        return note;
    }

    public static void setNote(byte note) {
        Quiziz.note = note;
    }

    /*
        other methods
     */

    protected static void run() {

        askUsername();
        greet();
        askTopic();
        askQuestion();


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
                ok , тепер виберу одну з трьох тем для квізу:
                1 - Math
                2 - Football
                3 - Programming
                       Для вибору можеш писати цифру або одне з слів навпроти цифр
                """);
        String topic = scanner.nextLine();
        setTopic(topic);
        calibrateTopic();
    }

    private static void calibrateTopic() {
        String calibratedName = getTopic().strip().toLowerCase();
        if (calibratedName.contentEquals("1") || calibratedName.matches("[mM]ath")) {
            System.out.println("-------------------------------------------------------------------------------------");
            setTopic(topics.get(0));
        } else if (calibratedName.contentEquals("2") || calibratedName.matches("[Ff]ootball")) {
            System.out.println("-------------------------------------------------------------------------------------");
            setTopic(topics.get(2));
        } else if (calibratedName.contentEquals("3") || calibratedName.matches("[Pp]rogramming")) {
            System.out.println("-------------------------------------------------------------------------------------");
            setTopic(topics.get(1));
        } else {
            System.out.println("error in calibrate topic");
        }

    }

    private static void askQuestion() {
        if (getTopic().contentEquals(topics.getFirst())) {
            askMath();
        } else if (getTopic().contentEquals(topics.get(1))) {
            askProgramming();
        } else if (getTopic().contentEquals(topics.getLast())) {
            askFootball();
        }
    }


    private static void askMath() {
        int note = 0;
        int k = 0;

        Scanner scanner = new Scanner(System.in);
        for (var i :
                questionsAndAnswersMath.keySet()) {
            System.out.print(i + " ");
            String ask = scanner.nextLine();

            k++;
            if ((ask.equals("2") && k == 1)) {
                note++;
            }
            else if ((ask.equals("68") && k == 2)) {
                note++;
            }
            else if ((ask.equals("90") && k == 3)) {
                note++;
            }else {
            }
        }

        System.out.println("Твій результат : " + note + " з 3 ." + " " + (note > 0 && note < 3 ? "Це теж позитивна оцінка !"
                : note == 0 ? "Погано" : "Супер!"));
    }

    private static void askFootball() {
        int note = 0;
        int k = 0;

        Scanner scanner = new Scanner(System.in);
        for (var i :
                questionsAndAnswersFootball.keySet()) {
            System.out.print(i + " ");
            String ask = scanner.nextLine();

            k++;
            if ((ask.equals("Роналду") && k == 1)) {
                note++;
            }
            else if ((ask.equals("Арсенал") && k == 2)) {
                note++;
            }
            else if ((ask.equals("22") && k == 3)) {
                note++;
            }else {
            }
        }

        System.out.println("Твій результат : " + note + " з 3 ." + " " + (note > 0 && note < 3 ? "Це теж позитивна оцінка !"
                : note == 0 ? "Погано" : "Супер!"));
    }

    private static void askProgramming() {
        int note = 0;
        int k = 0;

        Scanner scanner = new Scanner(System.in);
        for (var i :
                questionsAndAnswersProgramming.keySet()) {
            System.out.print(i + " ");
            String ask = scanner.nextLine();

            k++;
            if ((ask.equals("Джеймс Гослінг") && k == 1)) {
                note++;
            }
            else if ((ask.equals("1995") && k == 2)) {
                note++;
            }
            else if ((ask.equals("так") && k == 3)) {
                note++;
            }else {
            }
        }

        System.out.println("Твій результат : " + note + " з 3 ." + " " + (note > 0 && note < 3 ? "Це теж позитивна оцінка !"
                : note == 0 ? "Погано" : "Супер!"));
    }

}
