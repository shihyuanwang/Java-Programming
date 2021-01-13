/*
function passCheck:
    pass1 = <user prompt>
    pass2 = <user prompt>
    if pass1 != pass2:
        throw exception
function main:
    for each passCheck fail
        print “Try again”
        if 3 attempts fail:
            print “Security warning”
            exit
*/

import java.util.Scanner;

public class PasswordCheck {

    public static void passCheck(String pass1, String pass2) throws FailedPassCheckException {
        // check if password1 equals to password2; if not, throw exception
        if (!(pass1.trim()).equals(pass2.trim())) {
            throw new FailedPassCheckException();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            // prompt user to enter password
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter your password: ");
            String pass1 = scan.nextLine();
            System.out.println("Please confirm your password: ");
            String pass2 = scan.nextLine();

            try {
                passCheck(pass1, pass2);
                break;
            } catch (FailedPassCheckException e) {
                // if 3 attempts fail
                if (i == 2) {
                    System.out.println("Security warning!");
                    break;
                } else {  // 1 or 2 attempts fail
                    System.out.println("Try again!");
                }
            }
        }
    }
}

class FailedPassCheckException extends Exception {
}