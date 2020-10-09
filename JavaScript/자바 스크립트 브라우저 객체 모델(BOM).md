<h1>브라우저 객체 모델(DOM)</h1>

- 브라우저의 정보에 접근하거나 브라우저의 여러 기능들을 제어



<h3>Windows 객체</h3>

---

- 브라우저 창 크기 조절

  - ```html
    <script>
    		var windowWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
    		var windowHeight = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
    
    		document.write("웹 브라우저의 너비는 " + windowWidth + "픽셀이고, 높이는 " + windowHeight + "픽셀입니다.");
    	</script>
    
    windows.  : 생략가능
    ```

- 브라우저 새 창 열기

  - ```html
    <button onclick="openWindow()">새로운 창 열기</button>
    
    	<script>
    		var newWindowObj;
    		// 변수 strWindowFeatures를 통해 새롭게 여는 웹 브라우저 창의 옵션들을 일일이 설정할 수 있음.
    		var strWindowFeatures = "menubar = yes,location = yes,resizable = yes,scrollbars = yes,status = yes";
    		function openWindow() {
    			newWindowObj = window.open("/html/intro", "HTML 개요", strWindowFeatures);
    		}
    	</script>
    
    
    ```

- 브라우저 창 닫기

  - ```html
    function openWindow() {
        newWindowObj = window.open("/html/intro", "HTML 개요", strWindowFeatures);
    }
    function closeNewWindow() { // 새롭게 연 브라우저 창을 window 객체를 이용하여 다시 닫을 수 있음.
        newWindowObj.close();
    }
    ```



<h3>Location 객체</h3>

---

- 현재 브라우저에 표시된 HTML 문서의 주소를 얻거나, 브라우저에 새 문서를 불러올 때 사용

- 현재 문서의 URL 주소

  - ```html
    document.write("현재 문서의 주소는 " + location.href + "입니다.");
    ```

- 현재 문서의 호스트 이름

  - ```html
    document.write("현재 문서의 호스트 이름은 " + location.hostname + "입니다.");
    ```

- 현재 문서의 파일 경로명

  - ```html
    document.write("현재 문서의 파일 경로명은 " + location.pathname + "입니다.");
    ```

- 현재 창에 문서 불러오기

  - ```html
    function openDocument() {
        location.assign("/index.php");	
    }
    function openDocumentWithReplace() {
        location.replace("/index.php");	// 새 문서를 불러오기 전에, 현재 문서를 브라우저의 히스토리에서 제거
    }
    ```



<h3>History 객체</h3>

---

- 브라우저의 히스토리 정보를 문서와 문서 상태 목록으로 저장하는 객체

- 사용자의 개인 정보를 보호하기 위해 이 객체에 접근하는 방법을 일부 제한

- 히스토리 목록의 개수

  - ```html
    function openDocument() {
        location.assign("/javascript/js_bom_history");
    }
    document.getElementById("text").innerHTML =
    "현재 브라우저의 히스토리 목록의 개수는 " + history.length + "개 입니다.";
    ```

- 히스토리 목록 접근하기

  - ```html
    이전 페이지로 가기
    
    <button onclick="goBack()">이전 페이지로 가기</button>
    ...
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
    ```

  - ```html
    이전 페이지로 가기(go)
    
    <button onclick="go()">이전 페이지로 가기</button>
    ...
    <script>
        function go() {
            window.history.go(-1);
        }
    </script>
    ```

  - ```html
    다음 페이지로 가기
    
    <button onclick="goForward()">다음 페이지로 가기</button>
    ...
    <script>
        function goForward() {
            window.history.forward();
        }
    </script>
    ```



<h3>Screen 객체</h3>

---

- 사용자의 디스플레이 화면에 대한 다양한 정보를 저장하는 객체

- 사용자의 화면 크기

  - ```html
    document.write("현재 사용자의 디스플레이 화면의 너비는 " + screen.width + "픽셀입니다.<br>");
    document.write("현재 사용자의 디스플레이 화면의 높이는 " + screen.height + "픽셀입니다.<br>");
    
    document.write("현재 브라우저 창의 너비는 " + window.outerWidth + "픽셀입니다.<br>");
    document.write("현재 브라우저 창의 높이는 " + window.outerHeight + "픽셀입니다.<br>");
    ```

- 실제 사용할 수 있는 화면 크기

  - ```html
    document.write("실제 사용할 수 있는 화면의 너비는 " + screen.availWidth + "픽셀입니다.<br>");
    document.write("실제 사용할 수 있는 화면의 높이는 " + screen.availHeight + "픽셀입니다.");
    ```

- 한 색상당 사용할 수 있는 비트수

  - ```html
    var bitColorDepth = screen.colorDepth;
    document.write("사용자 화면에서 한 색상당 사용할 수 있는 비트수는 " + bitColorDepth + "개입니다.<br>");
    document.write("즉, 한 색상은 총 " + Math.pow(2, bitColorDepth) + "가지로 표현됩니다.");
    ```

