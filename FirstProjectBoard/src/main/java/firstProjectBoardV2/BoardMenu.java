package firstProjectBoardV2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BoardMenu {
    Scanner sc = new Scanner(System.in);
    PostFunctionV2 pf = new PostFunctionV2();
    BoardFuntionV2 bf = new BoardFuntionV2();
    Map<String, Runnable> urlsetting = new HashMap<>();

    private String boardOption;

    public BoardMenu() {
        urlsetting.put("/add", pf::writePost);
        urlsetting.put("/view", pf::viewPost);
        urlsetting.put("/remove", pf::deletePost);
        urlsetting.put("/edit", pf::editPost);
        urlsetting.put("/list", pf::postList);
    }

    public void menuBoard() {

        while (true) {
            Map<String, Runnable> Function = new HashMap<>();
            Function.put("/add",bf::addBoard);
            Function.put("/view",bf::entryBoard);
            Function.put("/remove",bf::removeBoard);
            Function.put("/edit",bf::editBoard);
            Function.put("/list",bf::listBoard);


            System.out.println("어떤 기능을 사용 하시겠습니까? /add, /view ,/remove, /list ,/logout");
            System.out.print( "URL : http://www.board.com/board");
            boardOption = sc.nextLine();
            Runnable action = Function.get(boardOption);

            if (action != null) {
                action.run();
            } else if (boardOption.equals("/logout")) {
                System.out.println("로그아웃 합니다");
                break;
            } else {
                System.out.println("처리 불가능");
            }
        }
    }
}
