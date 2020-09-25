<h1>CSS 박스 모델

<h3>크기</h3>

---

- 단위
  - %, em, px, cm, mm, inch
    - %  : 기본크기를 100%로 놓고 **상대적**인 크기 설정
    - em : 기본 크기를 1em으로 놓고 **상대적**인 크기 설정
    - px : 스크린의 픽셀을 기준으로 하는 **절대적**인 크기
- 크기
  - height, width : 높이와 너비 (기본값은 auto)
  - max-width : 최대 너비 설정 (기본값은 none[너비 제한x])
  - min-width : 최소 너비 설정
  - max-height, min-height : 최대, 최소 높이 설정

<h3>박스 모델</h3>

---

![css box model](http://tcpschool.com/lectures/img_css_boxmodel.png)

- content : 텍스트나 이미지가 들어있는 박스의 실질적인 내용 부분
- padding : 내용과 테두리 사이의 간격
- border : 내용과 패팅 주변을 감싸는 테두리
- margin : 테두리와 이웃하는 요소 사이의 간격

※ width와  height 속성은 content부분만을 대상



<h4>padding</h4>

- css를 사용하여 패딩 영역의 크기를 방향별로 따로 설정 가능


```html
<style>
	div.pad {
	    padding-top: 50px;
	    padding-right: 10px;
	    padding-bottom: 30px;
	    padding-left: 100px;
}
</style>
```

- top, right, bottom, left 순으로 축약 표현 가능


```html
<style>
	div.four { padding: 20px 50px 30px 50px; } /* top, right, bottom, left */
	div.three { padding: 20px 50px 30px; } /* (top, right),(left, bottom) */
   	div.two { padding: 20px 50px; } /* (top, bottom),(right, left) */
</style>
```



<h4>border</h4>

- dotted : 점선
- dashed : 약간 긴 점선으로 설정
- solid : 실선
- double : 이중 실선
- groove : 3차원인 입체적인 선
- ridge : 3차원인 능선효과가 있는 선
- inset : 3차원인 내지로 끼운 선
- outset : 3차원인 외지로 끼운 선
- none : 없앰
- hidden : 존재하지만 표현되지는 않음
- border-width (두께 설정)
  - 2px
  - 1px 2px 10px
  - thick
  - thin

- border-color (테두리마다 각각의 속성값 설정 가능)
  - border-color : red green blue maroon;

- 개별 설정 가능


  ```html
  <style>
  	.mixA {	
  	    border-top-style: dotted;
  	    border-right-style: double;
  	    border-bottom-style: dotted;
  	    border-left-style: double;
  	}
  	.mixB { border-style: dotted double; }
  </style>
  ```




<h4>margin</h4>

- top, right, bottom, left

  - margin 값을 inherit 으로 설정하면 부모요소의 margin 속성값을 그대로 물려 받음

  

<h4>아웃라인</h4>

- HTML 요소의 전체 크기에 포함되지 않음
- border 속성과 동일