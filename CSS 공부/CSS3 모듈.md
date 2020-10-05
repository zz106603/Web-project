<h1>CSS3 모듈
<h3>CSS3 개요</h3>

---

- 이전버전 CSS와 완전히 호환되는 CSS의 최신 표준 권고안
- 변경사항
  - 선택자(selectors) Level 3
  - 미디어 쿼리(Media Queries) Level 3
  - 색(Color) Level 3
  - 네임스페이스(Namespaces)
- CSS3 모듈
  - 선택자
  - 박스 모델
  - 배경
  - 이미지
  - 텍스트 효과
  - 2D 변형
  - 3D 변형
  - 애니메이션
  - 다중 칼럼 레이아웃
  - 사용자 인터페이스



<H3>벤더 프리픽스</H3>

---

- 주요 웹 브라우저 공급자가 새로운 실험적인 기능을 제공할 때 이전 버전의 웹 브라우저에 그 사실을 알려주기 위해 사용하는 접두사를 의미

```html
<style>
    .button {
        background: red;          <!-- gradient 속성을 지원하지 않는 모든 브라우저를 위한 코드 -->
        background: -webkit-linear-gradient(red, yellow); <!-- 크롬과 사파리 4.0 이상을 위한 코드 -->
        background: -moz-linear-gradient(red, yellow);    <!-- 파이어폭스 3.6 이상을 위한 코드 -->
        background: -ms-linear-gradient(red, yellow);     <!-- 익스플로러 10.0 이상을 위한 코드 -->
        background: -o-linear-gradient(red, yellow);      <!-- 오페라 10.0 이상을 위한 코드 -->
        background: linear-gradient(red, yellow);         <!-- CSS 표준 문법 코드 -->
    }
</style>
```



<H3>CSS3 색</H3>

---

- RGBA 색상값으로 표현
- HSL 색상값으로 표현
- HSLA 색상값으로 표현
- opacity 속성



<h4>RGBA 색상값</h4>

- RGB 색상값에 알파 채널 값을 더한 색상값
- 알파 채널이란 색상의 투명도를 나타내는 채널
-  \#header_01 {background-color: rgba(**0,255,0,0**);}



<h4>HSL 색상값</h4>

- 빛의 삼원색으로 표현하는 RGB과는 달리 색상, 채도, 명도를 사용해서 색을 표현
- H : 색상, S : 채도, L : 명도
-  \#header_01 {background-color: hsl(**0**, **100%**, **50%**);}



<h4>HSLA 색상값</h4>

- HSL 색상값에 알파 채널 값을 더한 색상값
-  \#header_01 {background-color: hsla(**0**, **100%**, **50%**, **0**);}



<h4>opacity 속성</h4>

- 색상에 대한 투명도를 설정
-  \#header_01 {background-color: rgb(**0,255,0**); opacity:**0**}
- opacity 속성은 설정한 요소의 모든 자식 요소까지 전부 같은 투명도로 설정 But, 알파 채널은 투명도를 설정한 요소에만 투명도를 설정



<H3>CSS3 선형 그래디언트</H3>

---

- 둘 이상의 색 사이의 색상 표현을 부드럽게 전화해주는 효과를 의미
- 선형 그래디언트
- 원형 그래디언트



<h4>선형 그래디언트</h4>

- 문법 =>  background: linear-gradient(진행방향, 색상지정점1, 색상지정점2, ...);

- ```html
  <style>
  		#grad {
  			height: 200px;
  			background: red;
  			background: -webkit-linear-gradient(left, red, orange, yellow, green, blue, indigo, purple);
  			background: -moz-linear-gradient(left, red, orange, yellow, green, blue, indigo, purple);
  			background: -o-linear-gradient(left, red, orange, yellow, green, blue, indigo, purple);
  			background: linear-gradient(to right, red, orange, yellow, green, blue, indigo, purple);
  		}
  </style>
  ```

- 기본 방향은 위쪽에서 아래쪽

