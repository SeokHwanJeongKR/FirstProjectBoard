package firstProjectBoardV1;

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
        if (bf.isIdLoginAccess() && bf.isPasswordsAccess()) {
            bf.chooseMenufuntion();
            bf.selectMenu();
            bf.selectMenu11();

        } else {
            System.out.println("프로그램을 종료합니다");
        }
    }


}

