package firstProjectBoardV2;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuV2  {
    ArrayList<String> arr = new ArrayList<>();
    Scanner sc = new Scanner(System.in);



    private String boardFunction;
    private boolean boardAccess;
    private boolean boardAccess1 = false;
    private String boardAccess2;



    public void setBoardAccess(boolean b) {
        this.boardAccess = b;
    }

    public boolean isBoardAccess()
    {
        return boardAccess;

    }

    private String title;
    private String content;

    public void selectMenu() {

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


    public void selectMenu2() {
        while (boardAccess1 && !arr.isEmpty()) {

            System.out.println("게시글이 있으므로 게시판이 활성화 됩니다.");
            System.out.println("현재 구현된 기능: 1. 작성, 2. 조회, 3. 삭제, 4. 수정, 5. 목록 6.종료 입니다.");
            boardAccess2 = sc.nextLine();


            if (boardAccess2.equals("1")) {
                System.out.println("게시글을 작성합니다");
                bf.writePost();
                break;

            } else if (boardAccess2.equals("2")) {
                System.out.println("특정 게시글 조회합니다");
                bf.viewPost();
                break;

            } else if (boardAccess2.equals("3")) {
                System.out.println("게시글을 삭제 합니다");
                bf.deletePost();
                break;

            } else if (boardAccess2.equals("4")) {
                System.out.println("게시글을 수정 합니다");
                bf.editPost();
                break;

            } else if (boardAccess2.equals("5")) {
                System.out.println("게시글 목록을 보여줍니다");
                bf.postList();
                break;

            } else if (boardAccess2.equals("6")) {
                System.out.println("프로그램을 종료 합니다");
                break;

            }else {
                System.out.println("올바른 번호를 입력해주세요.");

            }
        }
    }

}