- 화면 픽셀당 표시할 수 있는 비트수

  - ```html
    var bitPixelDepth = screen.pixelDepth;
    document.write("사용자 화면의 한 픽셀당 표시할 수 있는 비트수는 " + bitPixelDepth + "개입니다.<br>");
    ```



<h3>Navigator 객체</h3>

---

- 브라우저 공급자 및 버전 정보 등을 포함한 브라우저에 대한 다양한 정보를 저장하는 객체

- 브라우저 스니핑

  - 웹 브라우저의 종류를 미리 파악하여 조치함으로써, 브라우저 간의 호환성을 유지

- 현재 브라우저의 이름

  - ```html
    document.write("현재 사용 중인 브라우저의 이름은 " + navigator.appName + "입니다.<br>");
    document.write("또한, 해당 브라우저의 코드명은 " + navigator.appCodeName + "입니다.");
    ```

- 현재 브라우저의 버전 (웹 표준에서 제외)

  - ```html
    document.write("현재 사용 중인 브라우저의 버전 정보는 " + navigator.appVersion + "입니다.<br><br>");
    document.write("userAgent 프로퍼티로 알 수 있는 추가 정보는 " + navigator.userAgent + "입니다.");
    ```

- 현재 브라우저가 실행되고 있는 운영체제

  - ```html
    document.write("현재 브라우저가 실행되고 있는 운영체제는 " + navigator.platform + "입니다.");
    ```

- 현재 브라우저의 기본 언어 설정

  - ```html
    document.write("현재 브라우저의 기본 언어 설정은 " + navigator.language + "입니다.");
    ```

- 자바 애플릿 실행 여부(비표준 메소드 javaEnabled())

  - ```html
    document.write("현재 브라우저는 자바 애플릿를 ");
    if (navigator.javaEnabled()) {
        document.write("실행할 수 있습니다.");
    } else {
        document.write("실행할 수 없습니다.");
    }
    ```

- 쿠키 사용 여부(비표준 프로퍼티)

  - ```html
    document.write("현재 브라우저는 쿠키를 ");
    if (navigator.cookieEnabled) {
        document.write("사용할 수 있습니다.");
    } else {
        document.write("사용할 수 없습니다.");
    }
    ```



<h3>대화 상자</h3>

---

- alert() : 간단한 메시지를 보여주고, 사용자의 확인을 기다림

  - ```html
    function alertDialogBox() {
        alert("확인을 누를 때까지 다른 작업을 할 수 없어요!");
    }
    ```

- confirm() : 간단한 메시지를 보여주고, 확인이나 취소를 누르면 불리언 값으로 반환

  - ```html
    function confirmDialogBox() {
        var str;
        if (confirm("확인이나 취소를 눌러주세요!") == true) {
            str = "당신은 확인을 눌렀습니다!";
        } else {
            str = "당신은 취소을 눌렀습니다!";
        }
        document.getElementById("text").innerHTML = str;
    }
    ```

- prompt() : 간단한 메시지를 보여주고, 사용자가 입력한 문자열을 반환

  - ```html
    function promptDialogBox() {
        var inputStr = prompt("당신의 이름을 입력해 주세요 : ", "홍길동");
        if (inputStr != null) {
            document.getElementById("text").innerHTML = "당신의 이름은 " + inputStr + "입니다.";
        }
    }
    ```



<h3>타이머</h3>

---

- setTimeout() : 명시된 시간이 지난 뒤에 지정된 함수를 호출

  - ```html
    function startTimeout() {
    	setTimeout(printCurrentDate, 2000);
    }
    function printCurrentDate() {
        document.getElementById("date").innerHTML = new Date();
    }
    ```

- setInterval() : 지정된 시간 간격마다 반복적으로 호출

  - ```html
    function startInterval() {
        setInterval(printCurrentDate, 2000);
    }
    function printCurrentDate() {
        document.getElementById("date").innerHTML += new Date() + "<br>";
    }
    ```

- clearTimeout() : 함수의 호출을 취소

  - ```html
    var timeoutId;
    function startTimeout() {
        timeoutId = setTimeout(printCurrentDate, 2000);
    }
    function cancelTimeout() {
        clearTimeout(timeoutId);
    }
    function printCurrentDate() {
        document.getElementById("date").innerHTML += new Date() + "<br>";
    }
    ```

- clearInterval() : 반복되는 함수의 호출 취소

  - ```html
    var timeoutId;
    function startInterval() {
        timeoutId = setInterval(printCurrentDate, 2000);
    }
    function cancelInterval() {
        clearInterval(timeoutId);
    }
    function printCurrentDate() {
        document.getElementById("date").innerHTML += new Date() + "<br>";
    }
    ```

    