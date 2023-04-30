package quiz;

import java.util.Scanner;

/**
 * @author Taras
 * @version 1.0
 */
class Quiziz {
    private static String username ;
    private static String topic;

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

    protected static void run(){
        askUsername();
        greet();
        chooseTopic();

    }

    private static void askUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Перед тим як почати , напиши своє ім'я :  ");
        String name = scanner.nextLine();
        setName(name);
    }

    private static void greet(){
        Quiziz quiziz = new Quiziz();
        System.out.println("Привіт " + getName() +  """
                 Це Quizizoo гра !
                """);
    }

    private static String chooseTopic(){
        return "";
    }

}