- 효과의 진행 방향을 각도로 명시하여 설정할 수도 있음 ( background: linear-gradient(**225deg**, green, yellow);  )

- 투명도를 지원, 지정된 색상이 서서히 사라지는 효과를 사용할 수 있다(RGBA 투명도를 이용)

- ```html
  <style>
      #grad {
          background: green;
          background: -webkit-linear-gradient(left, rgba(0,255,0,1), rgba(0,255,0,0));
          background: -moz-linear-gradient(left, rgba(0,255,0,1), rgba(0,255,0,0));
          background: -o-linear-gradient(left, rgba(0,255,0,1), rgba(0,255,0,0));
          background: linear-gradient(to right, rgba(0,255,0,1), rgba(0,255,0,0));
      }
  </style>
  ```

- repeating-linear-gradient() 메소드 : 선형 그래디언트가 계속 반복되도록 설정

- ```html
  <style>
      #grad {
          background: green;
          background: -webkit-repeating-linear-gradient(150deg, red, white 10%, blue 20%);
          background: -moz-repeating-linear-gradient(150deg, red, white 10%, blue 20%);
          background: -o-repeating-linear-gradient(150deg, red, white 10%, blue 20%);
          background: repeating-linear-gradient(150deg, red, white 10%, blue 20%);
      }
  </style>
  ```



<h4>원형 그래디언트</h4>

- 문법 =>  background: radial-gradient(모양 크기 at 중심점, 색상지정점1, 색상지정점2, ...);

- 기본적으로 타원, 크기는 farthest-corner, 중심좌표는 center로 설정

- ```html
  <style>
      #grad {
          background: red;
          background: -webkit-radial-gradient(red, orange, yellow, green, blue, indigo, purple);
          background: -moz-radial-gradient(red, orange, yellow, green, blue, indigo, purple);
          background: -o-radial-gradient(red, orange, yellow, green, blue, indigo, purple);
          background: radial-gradient(red, orange, yellow, green, blue, indigo, purple);
      }
  </style>
  ```

- 색상 지정점 사이의 간격 조절

- ```html
  background: radial-gradient(red 5%, yellow 20%, orange 50%);
  ```

- 크기 설정

  - closest-side : 원형 그래디언트의 크기가 가장 가까운 면에 닿을 만큼의 크기로 설정
  - farthest-side : 가장 먼 면에 닿을 만큼의 크기로 설정
  - colsest-corner : 가장 가까운 모서리에 닿을 만큼의 크기로 설정
  - farthest-corner : 가장 먼 모서리에 닿을 만큼의 크기로 설정

- repeating-radial-gradient() 메소드

- ```html
  <style>
      #grad {
          background: red;
          background: -webkit-repeating-radial-gradient(red, white 10%, blue 20%);
          background: -moz-repeating-radial-gradient(red, white 10%, blue 20%);
          background: -o-repeating-radial-gradient(red, white 10%, blue 20%);
          background: repeating-radial-gradient(red, white 10%, blue 20%);
      }
  </style>
  ```



<H3>CSS3 그림자 효과</H3>

---

- text-shadow

  - 문법 => text-shadow: **그림자의x축값** **그림자의y축값** **blur값** 색상값;

  - ```html
    <style>
        #shadow_01 { text-shadow: 2px 2px; }
        #shadow_02 { text-shadow: 2px 2px orange; }
        #shadow_03 { text-shadow: 2px 2px 5px; }
        #shadow_04 { text-shadow: 0 0 3px red; }
        #shadow_05 { text-shadow: 1px 1px 2px black, 0 0 20px purple, 0 0 5px maroon; }
    </style>
    ```

- box-shadow

  - 문법은 text-shadow와 동일



<H3>CSS3 배경</H3>

---

- background-size
- background-origin
- background-clip



<h4>background-size</h4>

