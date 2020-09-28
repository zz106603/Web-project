<h1>CSS 선택자

<h3>선택자</h3>

---

<h4>선택자</h4>

-  전체 선택자

  - *{color : red;}

- HTML 요소 선택자

  - h2 { color : teal; text-decoration:underline;}

- 아이디 선택자

  - #heding{ color : red;}

- 클래스 선택자

  - .heding{ color : red;}

- 그룹 선택자

  - h2 {color : red;}
  - h2, h3 { color : red;}
  - h2, h3, p { color : red;}

  

<h4>결합 선택자</h4>

- 자손 선택자
  - div p { 스타일; } **(div태그의 하위 요소 중에서  p를 모두 선택)**
- 자식 선택자
  - div > p {스타일;} **(div태그 바로 밑에 존재하는 하위 요소 중에서 p태그를 모두 선택)**



<h4>동위 선택자</h4> (동위 관계에 있는 요소 중 해당 요소보다 뒤에 존재하는 특정 타입의 요소를 모두 선택)

- 일반 동위 선택자 
  - div ~ p {스타일;} **(div뒤에 나오는 p모두 선택)**

```html
<h1>일반 동위 선택자를 이용한 선택</h1>
<p>이 p 태그는 div 태그의 sibling 이지만 div 태그보다 앞에 나옵니다!</p>
<div>
	<p>이 p 태그는 div 태그의 child 입니다!</p>
	<p>이 p 태그는 div 태그의 child 입니다!</p>
	<p>이 p 태그는 div 태그의 child 입니다!</p>
</div>
<p>이 p 태그는 div 태그의 sibling 입니다!</p>
<p>이 p 태그는 div 태그의 sibling 입니다!</p>
```

- 인접 동위 선택자 (해당 요소의 바로 뒤)

  - div + p {스타일;}  **(div바로 뒤에 나오는 p모두 선택)**

  

 <h3>의사 클래스</h3> (HTML요소의 특별한 '상태'를 명시할 때 사용)

---

- 문법

  - 선택자:의사클래스이름 {속성 : 속성값;}
  - 선택자.클래스이름:의사클래스이름 {속성 : 속성값;}
  - 선택자#클래스이름:의사클래스이름 {속성 : 속성값;}

- 대표적인 CSS 의사 클래스

  - 동적 의사 클래스

    - :link -> 링크의 기본상태, 한 번도 이 링크를 통해 연결된 페이지를 방문하지 않은 상태
    - :visited -> 한 번이라도 이 링크를 통해 연결된 페이지를 방문한 상태
    - :hover -> 사용자의 마우스 커서가 링크 위에 올라가 있는 상태 (link와 visited가 정의되어있는 상태)
    - :active -> 사용자가 마우스로 링크를 클릭하고 있는 상태 (hover가 정의되어있는 상태)
    - :focus -> 마우스의 이벤트 또는 다른 형태로 해당 요소가 포커스를 가지고 있는 상태

  - 상태 의사 클래스

    - :checked -> input요소 중에서 체크된 상태의 input 요소
    - :enabled -> input요소 중에서 사용할 수 있는 input요소
    - :disabled -> input요소 중에서 사용할 수 없는 input요소

  - 구조 의사 클래스

    - :first-child -> 모든 자식 요소 중에서 맨 앞에 위치하는 자식 요소를 모두 선택 (<-> last-child)
    - :nth-child -> 모든 자식 요소 중에서 앞에서부터 n번째에 위치하는 자식 요소 (ex) p:nth-child(2n) ) (<-> nth-last-child)
    - :first-of-type -> 모든 자식 요소 중에서 맨 처음으로 등장하는 특정 타입의 요소를 모두 선택
    - :nth-of-type -> 모든 자식 요소 중에서 n번째로 등장하는 특정 타입의 요소를 모두 선택
    - :only-child -> 자식 요소를 단 하나만 가지는 요소의 자식요소를 모두 선택

  - 기타 의사 클래스

    - :not
    - :lang

    

<h3>의사 요소</h3> (해당 HTML요소의 특정 부분만을 선택할 때 사용)

---

- 문법
  - 선택자 :: 의사요소이름 { 속성 : 속성값;}
- ::first-line
  - 텍스트의 첫 라인만을 선택
- ::befor 
  - 특정 요소의 내용부분 바로 앞에 다른 요소를 삽입
- ::after
  - 특정 요소의 내용부분 바로 뒤에 다른 요소를 삽입
- ::selection
  - 사용자가 선택한 부분만을 선택 (더블클릭)



<h3>속성 선택자</h3>

---

- 문법
  - [속성이름]
  - ex)  [title] { background: black; color: yellow; }
  - [속성이름="속성값"]
  - ex)  [title="first h2"] { background: black; color: yellow; }

<h4>문자열 속성 선택자</h4>

- [속성이름~="속성값"] : 특정 속성의 속성값에 특정 문자열로 이루어진 하나의 단어를 포함하는 요소를 모두 선택

  - ex) [title~="first"] { background: black; color: yellow; }
  - first-p는 불가능, **first** p 는 가능

- [속성이름|="속성값"] : 특정 문자열로 이루어진 하나의 단어로 시작하는 요소를 모두 선택

  - ex) [title|="first"] { background: black; color: yellow; }
  - first p 는 안되고 **first-p**는 가능

- [속성이름^="속성값"] : 특정 속성의 속성값이 특정 문자열로 시작하는 요소를 모두 선택

  - ex) [title^="first"] { background: black; color: yellow; }
  - **first p , first-p** 모두 가능

- [속성이름$="속성값"] : 특정 속성의 속성값이 특정 문자열로 끝나는 요소를 모두 선택

- 활용


      <style>
      		input[type="text"] {
      			width: 150px;
      			display: block;
      			background-color: #FFEFD5;
      			margin-bottom: 10px;
      		}
      		input[type="password"] {
      			width: 130px;
      			display: block;
      			background-color: #90EE90;
      			border: 2px solid red;
      		}
      		input[type="password"]:focus { background-color: #FFC0CB; }
      </style>
      <form>
      		사용자 : <br>
      		<input type="text" name="username">
      		비밀번호 : <br>
      		<input type="password" name="password">
      </form>

  

<h3>기타 의사 클래스</h3>

---

- ::not

  - 모든 선택자와 함께 사용할 수 있으며, 해당 선택자를 반대로 적용하여 선택

- ::lang

  - HTML 요소를 사용자 컴퓨터의 언어 설정에 따라 다르게 표현할 때 사용


    ```html
    :lang(en) { quotes: '"' '"'  "'"  "'"; }
    :lang(fr) { quotes: "<<" ">>" "<" ">"; }
    ```
