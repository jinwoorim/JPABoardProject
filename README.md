# JPABoardProject

 - SpringBoot, SpringSecurity, JPA를 학습하여 진행한 프로젝트
 - 1:1 상담 게시판 프로그램

## 기술 스텍

 - Language : Java17
 - Framework : SpringBoot(v2.7.1), SpringSecurity(v2.7.1), JPA(v2.7.1)
 - View : JSP, AJAX
 - WAS : Tomcat(v9.0)
 - DB : H2(1.4.199)

## 프로그램 실행 과정

### 1) 어플리케이션 실행시 초기 화면

 <img src = "https://user-images.githubusercontent.com/102512612/197692561-20f76d53-46b8-48aa-9c4e-94cfd39bef20.png"/>

### 2) 회원가입

 - 초기화면에서 상단의 회원가입을 클릭하게되면 회원가입 페이지로 이동

 <img src ="https://user-images.githubusercontent.com/102512612/197692938-1f5a9fec-5dcf-4c4e-95dc-48278a96f556.png"/>

 - Username, Password, Email을 입력하고 회원가입 버튼을 누르게되면 팝업창이 뜨며 확인을 누르면 회원가입과 동시에 홈페이지로 이동

 <img src = "https://user-images.githubusercontent.com/102512612/197693143-638f10ea-f53b-41ba-a1d5-9a291dbf7e6a.png"/>

### 3) 로그인

 - 홈페이지 상단에 로그인을 클릭하게되면 로그인 페이지로 이동

 <img src ="https://user-images.githubusercontent.com/102512612/197693550-1be64bc6-659e-46b4-81bf-1501f8fc65dc.png"/>

 - Username, Password를 입력하고 로그인 버튼을 클릭하여 로그인 진행

 <img src ="https://user-images.githubusercontent.com/102512612/197694142-bb4701e0-2286-4de1-9aed-1642704baa00.png"/>

 - 홈페이지로 이동되며 로그인 중에는 상단의 메뉴바가 회원상세, 1:1문의, 로그아웃으로 바뀜

 <img src ="https://user-images.githubusercontent.com/102512612/197694341-a6d4aad5-d2db-483a-9ad6-debaec9d26b5.png"/>

### 4) 1:1 문의

 - 홈페이지에서 1:1문의를 클릭하게되면 해당 페이지로 이동하게된다

 <img src ="https://user-images.githubusercontent.com/102512612/197696283-902de848-2797-4d59-a035-b63d419d256c.png"/>

 - Title과 Summernote에 글을 입력하고 포스트등록 버튼을 누르면 팝업 창이 뜨며 확인을 누르게 되면 1:1문의 글이 등록이 되고 홈페이지로 이동하게된다

 <img src ="https://user-images.githubusercontent.com/102512612/197696761-bf534b00-9c40-48de-8e66-5d3f412a25c6.png"/>

 <img src ="https://user-images.githubusercontent.com/102512612/197696919-cb39e266-3a8c-487a-943c-afe7bf2c857d.png"/>

 - 1:1문의 글이 한 페이지에서 3개가 넘어가게되면 다음 페이지 버튼이 활성화된다

 <img src ="https://user-images.githubusercontent.com/102512612/197697472-8bf6ea75-0187-48ab-a383-7a61e55739c0.png"/>

 <img src ="https://user-images.githubusercontent.com/102512612/197697610-71182d75-c748-4a57-8657-560b90eb7865.png"/>

### 5) 1:1 문의 상세 보기

 - 1:1 문의 글의 상세 보기 버튼을 누르게 되면 상세 보기 화면으로 이동한다
 - 해당 문의 글이 본인의 글이라면 돌아가기, 수정하기, 삭제하기 버튼이 표시된다
 - 만약 본인의 문의 글이 아니라면 돌아가기 버튼만 표시된다

 <img src ="https://user-images.githubusercontent.com/102512612/197698243-c728831e-b485-4e26-9700-2f39cf08fe1f.png"/>

 <img src ="https://user-images.githubusercontent.com/102512612/197698495-8a3005b4-d7c8-43bb-8aca-ed335ab1fc7e.png"/>

### 6) 1:1 문의 수정 하기

 - 수정하기 버튼을 누르게 되면 1:1 문의 글을 수정할 수 있는 페이지로 이동한다
 - 해당 글을 수정하고 포스트수정 버튼을 누르게되면 팝업 창이 뜨며 확인 버튼을 누르게되면 해당 글이 수정되고 홈 화면으로 이동한다

 <img src ="https://user-images.githubusercontent.com/102512612/197699217-191a6eff-041d-4d23-83b5-07a59cdc5ecf.png"/>

 <img src ="https://user-images.githubusercontent.com/102512612/197699337-71e643a3-9825-4de7-ac5f-b1345a1ed6c2.png"/>

### 7) 덧글 

 - 1:1 문의 글 상세 보기 화면에서 덧글을 등록할 수 있다
 - 본인의 1:1 문의 글에 덧글을 다는 경우 해당 덧글을 삭제할 수 있는 삭제 버튼이 표시된다
 - 그렇지 않다면 삭제버튼은 표시되지 않는다

 <img src ="https://user-images.githubusercontent.com/102512612/197700760-77ebbdcf-4519-4f48-ac4b-9b0120502b39.png"/>

 - 덧글 삭제 버튼을 누르게되면 해당 덧글이 삭제된다

 <img src ="https://user-images.githubusercontent.com/102512612/197701172-8aed0664-5bd3-4936-9bae-f92c29e841a9.png"/>

### 8) 1:1 문의 글 삭제하기

 - 1:1 문의 글 상세 보기 화면에서 해당 글을 삭제하기 버튼을 누르게되면 팝업 창이 뜨고 확인을 누르게 되면  등록 되있던 덧글과 함께 DB에서 삭제된다

 <img src ="https://user-images.githubusercontent.com/102512612/197701627-4474014f-5b92-4faa-a8c8-fad86ebfb8f3.png"/>
 
 <img src ="https://user-images.githubusercontent.com/102512612/197701824-00364e53-e546-45e4-a438-21e93e5b2eb2.png"/>

