<h1>문서 객체 모델(DOM)</h1>



<h3>DOM</h3>

---

- XML이나 HTML문서에 접근하기 위한 일종의 인터페이스
- 문서 내의 모든 요소를 정의하고, 각각의 요소에 접근하는 방법을 제공
- ![HTML DOM](http://tcpschool.com/lectures/img_js_htmldom.png)
  - 새로운 HTML요소나 속성을 추가할 수 있다.
  - 존재하는 HTML요소나 속성을 제거할 수 있다.
  - HTML문서의 모든 HTML 요소를 변경할 수 있다.
  - HTML문서의 모든 HTML 속성을 변경할 수 있다.
  - HTML문서의 모든 CSS 스타일을 변경할 수 있다.
  - HTML문서에 새로운 HTML 이벤트를 추가할 수 있다.
  - HTML문서의 모든 HTML 이벤트에 반응할 수 있다.
- DOM의 종류
  - Core DOM : 모든 문서 타입을 위한 DOM모델
  - HTML DOM : HTML문서를 위한 DOM모델
  - XML DOM : XML문서를 위한 DOM모델



<h3>Document 객체</h3>

---

- 웹 페이지 그 자체를 의미
- 웹 페이지에 존재하는 HTML 요소에 접근하고자 할 때는 반드시 Document 객체부터 시작해야 한다.
- 메소드
  - HTML 요소의 선택
  - HTML 요소의 생성
  - HTML 이벤트 핸들러 추가
  - HTML 객체의 선택



<h4>HTML 요소의 선택</h4>

- document.getElementsByTagName(태그이름) : 해당 태그 이름의 요소를 모두 선택
- document.getElementsById(아이디) : 해당 아이디의 요소를 선택
- document.getElementsByClassName(클래스이름) : 해당 클래스에 속한 요소를 모두 선택
- document.getElementsByName(name속성값) : 해당 name 속성값을 가지는 요소를 모두 선택
- document.querySelectorAll(선택자) : 해당 선택자로 선택되는 요소를 모두 선택

<h4>HTML 요소의 생성</h4>

- document.createElement(HTML요소) : 지정된 HTML 요소를 생성
- document.write(텍스트) : HTML 출력 스트림을 통해 텍스트를 출력

<h4>HTML 이벤트 핸들러 추가</h4>

- document.getElementsById(아이디).onclick = function() { 실행할 코드 } : 마우스 클릭 이벤트와 연결될 이벤트 핸들러 코드를 추가



<h3>DOM 요소의 선택</h3>

---

- HTML 태그 이름을 이용한 선택

  - ```html
    <ul>
    		<li>첫 번째 아이템이에요!</li>
    		<li>두 번째 아이템이에요!</li>
    		<li>세 번째 아이템이에요!</li>
    		<li>네 번째 아이템이에요!</li>
    		<li>다섯 번째 아이템이에요!</li>
    	</ul>
    
    	<script>
    		var selectedItem = document.getElementsByTagName("li");		// 모든 <li> 요소를 선택함.
    		for (var i = 0; i < selectedItem.length; i++) {
    			selectedItem.item(i).style.color = "red";	// 선택된 모든 요소의 텍스트 색상을 변경함.
    		}
    	</script>
    ```

- 아이디를 이용한 선택

  - ```html
    <ul>
    		<li>첫 번째 아이템이에요!</li>
    		<li id="even">두 번째 아이템이에요!</li>
    		<li>세 번째 아이템이에요!</li>
    		<li id="even">네 번째 아이템이에요!</li>	//여기는 바뀌지 않음. 모든 요소를 바꾸려면 클래스를 사용
    		<li>다섯 번째 아이템이에요!</li>
    	</ul>
    
    	<script>
    		var selectedItem = document.getElementById("even");	// 아이디가 "even"인 요소를 선택함.
    		selectedItem.style.color = "red";					// 선택된 요소의 텍스트 색상을 변경함.
    	</script>
    
    
    ```

- 클래스를 이용한 선택

  - ```html
    	<ul>
    		<li class="odd">첫 번째 아이템이에요!</li>
    		<li>두 번째 아이템이에요!</li>
    		<li class="odd">세 번째 아이템이에요!</li>
    		<li>네 번째 아이템이에요!</li>
    		<li class="odd">다섯 번째 아이템이에요!</li>
    	</ul>
    
    	<script>
    		var selectedItem = document.getElementsByClassName("odd");	// 클래스가 "odd"인 모든 요소를 선택함.
    		for (var i = 0; i < selectedItem.length; i++) {
    			selectedItem.item(i).style.color = "red";			// 선택된 모든 요소의 텍스트 색상을 변경함.
    		}
    	</script>
    ```

- name 속성을 이용한 선택

  - ```html
    <p name="first">첫 번째 단락이에요!</p>
    	<ul>
    		<li name="first">첫 번째 아이템이에요!</li>
    		<li>두 번째 아이템이에요!</li>
    		<li>세 번째 아이템이에요!</li>
    		<li>네 번째 아이템이에요!</li>
    		<li>다섯 번째 아이템이에요!</li>
    	</ul>
    
    	<script>
    		var selectedItem = document.getElementsByName("first");	// name 속성값이 "first"인 모든 요소를 선택함.
    		for (var i = 0; i < selectedItem.length; i++) {
    			selectedItem.item(i).style.color = "red";			// 선택된 모든 요소의 텍스트 색상을 변경함.
    		}
    	</script>
    ```

- CSS 선택자를 이용한 선택

  - ```html
    	<p class="odd">첫 번째 단락이에요!</p>
    	<ul>
    		<li class="odd">첫 번째 아이템이에요!</li>
    		<li>두 번째 아이템이에요!</li>
    		<li class="odd">세 번째 아이템이에요!</li>
    		<li>네 번째 아이템이에요!</li>
    		<li class="odd">다섯 번째 아이템이에요!</li>
    	</ul>
    
    	<script>
    		var selectedItem = document.querySelectorAll("li.odd");	// 클래스가 "odd"인 요소 중에서 <li> 요소만을 선택함.
    		for (var i = 0; i < selectedItem.length; i++) {
    			selectedItem.item(i).style.color = "red";			// 선택된 모든 요소의 텍스트 색상을 변경함.
    		}
    	</script>
    ```

- HTML 객체 집합을 이용한 선택

  - ```html
    <script>
    		var title = document.title;		// <title> 요소를 선택함.
    		document.write(title);
    	</script>
    ```

- DOM 요소의 내용 변경

  - ```html
    var str = document.getElementById("text");
    str.innerHTML = "이 문장으로 바뀌었습니다!";
    
    /////////////////////////////////////////////
    
    var link = document.getElementById("link");          // 아이디가 "link"인 요소를 선택함.
    link.href = "/javascript/intro"; // 해당 요소의 href 속성값을 변경함.
    link.innerHTML = "자바스크립트 수업 바로 가기!";     // 해당 요소의 내용을 변경함.
    ```

- DOM 요소의 스타일 변경

  - ```html
    	<p id="text">이 문자열의 기본색은 검정색입니다!</p>
    	<button onclick="changeRedColor()">빨간색 글자!</button>
    	<button onclick="changeBlackColor()">검정색 글자!</button>
    	
    	<script>
    		var str = document.getElementById("text");	// 아이디가 "str"인 요소를 선택함.
    		function changeRedColor() {
    			str.style.color = "red";				// 해당 요소의 글자색을 빨간색으로 변경함.
    		}
    		function changeBlackColor() {
    			str.style.color = "black";				// 해당 요소의 글자색을 검정색으로 변경함.
    		}
    	</script>
    ```



<h3>노드</h3>

---

- HTML DOM은 노드라고 불리는 계층적 단위에 정보를 저장
- ![HTML Node Tree](http://tcpschool.com/lectures/img_js_htmldom.png)
- 노드의 종류
  - 문서 노드 : HTML 문서 전체를 나타내는 노드
  - 요소 노드 : 모든 HTML 요소는 요소 노드이며, 속성 노드를 가질 수 있는 유일한 노드
  - 속성 노드 : 모든 HTML 요소의 속성은 속성 노드이며, 요소 노드에 관한 정보를 가지고 있음.하지만 해당 요소 노드의 자식 노드에는 포함되지 않음
  - 텍스트 노드 : HTML 문서의 모든 텍스트는 텍스트 노드
  - 주석 노드 : HTML 문서의 모든 주석은 주석 노드
- 노드간의 관계
  - ![Node Relationship](http://tcpschool.com/lectures/img_js_node_relationship.png)
  - 가장 상위에 단 하나의 루트 노드가 존재
  - 루트 노드를 제외한 모든 노드는 단 하나의 부모 노드만을 가진다.
  - 모든 요소 노드는 자식 노드를 가질 수 있다.
  - 형제 노드 : 같은 부모 노드를 가지는 모든 노드
  - 조상 노드 : 부모 노드를 포함해 계층적으로 현재 노드보다 상위에 존재하는 모든 노드
  - 자손 노드 : 자식 노드를 포함해 계층적으로 현재 노드보다 하위에 존재하는 모든 노드



<h4> 노드로의 접근</h4>

- getElementsByTagName() 메소드를 이용하는 방법

- 노드 간의 관계를 이용하여 접근하는 방법

  - parentNode : 부모
  - childNodes : 자식 노드 리스트
  - firstChild : 첫 번째 자식 노드
  - lastChild : 마지막 자식 노드
  - nextSibling : 다음 형제 노드
  - previousSibling : 이전 형제 노드

- 노드에 대한 정보

  - nodeName

  - ```html
    <h1>nodeName 프로퍼티</h1>
    	<p id="document"></p>
    	<p id="html"></p>
    	
    	<script>
    		// HTML 문서의 모든 자식 노드 중에서 두 번째 노드의 이름을 선택함.
    		document.getElementById("document").innerHTML = document.childNodes[1].nodeName;			// HTML
    		
    		// html 노드의 모든 자식 노드 중에서 첫 번째 노드의 이름을 선택함.
    		document.getElementById("html").innerHTML = document.childNodes[1].childNodes[0].nodeName;	// HEAD
    	</script>
    ```

  - nodeValue

  - ```html
    <h1 id="heading">nodeValue 프로퍼티</h1>
    	<p id="text1">텍스트</p>
    	<p id="text2">텍스트</p>
    	
    	<script>
    		// 아이디가 "heading"인 요소의 첫 번째 자식 노드의 노드값을 선택함.
    		var headingText = document.getElementById("heading").firstChild.nodeValue; //nodeValue 프로퍼티
    		
    		document.getElementById("text1").innerHTML = headingText;
    		document.getElementById("text2").firstChild.nodeValue = headingText;
    	</script>
    ```

  - nodeType

  - ```html
    <h1 id="heading">nodeType 프로퍼티</h1>
    	<p id="head"></p>
    	<p id="document"></p>
    	
    	<script>
    		// 아이디가 "heading"인 요소의 첫 번째 자식 노드의 타입을 선택함.
    		var headingType = document.getElementById("heading").firstChild.nodeType;
    		
    		document.getElementById("head").innerHTML = headingType;			// 3
    		document.getElementById("document").innerHTML = document.nodeType;	// 9
    	</script>
    ```

  - 빈 텍스트 노드의 처리

  - ```html
    <h1>빈 텍스트 노드의 처리</h1>
    	<div id="parentNode">
    		<p><span>첫 번째 단락</span> 입니다.</p>
    		<p>두 번째 단락 입니다.</p>
    	</div>
    	<button onclick="printLastChild()">마지막 자식 노드 찾기!</button>
    	<p id="nodename"></p>
    	
    	<script>
    		var lastNode;
    		function findLastChild(parentNode) {
    			lastNode = parentNode.lastChild;
    			while (lastNode.nodeType != 1) {
    				lastNode = lastNode.previousSibling;
    			}
    		}
    		function printLastChild() {
    			var parentNode = document.getElementById("parentNode");
    			findLastChild(parentNode);
    			document.getElementById("nodename").innerHTML = lastNode.nodeName;
    		}
    	</script>
    ```



<h3>노드 리스트</h3>

---

- getElementsByTagName() 메소드나 childNodes 프로퍼티의 값으로 반환되는 객체

- ![Node List](http://tcpschool.com/lectures/img_js_node_list.png)

- ```html
  <ul id="list">
  		<li>첫 번째 아이템이에요!</li> //여기가 바뀜
  		<li>두 번째 아이템이에요!</li>
  		<li>세 번째 아이템이에요!</li>
  	</ul>
  
  	<script>
  		// 아이디가 "list"인 요소의 모든 자식 노드들을 선택함.
  		var listItems = document.getElementById("list").childNodes;
  		// 자식 노드들 중 첫 번째 li 요소의 내용을 변경함.
  		listItems[1].firstChild.nodeValue = "HTML 요소의 내용을 변경했어요!";
  	</script>
  ```

- 여러 노드 사이에 존재하는 텍스트 노드를 확인하는 예제

  - ```html
    <ul id="list">ul 요소 다음의 텍스트
    		<li>첫 번째 아이템이에요!</li>첫 번째 li 요소 다음의 텍스트
    		<li>두 번째 아이템이에요!</li>두 번째 li 요소 다음의 텍스트
    		<li>세 번째 아이템이에요!</li>세 번째 li 요소 다음의 텍스트
    	</ul>
    
    	<script>
    		// 아이디가 "list"인 요소의 모든 자식 노드들을 선택함.
    		var listItems = document.getElementById("list").childNodes;
    		// 자식 노드들 중 첫 번째 노드의 값을 출력함.
    		document.write(listItems[0].nodeValue + "<br>");
    		// 자식 노드들 중 두 번째 노드의 자식 노드 중 첫 번째 노드의 값을 출력함.
    		document.write(listItems[1].firstChild.nodeValue + "<br>");
    		// 자식 노드들 중 세 번째 노드의 값을 출력함.
    		document.write(listItems[2].nodeValue);
    	</script>
    
    //
    ul 요소 다음의 텍스트
    첫 번째 아이템이에요!
    첫 번째 li 요소 다음의 텍스트
    ```

- ```html
  <ul id="list">
  		<li>첫 번째 아이템이에요!</li>
  		<li>두 번째 아이템이에요!</li>
  		<li>세 번째 아이템이에요!</li>
  	</ul>
  	<p id="text"></p>
  	<button onclick="changeTextColor()">글자색 변경!</button>
  
  	<script>
  		var listItems = document.getElementsByTagName("li");	// 모든 <li> 요소들을 선택함.
  		document.getElementById("text").innerHTML = 
  			"이 노드 리스트의 길이는 " + listItems.length + "개 입니다.<br>";	// 모든 자식 노드들의 개수를 반환함.
  			//3
  		function changeTextColor() {
  			for (var i = 0; i < listItems.length; i++) {
  			listItems[i].style.color = "orange";	// 모든 자식 노드들의 글자색을 변경함.
  			}
  		}
  	</script>
  ```

  

<h3>노드의 관리</h3>

---

- appendChild() : 새로운 노드를 해당 노드의 자식 노드 리스트의 맨 마지막에 추가

  - ```html
    <h1>appendChild() 메소드</h1>
    	<h2 id="item">JavaScript</h2>
    	<div id="list">
    		<p>HTML</p>
    		<p>CSS</p>
    		<p>JQuery</p>
    	</div>
    	<button onclick="appendNode()">노드 추가!</button>
    	
    	<script>
    		function appendNode() {
    			var parent = document.getElementById("list");	// 아이디가 "list"인 요소를 선택함.
    			var newItem = document.getElementById("item");	// 아이디가 "item"인 요소를 선택함.
    			parent.appendChild(newItem);					// 해당 요소의 맨 마지막 자식 노드로 추가함.
    		}
    	</script>
    ```

- insertBefore() : 새로운 노드를 특정 자식 노드의 바로 앞에 추가

  - 부모노드.insertBefore(새로운 자식노드, 기준자식노드)

  - ```html
    <h1>insertBefore() 메소드</h1>
    	<h2 id="item">JavaScript</h2>
    	<div id="list">
    		<p>HTML</p>
    		<p id="criteria">CSS</p>
    		<p>JQuery</p>
    	</div>
    	<button onclick="appendNode()">노드 추가!</button>
    	
    	<script>
    		function appendNode() {
    			var parent = document.getElementById("list");			// 아이디가 "list"인 요소를 선택함.
    			var criteriaItem = document.getElementById("criteria");	// 아이디가 "criteria"인 요소를 선택함.
    			var newItem = document.getElementById("item");			// 아이디가 "item"인 요소를 선택함.
    			parent.insertBefore(newItem, criteriaItem);				// 해당 노드를 기준이 되는 자식 노드의 바로 앞에 추가함.
    		}
    	</script>
    ```

- insertData() : 텍스트 노드의 텍스트 데이터에 새로운 텍스트를 추가

  - 텍스트노드.insertData(오프셋, 새로운데이터)

  - ```html
    <h1>insertData() 메소드</h1>
    	<p id="text">지금 시간은 오후 3시입니다.</p>
    	<button onclick="appendText()">텍스트 추가!</button>
    
    	<script>
    		var text = document.getElementById("text").firstChild;	// 아이디가 "text"인 요소의 텍스트 노드를 선택함.
    		function appendText() {
    			text.insertData(6, " 나른한 ");	// 텍스트 노드의 6번째 문자부터 " 나른한 "이란 텍스트를 추가함.
    		}
    	</script>
    ```



<h4>노드의 생성</h4>

- 요소 노드의 생성

  - createElement()

  - ```html
    <h1>요소 노드의 생성</h1>
    	<p id="text">새로운 단락을 생성하여 이 단락 앞에 추가할 것입니다.</p>
    	<button onclick="createNode()">요소 노드 생성!</button>
    
    	<script>
    		function createNode() {
    			var criteriaNode = document.getElementById("text");	// 기준이 되는 요소로 아이디가 "text"인 요소를 선택함.
    			var newNode = document.createElement("p");			// 새로운 <p> 요소를 생성함.
    			newNode.innerHTML = "새로운 단락입니다.";
    			document.body.insertBefore(newNode, criteriaNode);	// 새로운 요소를 기준이 되는 요소 바로 앞에 추가함.
    		}
    	</script>
    ```

- 속성 노드의 생성

  - createAttribute()

  - ```html
    <h1>속성 노드의 생성</h1>
    	<p id="text">이 단락에 새로운 속성을 추가할 것입니다.</p>
    	<button onclick="createNode()">속성 노드 생성!</button>
    
    	<script>
    		function createNode() {
    			var text = document.getElementById("text");				// 아이디가 "text"인 요소를 선택함.
    			var newAttribute = document.createAttribute("style");	// 새로운 style 속성 노드를 생성함.
    			newAttribute.value = "color:red";
    			text.setAttributeNode(newAttribute);					// 해당 요소의 속성 노드로 추가함.
    		}
    	</script>
    ```

- 텍스트 노드의 생성

  - createTextNode()

  - ```html
    <h1>텍스트 노드의 생성</h1>
    	<button onclick="createNode()">텍스트 노드 생성!</button>
    	<p id="text"></p>
    
    	<script>
    		function createNode() {
    			var elementNode = document.getElementById("text");				// 아이디가 "text"인 요소를 선택함.
    			var newText = document.createTextNode("새로운 텍스트에요! ");	// 새로운 텍스트 노드를 생성함.
    			elementNode.appendChild(newText);								// 해당 요소의 자식 노드로 추가함.
    		}
    	</script>
    ```



<h4>노드의 제거</h4>

- removeChild() : 자식 노드 리스트에서 특정 자식 노드를 제거

  - ```html
    <h1>removeChild() 메소드</h1>
    	<button onclick="remove()">요소 노드 삭제!</button>
    	<div id="list">
    		<p>HTML</p>
    		<p id="item">CSS</p>
    		<p>JavaScript</p>
    	</div>
    	
    	<script>
    		function remove() {
    			var parent = document.getElementById("list");		// 아이디가 "list"인 요소를 선택함.
    			var removedItem = document.getElementById("item");	// 아이디가 "item"인 요소를 선택함.
    			parent.removeChild(removedItem);					// 지정된 요소를 삭제함.
    		}
    	</script>
    ```

- removeAttribute() : 특정 속성 노드를 제거

  - ```html
    	<h1>removeAttribute() 메소드</h1>
    	<button onclick="remove()">속성 노드 삭제!</button>
    	<p id="text" style="color:red; background-color:lemonchiffon;">이 단락의 속성이 제거될 것입니다.</p>
    
    	<script>
    		function remove() {
    			var text = document.getElementById("text");		// 아이디가 "text"인 요소를 선택함.
    			text.removeAttribute("style");					// 해당 요소의 "style" 속성을 제거함.
    		}
    	</script>
    ```



<h4>노드의 복제</h4>

- cloneNode()

  - 복제할노드.cloneNode(자식노드복제여부)

  - ```html
    	<h1>cloneNode() 메소드</h1>
    	<button onclick="cloneElement()">노드 복제!</button>
    	<h2 id="item">JavaScript</h2>
    	<div id="list">
    		<p>HTML</p>
    		<p>CSS</p>
    		<p>JQuery</p>
    	</div>
    		
    	<script>
    		function cloneElement() {
    			var parent = document.getElementById("list");			// 아이디가 "list"인 요소를 선택함.
    			var originItem = document.getElementById("item");		// 아이디가 "item"인 요소를 선택함.
    			parent.appendChild(originItem.cloneNode(true));			// 해당 노드를 복제하여 리스트의 맨 마지막에 추가함.
    		}
    	</script>
    ```



<h3>노드의 조작</h3>

---

- 텍스트 노드의 값 변경

  - ```html
    <h1>텍스트 노드의 값 변경</h1>
    	<p id="text">이 텍스트를 변경하고 싶어요!</p>
    	<button onclick="changeText()">텍스트 변경!</button>
    
    	<script>
    		var para = document.getElementById("text");		// 아이디가 "text"인 요소를 선택함.
    		function changeText() {
    			para.firstChild.nodeValue = "텍스트 변경 완료!";
    		}
    	</script>
    ```

- 속성 노드의 값 변경

  - ```html
    <h1>속성 노드의 값 변경</h1>
    	<p>속성 노드의 값을 변경하고 싶어요!</p>
    	<button onclick="changeAttribute()">속성 변경!</button>
    
    	<script>
    		var para;
    		function changeAttribute() {
    			// 모든 <p> 요소중에서 첫 번째 요소에 클래스 속성값으로 "para"를 설정함.
    			document.getElementsByTagName("p")[0].setAttribute("class", "para");
    			// 클래스가 설정되면 해당 클래스에 설정되어 있던 스타일이 자동으로 적용됨.
    		}
    	</script>
    ```

- 요소 노드의 교체

  - 교체할노드 = 부모노드.replaceChild(새로운자식노드, 기존자식노드)

  - ```html
    <h1>요소 노드의 교체</h1>
    	<div id="parent">
    		<p id="first">첫 번째 요소입니다.</p>
    		<p>두 번째 요소입니다.</p>
    	</div>
    	<p id="third">세 번째 요소입니다.</p>
    	<button onclick="changeNode()">요소 노드 교체!</button>
    
    	<script>
    		var parent = document.getElementById("parent");	// 부모 노드를 선택함.
    		var first = document.getElementById("first");
    		var third = document.getElementById("third");
    		function changeNode() {
    			parent.replaceChild(third, first);			// first 요소를 삭제하고, 그 대신 third 요소를 삽입함.
    		}
    	</script>
    ```

- 텍스트 노드의 데이터 교체

  - 텍스트노드.replaceData(오프셋, 교체할문자수, 새로운데이터)

  - ```html
    <h1>텍스트 노드의 데이터 교체</h1>
    	<p id="text">지금 시간은 오후 3시입니다.</p>
    	<button onclick="changeText()">텍스트 교체!</button>
    
    	<script>
    		var text = document.getElementById("text").firstChild;	// 아이디가 "text"인 요소의 텍스트 노드를 선택함.
    		function changeText() {
    			text.replaceData(7, 4, "저녁 7");	// 텍스트 노드의 7번째 문자부터 4개의 문자를 "저녁 7"로 교체함.
    		}
    	</script>
    ```

    