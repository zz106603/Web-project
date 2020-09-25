<h1>CSS 기본 속성

<h3>background 속성</h3>

---

- background-color : #00F000;

- background-image : url("~~.png");

- background-repeat : repeat-x **(x축으로 반복)**

- background-repeat : no-repeat **(반복x)**
- background-position : **(배경 위치)**
  - left top
  - right top
  - left bottom
  - right center
  - ...
- background-attachment : fixed **(배경 고정)**

<h3>css 텍스트</h3>

---


- color : red;
- direction : rtl; **(텍스트가 써지는 방향 설정)** 
  - rtl (right to left)
  - ltr (left to right)1
- letter-spacing : -3px; **(글자 사이 간격 설정)**
- word-spacing : 10px; **(단어 사이 간격 설정)**
- text-indent : 30px; **(들여쓰기 설정)**
- text-align :  **(수평방향 정렬)**
  - left
  - right
  - center
- text-decoration :  **(줄 설정)**
  - overline [윗줄]
  - line-through [가운데 줄]
  - underline [밑줄]
  - none [링크에 생기는 밑줄 제거]
- text-transform : **(대소문자 설정)**
  - uppercase
  - lowercase
  - capitalize [첫 문자만을 대문자로]
- line-height : 0.8; **(줄 간격)**
- text-shadow : 2px 1px #3399CC; **(그림자 효과)**

<h3>css 글꼴</h3>

---

- font-family : "Times New Roman", Times, serif; **(순서대로 확인)**
- font-style : **(글씨 스타일)**
  - normal
  - italic
  - oblique

- font-variant : small-caps; **(모든 소문자를 작은 대문자로 변경)**
- font-weight : **(두꺼움 정도)**
  - normal
  - 600;
  - bolder

- font-size : **(절대적, 상대적)**
  - 100%
  - 2.5em
  - 20px [절대적]

<h3>css 링크</h3>

---


- color, font-family, background 등 다양한 속성들 적용 가능


    <style>
    	a {
    	    background-color: #FFFFE0;
        	color: darkslategray;
    	    font-size: 1.3em;
    	    text-decoration: none;
    	}
    
    	a:link { color: olive; }
    	a:visited { color: brown; }
    	a:hover { color: coral; }
    	a:active { color: khaki; }
    </style>

- a:link {color : blue}
  - 링크의 기본상태이며 한 번도 해당 링크를 통해 연결된 페이지를 방문하지 않은 상태
- a:visited {color : blue}
  - 사용자가 한 번이라도 해당 링크를 통해 방문한 상태
- a:hover {color : blue}
  - 사용자의 마우스 커서가 링크 위로 올라가 있는 상태
- a:active {color : blue}
  - 사용자가 마우스로 링크를 클릭하고 있는 상태
- a:focus 
  - 키보드나 마우스의 이벤트 또는 다른 형태로 해당 요소가 포커스를 가지고 있는 상태

- 링크를 버튼처럼 만들기


    <style>
    	a:link, a:visited {
    	    background-color: #FFA500;
    	    color: maroon;
    	    padding: 15px 25px;
    	    text-align: center;
    	    text-decoration: none;
    	    display: inline-block;
    	}
    	a:hover, a:active { background-color: #FF4500; }
    </style>



<h3>css 리스트</h3>

---


- list-style-type : **(다양한 마커(marker) 적용)**
  - circle
  - square
  - upper-alpha
  - lower-roman
- list-style-image : url("~~.png"); **(marker로 자신만의 이미지 사용 가능)**
- list-style-position : **(요소의 위치 설정)**
  - outside [기본설정]
  - inside
- 한 번에 적용


    <style>
    	ul { list-style: square inside url("/examples/images/img_list_marker.png"); }
    </style>

- 리스트 요소별 배경색 설정


    <style>
    	ul { background: #D2691E; padding: 15px; }
    	ol { background: #6495ED; padding: 15px; }
    	ul li { background: #DEB887; margin: 5px; }
    	ol li { background: #00FFFF; margin-left: 15px; }
    </style>



<h3>css 테이블</h3>

---


- table, th, td {border : 2px solid black;} **(테이블 테두리 설정)**
  - table, th, td에서 테두리가 두줄씩 나타나는 것 방지 ↙
  - border-collapse : collapse;
- border-spacing : 20px 30px **(th, td간의 여백 설정)**
- vertical-align **(th, td 내부에서 수직 방향 정렬 설정)**

  - top; height : 50px;
  - bottom; height : 50px;
- border-bottom **(th, td태그에 사용하여 수평 나눔선만으로 만든 테이블)**


  ```html
  <style>
  	table { border-collapse: collapse; width: 100%; }
  	th, td { padding: 10px; border-bottom: 1px solid #CD5C5C; }
  </style>
  ```

- tr : hover {background-color : #f5f5f5} **(tr태그에 마우스를 올리면 행 전체 하이라이트)**

- tr : nth-child(odd) {background-color : #f5f5f5} **(얼룩무늬 효과)**



<h3>css 이미지 스프라이트</h3>

---


- 여러 개의 이미지를 하나의 이미지로 합쳐서 관리하는 이미지를 의미


    <style>
    	.up, .down, .right, .left { 
    		background: url("/examples/images/img_image_sprites.png") no-repeat; 
    	}
    
    	.up { width: 21px; height: 20px; background-position: 0 0; }
    	.down { width: 21px; height: 20px; background-position: -21px 0; }
    	.right { width: 22px; height: 20px; background-position: -42px 0; }
    	.left { width: 22px; height: 20px; background-position: -65px 0; }
    </style>

