package quiz;

import java.util.*;

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

    private static LinkedList<String> topics = new LinkedList<>(List.of("Math", "Progamming", "football"));

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
        askUsername();
        greet();
        askTopic();
        askQuestion();
        doBetterResults();
    }

    private static void doBetterResults() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (getNote() == 3){
                break;
            }
            else if (getNote() < 3) {
                System.out.println("Бажаєте покращити результати ?(y/n)");
                String userResponse = scanner.nextLine().strip().toLowerCase();
                if (!(userResponse.equals("y"))) {
                    System.out.println("Тоді до зустрічі !");
                    break;
                } else {
                    greet();
                    askTopic();
                    askQuestion();
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
                ok , тепер виберіть одну з трьох тем для квізу:
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
        while (true) {
            String calibratedName = getTopic().strip().toLowerCase();
            if (calibratedName.contentEquals("1") || calibratedName.matches("math")) {
                System.out.println("-------------------------------------------------------------------------------------");
                setTopic(topics.get(0));
                break;
            } else if (calibratedName.contentEquals("2") || calibratedName.matches("football")) {
                System.out.println("-------------------------------------------------------------------------------------");
                setTopic(topics.get(2));
                break;
            } else if (calibratedName.contentEquals("3") || calibratedName.matches("programming")) {
                System.out.println("-------------------------------------------------------------------------------------");
                setTopic(topics.get(1));
                break;
            } else {
                System.out.println("вибрана тема не існує, будь ласка виберіть з доступних тем");
                askTopic();
            }
        }
        }

        private static void askQuestion () {
            // якщо чесно , незнаю як саме позбутися змінної k тому , ще без
            // неї всі відповіді підходять до всіх питань або ще всіляке
            int note = 0, k = 0, i = 0;
            Map<String, String> result = new HashMap<>();
            result = getTopic().equals(topics.getFirst()) ? questionsAndAnswersMath :
                    getTopic().equals(topics.get(1)) ? questionsAndAnswersProgramming :
                            questionsAndAnswersFootball;

            Scanner scanner = new Scanner(System.in);
            for (var question : result.keySet()
            ) {
                System.out.print(question + " ");
                String userResponse = scanner.nextLine();
                k++;
                i++;
                if (userResponse.equals(result.get(question)) && k == i) {
                    note++;
                }
            }
            setNote(note);
            System.out.println("Твій результат : " + note + " з 3 ." + " " + (note > 0 && note < 3 ? "Це теж позитивна оцінка !"
                    : note == 0 ? "Погано" : "Супер!"));
        }

    }

