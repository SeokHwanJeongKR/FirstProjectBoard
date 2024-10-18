package firstProjectBoardV2;

import java.util.Scanner;

public class MainV2 {

    public static void main(String[] args) {
        MenuV2 menu = new MenuV2();
        LoginSystem ls = new LoginSystem(menu);
        BoardfunctionV2 bf = new BoardfunctionV2();
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
                menu.selectMenu();
                menu.selectMenu2();
            }



        }
    }
}

