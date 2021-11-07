package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Code code = new Code("9305");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        code.evaluate(input);
        code.provideGrade();

    }

    public static void intro() {
//        System.out.println("The secret code is prepared: ****.\n");
//        System.out.println("Turn 1. Answer:");
//        System.out.println("1234");
//        System.out.println("Grade: None.\n");
//        System.out.println("Turn 2. Answer:");
//        System.out.println("9876");
//        System.out.println("Grade: 4 bulls.");
//        System.out.println("Congrats! The secret code is 9876.");
    }
}

class Code {
    String secretCode;
    int bulls; // correct guess and position
    int cows; // just correct guess

    Code(String secretCode) {
        this.secretCode = secretCode;
    }

    public void evaluate(String guess) {
        bulls = 0;
        cows = 0;

        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            if (guessChar == secretCode.charAt(i)) {
                bulls++;
            } else {
                if (secretCode.contains(String.valueOf(guessChar))) {
                    cows++;
                }
            }
        }
        //return new int[] {cows, bulls};
    }

    public void provideGrade() {
        StringBuilder finalResult = new StringBuilder();
        String grade = "Grade: ";
        if (bulls == 0 && cows == 0) {
            grade += "None. ";
        } else if (bulls > 0 && cows == 0) {
            grade += String.format(" %d bull(s). ", bulls);
        } else if (bulls == 0 && cows > 0) {
            grade += String.format(" %d cow(s). ", cows);
        } else {
            grade += String.format(" %d bulls(s) and %d cows(s). ", bulls, cows);
        }

        String confess = String.format("The secret code is %s", secretCode);

        finalResult.append(grade);
        finalResult.append(confess);

        System.out.println(finalResult.toString());
    }

}
