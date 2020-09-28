<h1>CSS 고급

<h3>내비게이션 바</h3>

---

- 링크를 사용한 리스트 메뉴

  - ```html
    <ul>
        <li><a href="/index.php">Home</a></li>
        <li><a href="/html/intro">HTML</a></li>
        <li><a href="/css/intro">CSS</a></li>
        <li><a href="/javascript/intro">자바스크립트</a></li>
    </ul>
    ```

- **수직 내비게이션 바**

  - 링크를 사용한 리스트 메뉴에 display 속성값을 block으로 설정하면 수직 내비게이션 바를 만들 수 있다.

  - ```html
    <style>
        ul { background-color: #FFDAB9; width: 150px; list-style-type: none; margin: 			0; padding: 0; }
        li a { display: block; color: #000000; padding: 8px; text-decoration: none; 	       font-weight: bold; }
        li a:hover { background-color: #CD853F; color: white; }
    </style>
    ```

  - 클래스를 이용하면 현재 메뉴의 위치 표현 가능

  - ```html
    li a.current {
    			background-color: #FF6347;
    			color: white;
    		}
    li a:hover:not(.current) {
    			background-color: #CD853F;
    			color: white;
    		}
    
    <li><a class="current" href="/html/intro">HTML</a></li>
    ```

- **수평 내비게이션 바**

  - display 속성의 inline 속성값을 이용한 방법

    - ```html
      <style>
          li { display: inline; }
      </style>
      ```

  -  floating 속성을 이용한 방법

    - ```html
      <style>
          li { float: left; }
          li a { display: block; background-color: #FFDAB9; padding: 8px; }
      </style>
      ```

      

<h3>드롭다운</h3>

---

- ```html
  <style>
      .dropdown { position: relative; display: inline-block; }
  
      .dropdown-content {
          display: none; ★
          position: absolute;
          background-color: #F9F9F9;
          min-width: 160px;
          padding: 8px;
          box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
      }
      .dropdown:hover .dropdown-content { display: block; } ★
  </style>
  
  <div class="dropdown">
  		<span>여기에 마우스를 올려보세요!</span>
  		<div class="dropdown-content">
  			<p>마우스를 올려야 나타나는 div 요소입니다!</p>
  		</div>
  </div>
  
  ->  dropdown-content의 display를 none으로 하여 보이지 않게 하고 
  	dropdown:hover가 이루어지면 dropdown-content의 display를 block으로
  ```

- ```html
  <style>
  		.dropdown-button {
  			background-color: #FFDAB9;
  			padding: 10px;
  			font-size: 15px;
  			border: none;
  		}
  		.dropdown {
  			position: relative;
  			display: inline-block;
  		}
  		.dropdown-content {
  			display: none;
  			position: absolute;
  			background-color: #FFDAB9;
  			min-width: 75px;
  			padding: 7px;
  			box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  		}
  		.dropdown-content a {
  			color: black;
  			padding: 10px;
  			text-decoration: none;
  			display: block;
  		}
  		.dropdown-content a:hover { background-color: #CD853F; }
  		.dropdown:hover .dropdown-content { display: block; }
  		.dropdown:hover .dropdown-button { background-color: #CD853F; }
  </style>
  <div class="dropdown">
  		<button class="dropdown-button">Dropdown</button>
  		<div class="dropdown-content">
  			<a href="#">HTML</a>
  			<a href="#">CSS</a>
  			<a href="#">JAVA</a>
  			<a href="#">C++</a>
  		</div>
  </div>
  
  -> dropdown에 hover가 이루어지면 content를 보여준다.
  ```



<h3>툴팁 효과</h3>

---

- 해당 요소에 마우스를 올리면 추가적인 정보가 나타나게 하는 효과

- visiblility 속성을 이용

- ```html
  <style>
  		.tooltip {
  			position: relative;
  			display: inline-block;
  		}
  		.tooltip .tooltip-content {
  			visibility: hidden; ★
  			width: 300px;
  			background-color: orange;
  			padding: 0;
  			margin-top: 10px;
  			color: white;
  			text-align: center;
  			position: absolute;
  			z-index: 1;
  		}
  		.tooltip:hover .tooltip-content { visibility: visible; } ★
  </style>
  
  <div class="tooltip">
  		<span>여기에 마우스를 올려보세요!</span>
  		<div class="tooltip-content">
  			<p>마우스를 올려야 나타나는 툴팁입니다!</p>
  		</div>
  </div>
  ```

- 툴팁의 모양을 말풍선처럼

