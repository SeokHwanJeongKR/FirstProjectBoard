package firstProjectBoard;

import java.util.ArrayList;
import java.util.Scanner;

public class Boardfunction implements BoardStructure {

    Scanner sc = new Scanner(System.in);
    ArrayList<String> arr = new ArrayList<>();


    private String title;
    private int postnumber;
    private String content;

    //현재 id 와 pass word는 user 0000만 가능하다.
    private boolean ResultChooseLogin = false;
    private String inputValue;
    private String id;
    private String passwords;
    private String boardFunction;
    private String selectResult;

    private boolean start = false;

    private boolean idLoginAccess = false;
    private boolean passwordsAccess = false;
    private boolean boardAccess = false;
    private boolean boardAccess1 = false;

    private String boardAccess2;

    private boolean viewPostAccept = false;



    public boolean isIdLoginAccess() {
        return idLoginAccess;
    }

    public boolean isPasswordsAccess() {
        return passwordsAccess;
    }

    public void start() {
        System.out.println("게시판에 접속 합니다 로그인 하시려면 (아무 키)나 쳐주세요");
        sc.nextLine();
        start = true;
    }

    public void chooseLogin() {
        while (start) {

                System.out.println("로그인 하시겠습니까?");
                System.out.println("1 = 로그인 2 = 종료하기");
                inputValue = sc.nextLine();

                if (inputValue.equals("1")) {
                    ResultChooseLogin = true;
                    break;
                } else if (inputValue.equals("2")) {
                    break;
                } else {
                    System.out.println("제대로 된 값을 입력하지 않았습니다.");
                }

        }


    }


    public void acceptLogin() {
        while (ResultChooseLogin) {
            if (inputValue.equals("1")) {
                System.out.println("아이디를 입력 해주세요 현재 가능한 id = user1 밖에 없습니다");
                id = sc.nextLine();
                idLoginAccess = true;
                break;
            } else if (inputValue.equals("2")) {
                System.out.println("안녕히 가세요");
                id = "2";
                idLoginAccess = false;
                start();
            } else {
                System.out.println("제대로 된 숫자를 입력해주세요");
                chooseLogin();
            }
        }

    }



    public void login() {
        while (idLoginAccess) {

            if ((id.equals("user1")) && (idLoginAccess)) {
                System.out.println("비밀번호를 입력해주세요 현재 가능한 비밀번호는 0000입니다.");
                passwords = sc.nextLine();
                passwordsAccess = true;
                break;
            } else if ((!id.equals("user1")) && (idLoginAccess)) {
                System.out.println("등록된 id 가 아닙니다.");
                acceptLogin();
            } else {
                System.out.println("정상적인 방법으로 연결 해주세요");
                break;
            }
        }

    }


    public void checkPassword() {
        while (passwordsAccess) {
            if ((passwords.equals("0000")) && (passwordsAccess)) {
                System.out.println(id + " 님 반갑습니다 ");
                break;
            } else if ((!passwords.equals("0000")) && (passwordsAccess)) {
                System.out.println("비밀번호가 잘못 되었습니다.");
                login();
            } else {
                System.out.println("비밀 번호를 정상적인 방법으로 연결 해주세요");
                break;
            }
        }

    }

