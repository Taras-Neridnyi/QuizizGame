package quiz;

import java.util.Scanner;

/**
 * @author Taras
 * @version 1.0
 */
class Quiziz {

    protected static void run(){
        askUsername();
        greet();
        chooseTopic();

    }

    private static String askUsername(){
        Quiziz quiziz = new Quiziz();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Перед тим як почати , напиши своє ім'я :  ");
        String name = scanner.nextLine();


        return name;
    }
    private static void greet(){
        Quiziz quiziz = new Quiziz();
        System.out.println("Привіт " +   """
                Це Quizizoo гра !
                """);
    }

    private static String chooseTopic(){
        return "";
    }

}
