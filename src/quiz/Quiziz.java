package quiz;

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
    private static String username ;
    private static String topic;
    private static LinkedList<String>  topics = new LinkedList<>(){{
        add("Math");
        add("Programming");
        add("football");
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

    /*
        other methods
     */

    protected static void run(){
        askUsername();
        greet();
        askTopic();

    }

    private static void askUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Перед тим як почати , напиши своє ім'я :  ");
        String name = scanner.nextLine();
        setName(name);
    }

    private static void greet(){
        System.out.println("Привіт " + getName() +  """
                 Це Quizizoo гра !
                """);
    }

    private static void askTopic(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                ok , тепер виберу одну з трьох тем для квізу:
                1 - Математика
                2 - Футбол
                3 - Програмування
                    Для вибору можеш писати цифру або любе з цих слів
                """);
        String topic = scanner.nextLine();
        setTopic(topic);
        calibrateTopic();
    }

    private static void calibrateTopic(){
        String calibratedName = getTopic().strip().toLowerCase();
        if(calibratedName.contentEquals("1") || calibratedName.contentEquals("математика")){
            System.out.println("+");
            setTopic(topics.get(0));
        }else if(calibratedName.contentEquals("2") || calibratedName.contentEquals("футбол")){
            System.out.println("++");
          setTopic(topics.get(1));
        }else if(calibratedName.contentEquals("3") || calibratedName.contentEquals("Програмування")){
            System.out.println("+++");
            setTopic(topics.get(2));
        }else {
            System.out.println("error in calibrate topic");
        }

    }

}
