package firstProjectBoardV2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuV2 {
    Scanner sc = new Scanner(System.in);
    BoardfunctionV2 bf = new BoardfunctionV2();
    Map<String, Runnable> urlsetting = new HashMap<>();


    private String boardFunction;
    private String checkFution;
    private String boardname;
    private String board;

    public MenuV2() {
        urlsetting.put("/add",bf::writePost);
        urlsetting.put("/view",bf::viewPost);
        urlsetting.put("/remove",bf::deletePost);
        urlsetting.put("/edit",bf::editPost);
        urlsetting.put("/list",bf::postList);

    }

    public MenuV2 (String name) {
        this.boardname = name;
    }

    @Override
    public String toString() {
        return boardname;
    }

    public String getBoardFunction() {
        return boardFunction;
    }
    public void selectatBoard() {
        while (true) {
            System.out.println("현재 가능 한 기능 (/addboard, /back");
            System.out.println("현재 가능한 기능 (/add, /view, /remove, /edit, /back)");
            System.out.print( "http://www.board.com/board");
            checkFution= sc.nextLine();
            Runnable action = urlsetting.get(checkFution);

            if (action != null) {
                action.run();
                break;
            } else if (checkFution.equals("/back")) {
                System.out.println("메뉴로 돌아갑니다");
                break;
            }else {
                System.out.println("처리 불가능");
            }

        }
    }






    public void callboardfunction() {
        while(true) {
            System.out.println("현재 가능한 기능 (/add, /view, /remove, /edit, /back)");
            System.out.print( "http://www.board.com/board");
            checkFution= sc.nextLine();
            Runnable action = urlsetting.get(checkFution);

            if (action != null) {
                action.run();
                break;
            } else if (checkFution.equals("/back")) {
                System.out.println("메뉴로 돌아갑니다");
                break;
            }else {
                System.out.println("처리 불가능");
            }
        }
    }


    public void selectMenu() {

        while (bf.isMemberBoardAccess() && bf.arr.isEmpty()) {
            System.out.println("현재 작성된 리스트가 없어 기능이 제한 됩니다. /add, /back");
            System.out.print( "http://www.board.com/board");
            boardFunction = sc.nextLine();
            Runnable action = urlsetting.get(boardFunction);


            if(boardFunction.equals("/back")) {
                System.out.println("메뉴로 돌아갑니다");
                break;
            } else if (boardFunction.equals("/add")) {
                action.run();
            } else {
                System.out.println("처리 불가능");
            }
        }

        while(bf.isMemberBoardAccess() && !bf.arr.isEmpty()) {
            System.out.println("현재 가능한 기능 (/add, /view, /remove, /edit, /back, /list)");
            System.out.print( "http://www.board.com/board");
            boardFunction= sc.nextLine();
            Runnable action = urlsetting.get(boardFunction);

            if(boardFunction.equals("/back")) {
                System.out.println("메뉴로 돌아갑니다");
                break;
            } else if (action != null) {
            action.run();
            } else {
                System.out.println("처리 불가능");
            }

        }
    }
    public void visitorsMenu() {

        while (bf.isMemberBoardAccess() && bf.arr.isEmpty()) {
            System.out.println("현재 작성된 글이 없으며 방문자이기에 기능이 제한 됩니다. (/back)" );
            boardFunction = sc.nextLine();
            Runnable action = urlsetting.get(boardFunction);


            if(boardFunction.equals("/back")) {
                System.out.println("메뉴로 돌아갑니다");
                break;
            } else if (boardFunction.equals("/list")) {
                action.run();
            } else {
                System.out.println("처리 불가능");
            }


        }

        while(bf.isMemberBoardAccess() && !bf.arr.isEmpty()) {
            System.out.println("방문자이기에 기능이 제한 됩니다. ( /view, /back, /list)");
            System.out.print( "http://www.board.com/board");
            boardFunction= sc.nextLine();
            Runnable action = urlsetting.get(boardFunction);

            if(boardFunction.equals("/back")) {
                System.out.println("메뉴로 돌아갑니다");
                break;
            } else if (boardFunction.equals("/list") || boardFunction.equals("/view")) {
                action.run();
            } else {
                System.out.println("처리 불가능");
            }

        }


    }



}
