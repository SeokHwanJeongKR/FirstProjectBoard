##프로젝트 이름
간이 게시판 시스템
차후에 실제 제대로 된 게시판을 구현 하기 위한 간이 게시판 시스템을 만들어 봤습니다
---
##주요기능
회원 관리, 로그인 , 게시판 관리, 게시물 관리

## 트러블 슈팅 문제점1
**1. 문제를 직면** :
post의 기능들 작성, 수정, 삭제, 목록들을 만들었을떄 기능들을 묶는 것 까지는 괜찮았는데 스캐너로 add라는 명령어를 넣었을때 어떻게 addPost()라는 메서드가 작동이 되게 할 것인가가 문제가 되었다.

**2. 그에 대한 고민** : 메서들을 어떻게 스캐너로 받아서 호출을 하나 생각하며 잠이 들었는데 아침에 일어나서 map에는 key와 value를 넣는데 혹시 value에 메서드를 넣는 것도  가능 하지 않을까 라는 생각이 들었다.

**3. 해결 방안 모색** : 그 이후 map에 대해 구글링을 하였고  Map<String, Runnable> 라는 것을 알게 되었다.

**4. 해결** :
Runnable 타입은 작업을 정의하고 이를 실행할 수 있는 형태로 제공하는 타입이라고 한다.

       Map<String, Runnable> Postfunction = new HashMap<>();
       Postfunction.put("/add",pf::writePost);
       Postfunction.put("/view",pf::viewPost);
       Postfunction.put("/remove",pf::deletePost);
       Postfunction.put("/edit",pf::editPost);
       Postfunction.put("/list",pf::postList);

그로 인해 위와 같은 형태로 처음에는 string타입을 받고 Runable타입을 받아 실행한다.라는 방식으로 명령어를 받으면 메서드를 호출 할 수 있게 만들었다.


**5. 그에 대한 후기** :
메서드를 map에 넣을 수 있다는 것을 알게 되었을 때 와 이런 방식이면 Arraylist에도 메서드를 넣을 수 있겠구나 하면서 엄청 할 수 있는게 많아지겠네 라는 생각을 하게 되었다. 
그 만큼 생각을 해야 하는 것도 너무나 많아 질 것 같아 멘붕 이였다.


---

## 트러블 슈팅 문제점2
**1. 문제를 직면** :
post의 기능들을 가진 board라는 객체를 만드는데 각각의 객체가 post들을 공유하지 않게 하는 법이 문제였다.


**2. 그에 대한 고민** :
board라는 객체를 만든 후 map의 key와 value에 넣거나 Arraylist에 넣으면 되지 않을까 생각을 하였지만
map같은 경우 key만 바꾸기가 쉽지 않고 복사를 한 후에 지우는 방식으로 해야해서 할 수가 없을 듯 하였다.


**3. 해결 방안 모색** : 
구글링으로 Arraylist에 객체를 생성과 동시에 등록을 하는 방법을 찾아봣다.


**4. 해결** :
   
       ArrayList<String> boardNames = new ArrayList<>();

       ArrayList<PostFunctionV2> board = new ArrayList<>();

       boardNames.add(boardname);

       board.add(new PostFunctionV2());

   위의 방식 과 같이  PostFuntionV2타입의 어레이 리스트를 생성하고 Arraylist에 PostFuntionV2타입의 객체를 생성과 동시에 할당 해주면 된다.
   하지만 이 방식만으로는 끝난 것이 아니며 지금은 객체 생성까지만 왔다. 나는 객체 생성 후 따로 객체에 저장된 post값도 가져와야 한다.

       PostFunctionV2 selectedBoardFunction = board.get(boardnumber - 1);  
       menuPost(selectedBoardFunction);

   위와 같이 postFunctionV2 타입의 변수를 만들어주고 ArrayList<PostFunctionV2> 타입의 board에 있는 배열에 저장된 객체를 넣어준다. 그리고 나서 menuPost()에 인자로 넣어준다.
그 이유는 menuPost를 통해서 Post의 기능을 불러오는데 MenuPost에 (PostFunctionV2 pf) 타입 매개변수를 넣음으로써 인자가 함수를 호출 할때 값을 전달하여 viewboard를 하면 
menuPost를 불러오기에 selectedBoardFuntion에 할당 된 board에만 post가 저장된다.




**5. 그에 대한 후기** :
진짜 이 과정에서 코드들이 얼마나 얽히고 얽히는지 느꼈는데....
인자와 매개변수의 사용의 중요성을 너무나도 느꼇다....
진짜 다시 처음부터 하라고 하면 아마 바로 못할 듯하다.
내가 이것들을 해결은 했으나 바로 10초만에 아 이렇게 해야지 할 정도는 아닌 듯 하여
같은 방식의 문제를 몇번이고 해결을 해보며 나한테 체화를 시켜야 한다는 것을 느꼈다.

