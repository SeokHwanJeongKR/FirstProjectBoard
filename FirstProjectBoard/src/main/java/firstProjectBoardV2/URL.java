package firstProjectBoardV2;

import java.util.Scanner;

public class URL {

    Scanner sc = new Scanner(System.in);
    LoginMenu mi2 = new LoginMenu();

    private String URL = "http://www.board.com";
    private String checkURL;
    private boolean acceptConnectToURL = false;

    public void acceptConnectToURL() {

        while (true){
            System.out.println("현재 할 수 있는 행동은 /accounts 입니다.");
            System.out.print("URL : http://www.board.com");
            checkURL = sc.nextLine();

            if(checkURL.equals("/accounts")) {
                acceptConnectToURL = true;
                mi2.LoginFuntion();
                break;
            } else {
                System.out.println("처리 불가능 ");
            }
        }

    }

    public void connectToURL () {

        while (true) {
            System.out.println("게시판에 접속을 하시려면 게시판 주소를 적어주세요");
            System.out.println("게시판 주소는 http://www.board.com 입니다");
            System.out.print("URL : ");
            checkURL = sc.nextLine();

            if (checkURL.equals(URL)) {
                System.out.println("게시판에 접속 합니다");
                acceptConnectToURL();
                break;
            } else {
                System.out.println("연결 실패 : 등록된 주소가 아닙니다. 제대로 주소를 입력 해주세요");

            }
        }
    }







}

