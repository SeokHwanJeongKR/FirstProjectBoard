package firstProjectBoardV2;

import java.util.Scanner;

public class URL {

    Scanner sc = new Scanner(System.in);
    LoginMenu mi2 = new LoginMenu();

    private String URL = "http://www.board.com";
    private String checkURL;
    private boolean acceptConnectToURL = false;

    public void connectToURL () {
        System.out.println("게시판에 접속을 하시려면 게시판 주소를 적어주세요");
        System.out.println("게시판 주소는 http://www.board.com 입니다");
        checkURL = sc.nextLine();

        while (true) {
            if (checkURL.equals(URL)) {
                System.out.println("게시판에 접속 합니다");
                mi2.LoginFuntion();
                acceptConnectToURL = true;
                break;
            } else {
                System.out.println("연결 실패 : 등록된 주소가 아닙니다. 제대로 주소를 입력 해주세요");
                checkURL = sc.nextLine();
            }
        }
    }







}

