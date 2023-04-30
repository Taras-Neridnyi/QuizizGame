package quiz;

import java.util.Scanner;
/**
 * @author Taras Neridnyi
 * @version 1.0
 */
public class QuzizLaunch extends Quiziz {
    public static void main(String[] args) {
    }
    private static String askUsername(){
        Quiziz quiziz = new Quiziz();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Перед тим як почати , напиши своє ім'я :  ");
        String name = scanner.nextLine();
        quiziz.setName(name);

        return quiziz.getName();
    }
    private static void greet(){
        Quiziz quiziz = new Quiziz();
        System.out.println("Привіт " + quiziz.getName() +  """
                Це Quizizoo гра !
                """);
    }

    private static String chooseTopic(){
        return "";
    }
}

