package firstProjectBoard;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Boardfunction bf = new Boardfunction();
        Scanner sc = new Scanner(System.in);


        bf.start();
        bf.chooseLogin();
        bf.acceptLogin();
        if (bf.isIdLoginAccess()) {
            bf.login();
        }
        if (bf.isPasswordsAccess()) {
            bf.checkPassword();
        }

    }


}


