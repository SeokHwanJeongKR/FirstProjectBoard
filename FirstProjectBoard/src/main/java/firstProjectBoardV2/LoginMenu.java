package firstProjectBoardV2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginMenu {


    Scanner sc = new Scanner(System.in);


    LoginSystemV2 memberfunction = new LoginSystemV2();


    private String LoginOption;



    public void LoginFuntion () {

            Map<String, Runnable> Loginsystem = new HashMap<>();
            Loginsystem.put("/signup", memberfunction::signup);
            Loginsystem.put("/signin", memberfunction::signin);


        while (true) {

            System.out.println("어떤 기능을 사용 하시겠습니까? /signup, /signin, / exit");
            System.out.print( "http://www.board.com");
            LoginOption = sc.nextLine();
            Runnable action = Loginsystem.get(LoginOption);

            if (action != null) {
                action.run();
            } else if (LoginOption.equals("/back")) {
                System.out.println("메뉴로 돌아갑니다");
                break;
            }else {
                System.out.println("처리 불가능");
            }
        }
    }

}