    public void chooseMenufuntion() {
        while (idLoginAccess && passwordsAccess) {
            System.out.println("무엇을 하시겠습니까?");
            System.out.println("현재 구현된 기능은 1. 게시판 2. 로그아웃 입니다.");
            selectResult = sc.nextLine();

            // 사용자의 입력 값에 따라 동작 분기
            if (selectResult.equals("1")) {
                System.out.println("게시판");
                boardAccess = true;
                break;

            } else if (selectResult.equals("2")) {
                boardAccess = false;
                System.out.println("로그아웃을 선택함으로 로그아웃 합니다.");
                break;

            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }


public void selectMenu() {
    if (boardAccess) {
        while (boardAccess && arr.isEmpty()) {
            System.out.println("현재 작성된 리스트가 없어 기능이 제한 됩니다. 1.작성 , 2. 로그아웃");
            boardFunction = sc.nextLine();

            if (boardFunction.equals("1")) {
                System.out.println("제목을 설정 해주세요");
                title = sc.nextLine();
                System.out.println("내용을 입력 해주세요");
                content = sc.nextLine();
                arr.add("제목 : " + title + "\n내용 : " + content);
                System.out.println("게시글이 작성되었습니다.");
                boardAccess1 = true;
                break;

            } else if (boardFunction.equals("2")) {
                System.out.println("로그아웃을 선택함으로 로그아웃 합니다.");
                boardAccess1 = false;
                break;

            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }
        }

    }

}


   public void selectMenu11() {
        while (boardAccess1 && !arr.isEmpty()) {
            try {
                System.out.println("게시글이 있으므로 게시판이 활성화 됩니다.");
                System.out.println("현재 구현된 기능: 1. 작성, 2. 조회, 3. 삭제, 4. 수정, 5. 목록 6.종료 입니다.");
                boardAccess2 = sc.nextLine();


                if (boardAccess2.equals("1")) {
                    System.out.println("게시글을 작성합니다");
                    writePost();
                    break;

                } else if (boardAccess2.equals("2")) {
                    System.out.println("특정 게시글 조회합니다");
                    viewPost();
                    break;

                } else if (boardAccess2.equals("3")) {
                    System.out.println("게시글을 삭제 합니다");
                    deletePost();
                    break;

                } else if (boardAccess2.equals("4")) {
                    System.out.println("게시글을 수정 합니다");
                    editPost();
                    break;

                } else if (boardAccess2.equals("5")) {
                    System.out.println("게시글 목록을 보여줍니다");
                    postList();
                    break;

                } else if (boardAccess2.equals("6")) {
                    System.out.println("프로그램을 종료 합니다");
                    break;

                }else {
                    System.out.println("올바른 번호를 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }



    @Override
    public void writePost() {

        System.out.println("제목을 설정 해주세요");
        title = sc.nextLine();
        System.out.println("내용을 입력 해주세요");
        content = sc.nextLine();
        arr.add("제목 : " + title + "\n내용 : " + content);
        selectMenu11();
    }

    @Override
    public void viewPost() {
        if (!arr.isEmpty()) {

            viewPostAccept = false;

            while (!viewPostAccept) {
                try {
                    System.out.println("몇 번 항목을 조회하시겠습니까?");
                    postnumber = Integer.parseInt(sc.nextLine());
                    int index = postnumber - 1;

                    if (index >= 0 && index < arr.size()) {
                        System.out.println("선택한 항목 : " + (index + 1) + "\n" + arr.get(index));
                        viewPostAccept = true;
                        selectMenu11();
                        break;
                    } else {
                        System.out.println("잘못된 번호입니다. 유효한 범위는 1부터 " + arr.size() + "까지입니다.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요.");
                }
            }
        } else {
            System.out.println("조회할 게시글이 없습니다.");
        }
    }


    @Override
    public void deletePost() {
        if (!arr.isEmpty()) {
            try {
                System.out.println("몇번 항목을 제거 하시겠습니까?");
                postnumber = Integer.parseInt(sc.nextLine());
                arr.remove(postnumber-1);

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            } finally {
                selectMenu11();
            }
        } else {
            selectMenu();
        }
    }

    @Override
    public void editPost() {
        if (!arr.isEmpty()) {
            try {
                System.out.println("몇번 항목을 수정하시겠습니까??");
                postnumber = Integer.parseInt(sc.nextLine());
                System.out.println("제목을 설정 해주세요");
                title = sc.nextLine();
                System.out.println("내용을 입력 해주세요");
                content = sc.nextLine();
                arr.set((postnumber-1),"제목 : " + title + "\n내용 : " + content);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            } finally {
                selectMenu11();
            }
        } else {
            selectMenu();
        }



    }

    @Override
    public void postList() {
        if (!arr.isEmpty()) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.println("항목 " + (i + 1) + ":\n" + arr.get(i));
                System.out.println("---------------------");
            }
        }
        selectMenu11();
    }
    
}