- ```html
  <style>
  		body { text-align: center; }
  		.tooltip {
  			position: relative;
  			display: inline-block;
  			margin: auto;
  		}
  		.tooltip .tooltip-content {
  			visibility: hidden;
  			width: 220px;
  			background-color: orange;
  			padding: 0;
  			color: white;
  			text-align: center;
  			position: absolute;
  			z-index: 1;
  			bottom: 180%;
  			left: 50%;
  			margin-left: -110px;
  		}
  		.tooltip .tooltip-content::after {
  			content: " ";
  			position: absolute;
  			top: 100%;
  			left: 50%;
  			margin-left: -10px;
  			border-width: 10px;
  			border-style: solid;
  			border-color: orange transparent transparent transparent;
  		}
  		.tooltip:hover .tooltip-content { visibility: visible; }
  </style>
  <div class="tooltip">
  		<span>여기에 마우스를 올려보세요!</span>
  		<div class="tooltip-content">
  			<p>위쪽에 나타나는 툴팁입니다!</p>
  		</div>
  </div>
  ```



<h3>Form요소</h3>

---

- input요소 크기 설정

  - ```html
    <style>
        input { width: 100%; padding: 10px 20px; margin: 5px 0; box-sizing: border-				box; }
    </style>
    ```

- input요소 테두리, focus 설정

  - ```html
    <style>
    		input {
    			width: 30%;
    			padding: 10px 20px;
    			margin: 5px 0;
    			box-sizing: border-box;
                
                background-image: url("/examples/images/img_search_icon.png"); 
                background-position: 5px 4px;
    			background-repeat: no-repeat;
                -> 배경에 이미지 삽입 가능
    		}
    		input[type="text"] {
    			border: solid 1px #D2691E;
    			border-radius: 4px;
    		}
    		input[type="password"] {
    			border: none;
    			border-bottom: solid 1px #D2691E;
    		}
        
    	    input[type="text"]:focus { border: solid 2px #D2691E; }
    		input[type="password"] { border: solid 1px black; }
    		input[type="password"]:focus { background-color: #E0FFFF; }
    </style>
    
    -> text는 1px solid의 둥근네모
    -> password는 1px solid의 아래 선
    ```

- textarea요소 크기 조절

  - ```html
    textarea {
    			width: 100%;
    			height: 200px;
    			padding: 10px;
    			box-sizing: border-box;
    			border: solid 2px #1E90FF;
    			border-radius: 5px;
    			font-size: 16px;
    			resize: both;
    }
    ```

- select 요소에 스타일 적용

  - ```html
    <style>
    		select {
    			width: 50%;
    			padding: 10px;
    			border: solid 1px black;
    			border-radius: 5px;
    			background-color: #FFFFE0;
    		}
    </style>
    ```



<h3>@규칙</h3>

---

- @import 규칙

  - 다른 스타일 시트에서 규칙을 가져올 수 있는 규칙

  - ```html
    - HTML 문서
    <head>
        <title>@import 규칙</title>
        <link rel="stylesheet" href="firstStyleSheet.css">
        <link rel="stylesheet" href="secondStyleSheet.css">
    </head>
    
    - firstStyleSheet.css
    @import url("thirdStyleSheet.css");
    @import "fourthStyleSheet.css";
    ...
    ```

  - 프린트할 때에는 firstStyleSheet.css 파일을 불러오고, 스크린이 가로 방향으로 설정되어 있을 때는 secondStyleSheet.css 파일을 불러오는 예제

  - ```html
    <head>
        <title>@import 규칙</title>
        @import url("firstStyleSheet.css") print;
        @import "secondStyleSheet.css" screen and (orientation:landscape);
    </head>
    ```

- font-face 규칙

  - 웹 폰트를 정의할 때 사용하는 규칙

  - 사용자의 컴퓨터에 설치되어 있지 않은 글꼴을 웹 브라우저가 사용할 수 있게 함

  - ```html
    <style>
        @font-face {
            font-family: "myWebFont";
            src: local("NanumGothic"), url("NanumGothic.eot"), url("NanumGothic.ttf"), url("NanumGothic.woff");
        }
    
        * { font-family: "myWebFont"; }
    </style>
    ```

- @media 규칙

  - 서로 다른 미디어 타입을 위한 맞춤식 스타일 시트 지원

  - HTML문서가 스크린에 표현될 때와 프린트할 때 서로 다른 스타일을 적용하는 예제

  - ```html
    <style>
        body { background-color: darkorange; }
        @media screen {
            body { background-color: black; color: white; }
        }
        @media print {
            body { background-color: white; color: black; }
        }
    </style>
    ```

    