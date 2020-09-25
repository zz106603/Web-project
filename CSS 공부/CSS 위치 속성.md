<h1>CSS 위치 속성

<h3>디스플레이</h3>

---

<h4>display</h4>

- 블록(block) : 언제나 새로운 라인에서 시작
  - /* <div>, <h1>, <p>, <ul>, <ol>,<form> */
- 인라인(inline) : 새로운 라인에서 시작하지 않음
  - /* <span>,<a>,<img> */
- display 기본 속성값이 블록인 요소 -> 인라인으로 변경 가능


```html
<style>
	li { display: inline; }
</style>
```

- 인라인 블록(inline-bolck)
  - 요소 자체는 inline으로 동작하지만 해당 요소 내부에서는 블록 요소처럼 동작


```html
<style>
	div { width: 100px; height: 50px; }

	.first { background-color: aqua; }
	.second { background-color: green; }
	.third { background-color: yellow; }

	.inline { display: inline; }
	.inline-block { display: inline-block; }
</style>
```

- visiblity 속성
  - HTML 요소가 웹 페이지에 표현될지 아닐지만을 결정
  - visible(해당 요소를 웹 페이지에 나타냄), hidden(웹 페이지에 나타내지 않음), collapse(테두리를 한 줄만)
- HTML 요소 숨기기
  - display 속성값을 none으로 설정

- opacity 속성

  - HTML 요소의 투명도 조절
  - ex) img { opacity : 0.4;  filter : alpha(opacity=40); }

  

<h3>포지션</h3>

---

- 정적 위치 지정 방식
  - div { position : static; } -> top, right, bottom, left 속성값에 영향을 받지 않음
- 상대 위치 지정 방식
  - div.relative { position : relative;  left : 30px; } -> 정적 위치에 따라 위치를 재조정
- 고정 위치 지정 방식
  - div.fixed { position : fixed;  top : 0;  right : 0; } -> viewport를 기준으로 위치를 설정
- 절대 위치 지정 방식
  - div.absolute { position : absolute;  top : 50px;  right : 0; } -> 위치가 설정된 조상 요소를 기준으로 설정



※ 정적 위치를 제외한 나머지 방식은 전부 어떤 기준에 대해 해당 요소의 상대적인 위치를 설정하는 방식

- z-index 속성
  - 겹쳐지는 요소들이 쌓이는 스택의 순서를 결정
  - 크기가 클수록 앞쪽, 작을수록 뒤쪽에 위치



<h3>Float</h3>

---

- float 속성
  - HTML 요소가 주변의 다른 요소들과 **자연스럽게 어울리도록 만들어 줌**
  - img { float: left;  margin-right: 20px; }
- clear 속성
  - float 속성이 적용된 이후 나타나는 요소들의 동작을 조절
  - p { clear: both; }
- overflow 속성
  - auto로 설정 시, 컨테이너 요소의 크기가 자동으로 내부의 요소를 감쌀 수 있을 만큼 커짐


```html
<style>
	div { 
		border: 3px solid #73AD21; 
		padding: 5px;
		}
	img { float: left; }
	.good { overflow: auto; }
</style>

<div class = "good">
	<img src= ~~ >
</div>
```



<h3>정렬</h3>

---

- margin 속성을 이용한 정렬
  - 속성값을 auto로 하면 수평으로 가운데 정렬
- position 속성을 이용한 정렬
  - body요소에 margin과 padding 속성값을 설정하는 것이 좋음
- float 속성을 이용한 좌우 정렬
  - body요소에 margin과 padding 속성값을 설정하는 것이 좋음