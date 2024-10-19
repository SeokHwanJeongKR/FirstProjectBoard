package firstProjectBoardV1_1;

import java.util.Scanner;

public class MainV1_1 {

    public static void main(String[] args) {
        MenuV1_1 menu = new MenuV1_1();
        LoginSystemV1_1 ls = new LoginSystemV1_1(menu);
        Scanner sc = new Scanner(System.in);



        while (true) {
            ls.start();
            if(ls.isStart()) {
                ls.chooseLogin();
            }
            if(ls.isResultChooseLogin()) {
                ls.acceptLogin();
            }
            if(ls.isIdLoginAccess()) {
                ls.login();
            }
            if(ls.isPasswordsAccess()) {
                ls.checkPassword();
            }
            if(ls.isIdLoginAccess() && ls.isPasswordsAccess()) {
                ls.chooseMenufuntion();
            }
            while (true) {
                menu.selectMenu();
                break;
            }
            break;
        }
    }
}

