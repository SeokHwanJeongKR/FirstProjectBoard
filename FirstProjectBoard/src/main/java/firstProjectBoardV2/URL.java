package firstProjectBoardV2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class URL {

    Scanner sc = new Scanner(System.in);
    HashMap hsmap = new HashMap<>();
    Map<String, Runnable> urlsetting = new HashMap<>();
    MenuV2 menu = new MenuV2();
    MemberInformation mi = new MemberInformation();

    private String URL = "http://www.board.com";
    private String checkURL;
    private String checkURLFution;
    private boolean acceptConnectToURL = false;


    public URL() {
        mi.membersetting.put("/signup", mi::signup);
        mi.membersetting.put("/signin", mi::signin);
        mi.membersetting.put("/detail", mi::detail);
        urlsetting.put("/visitors", menu::visitorsMenu);



    }

    public void processInput() {

        if (mi.memberinfo.isEmpty()) {
            while (acceptConnectToURL) {
                System.out.println("현재 가능한 기능은 (/signup,/visitors )입니다");
                System.out.print(URL);
                checkURLFution = sc.nextLine();
                menu.bf.setMemberBoardAccess(true);

                Runnable action = mi.membersetting.get(checkURLFution);

                if (action != null) {
                    action.run();
                    acceptConnectToURL = true;
                    mi.setLoginAccess(true);
                    break;

                } else if (checkURLFution.equals("/visitors")) {
                    menu.visitorsMenu();


                } else {
                    System.out.println("처리 불가능");
                }
            }
        }
        if (!mi.memberinfo.isEmpty()) {
            while (acceptConnectToURL) {
                System.out.println("현재 가능한 기능은 (/signup,/signin,/detail,/visitors,/exit )입니다");
                System.out.print(URL);
                checkURLFution = sc.nextLine();
                System.out.println("입력된 URL: " + checkURLFution);
                menu.bf.setMemberBoardAccess(true);

                Runnable action = mi.membersetting.get(checkURLFution);

                if (checkURLFution.equals("/exit")) {
                    System.out.println("프로그램을 종료 합니다");
                    break;

                } else if (checkURLFution.equals("/visitors")) {
                    menu.visitorsMenu();

                } else if (checkURLFution.equals("/signin")) {
                    action.run();
                    processInputSignIn();
                    break;

                }  else if (action != null) {
                    action.run();
                }else {
                    System.out.println("처리 불가능");
                }
            }
        }

    }

    public void processInputSomeoneSignUp() {
        if (!mi.memberinfo.isEmpty()) {
            while (acceptConnectToURL) {
                System.out.println("현재 가능한 기능은 (/signup,/signin,/detail,/visitors,/exit )입니다");
                System.out.print(URL);
                checkURLFution = sc.nextLine();
                System.out.println("입력된 URL: " + checkURLFution);
                menu.bf.setMemberBoardAccess(true);

                Runnable action = mi.membersetting.get(checkURLFution);

                if (checkURLFution.equals("/exit")) {
                    System.out.println("프로그램을 종료 합니다");
                    break;
                } else if (checkURLFution.equals("/signin")) {
                    action.run();
                    processInputSignIn();
                    break;
                } else if (checkURLFution.equals("/visitors")) {
                    menu.visitorsMenu();

                } else if (checkURLFution.equals("/board")) {
                    menu.selectMenu();
                } else if (action != null) {
                    action.run();
                }else {
                    System.out.println("처리 불가능");
                }
            }
        }
    }

    public void processInputSignIn() {
        if (mi.isLoginAccess()) {
            while (acceptConnectToURL) {
                System.out.println("현재 가능한 기능은 (/board,/signup,/detail,/logout)입니다");
                System.out.print(URL);
                checkURLFution = sc.nextLine();
                System.out.println("입력된 URL: " + checkURLFution);
                menu.bf.setMemberBoardAccess(true);

                Runnable action = mi.membersetting.get(checkURLFution);

                if (checkURLFution.equals("/logout")) {
                    System.out.println("로그아웃 합니다");
                    processInputSomeoneSignUp();
                    break;
                } else if (checkURLFution.equals("/signin")) {
                    System.out.println("이미 로그인 되었습니다");

                } else if (checkURLFution.equals("/visitors")) {
                    System.out.println("로그인 상태이기에 로그아웃을 해야합니다.");

                } else if (checkURLFution.equals("/board")) {
                    menu.selectMenu();
                } else if (action != null) {
                    action.run();
                }  else {
                    System.out.println("처리 불가능");
                }
            }
        } else if (!mi.memberinfo.isEmpty() && !mi.isLoginAccess()) {
            System.out.println("잘못된 접근 입니다");
        }
    }


    public boolean isAcceptConnectToURL() {
        return acceptConnectToURL;
    }

    public void connectToURL () {
        System.out.println("게시판에 접속을 하시려면 게시판 주소를 적어주세요");
        System.out.println("게시판 주소는 http://www.board.com 입니다");
        checkURL = sc.nextLine();

        while (true) {
            if (checkURL.equals(URL)) {
                System.out.println("게시판에 접속 합니다");
                acceptConnectToURL = true;
                break;
            } else {
                System.out.println("연결 실패 : 등록된 주소가 아닙니다. 제대로 주소를 입력 해주세요");
                checkURL = sc.nextLine();
            }
        }
    }

    public void URLbasic() {

    }

    public void chooseLogin () {

    }

    public void chooseLogout () {

    }
    public void moveToBoard() {

    }

    public void addPost() {

    }

    public void removePost() {

    }

    public void editPost() {

    }

    public void viewPost() {

    }





}