- 배경 이미지의 크기를 설정
- 문법 =>  background-size: **너비** **높이** contain|cover ;
  - contain으로 설정 시, 이미지의 비율은 유지하면서 크기를 가능한 한 크게 조절
  - cover로 설정 시, 이미지의 비율은 무시하면서 요소의 모든 영역을 가리도록 크기를 조절



<h4>background-origin</h4>

- 배경 이미지의 위치를 결정
  - border-box : 배경 이미지를 테두리 영역의 왼쪽 위에 맞춘다
  - padding-box : 기본 설정이며, 배경 이미지를 패딩 영역의 왼쪽 위에 맞춘다
  - content-box : 배경 이미지를 내용 영역의 왼쪽 위에 맞춘다



<h4>background-clip</h4>

- 해당 요소의 배경을 어느 영역까지 설정할지를 결정
- origin과 같은 속성 but, border-box가 기본 설정



<H3>CSS3 테두리</H3>

---

- border-radius 속성

- ```html
  <style>
  		#p_01 {
  			height: 100px;
  			width: 200px;
  			background: #87CEFA;
  			padding: 20px; 
  			border-top-left-radius: 20px;
  			border-top-right-radius: 40px;
  			border-bottom-right-radius: 60px;
  			border-bottom-left-radius: 80px;
  		}
      
      	서로 다른 크기의 둥근 모서리 설정 가능
  </style>
  ```

- border-image 속성

- ```html
  <style>
      #p_01 {
          border: solid 20px transparent;
          -webkit-border-image: url(/examples/images/img_css3_pattern.png) 34 round;
          -moz-border-image: url(/examples/images/img_css3_pattern.png) 34 round;
          -o-border-image: url(/examples/images/img_css3_pattern.png) 34 round;
          border-image: url(/examples/images/img_css3_pattern.png) 34 round;
      }
      
      테이블 중간처리를 반복으로 설정
  </style>
  ```

- ```html
  <style>
      #p_01 {
          border: solid 20px transparent;
          -webkit-border-image: url(/examples/images/img_css3_pattern.png) 34% stretch;
          -moz-border-image: url(/examples/images/img_css3_pattern.png) 34% stretch;
          -o-border-image: url(/examples/images/img_css3_pattern.png) 34% stretch;
          border-image: url(/examples/images/img_css3_pattern.png) 34% stretch;
      }
  
      stretch를 사용하여 중간 부분의 처리를 늘리는 것으로 설정한 예제
  </style>
  ```

- ```html
  <style>
      #p_01 {
          border: solid 20px transparent;
          -webkit-border-image: url(/examples/images/img_css3_pattern.png) 34 round stretch;
          -moz-border-image: url(/examples/images/img_css3_pattern.png) 34 round stretch;
          -o-border-image: url(/examples/images/img_css3_pattern.png) 34 round stretch;
          border-image: url(/examples/images/img_css3_pattern.png) 34 round stretch;
      }
      
      수평은 반복, 수직은 늘리기로 처리
  </style>
  ```



<H3>CSS3 텍스트</H3>

---

- text-overflow

  - 콘텐츠 영역을 벗어난 텍스트를 어떻게 표현할지를 설정

  - text-overflow : clip -> 잘라냄

  - text-overflow : ellipsis -> 생략 부호를 사용

  - ```html
    <style>
        #p_01:hover, #p_02:hover { overflow: visible; }
    
        overflow값을 visible로 설정하면 생략된 텍스트까지 보여줄 수 있음
    </style>
    ```

    

- word-wrap

  - 콘텐츠 영역을 벗어난 길이가 긴 단어를 다음 줄에 나누어 표현
  - word-wrap : break-word

  

- word-break

  - 긴 단어를 나누어 표현해야 할 때 단어가 나뉘는 기준을 설정

  - ```html
    <style>
    		p {
    			border: 1px solid black;
    			width: 130px;
    		}
    		#p_02 { word-wrap: break-word; }
    		#p_03 { word-break: break-all; }
    		#p_04 { word-break: keep-all; }
    </style>
    ```