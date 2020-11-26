# Spring Boot 게시판 만들기



<h2>준비과정</h2>

- <h4>JSP를 대신하여 HTML5 기반 자바 템플릿 엔진인 타임리프(Thymeleaf) 사용</h4>

  - 템플릿 엔진  :  템플릿 양식과 특정 데이터 모델에 따른 입력 자료를 합성하여 결과 문서를 출력하는 소프트웨어(또는 소프트웨어 컴포넌트)
  - ![img](https://blog.kakaocdn.net/dn/cije9g/btqCrPIBemy/HkJf1VtdVOX1zSBHBERJwK/img.png)

- <h4>XML설정을 대신해서 자바 기반의 설정을 사용</h4>

- <h4>MySQL 데이터베이스 사용</h4>

- <h4>Persistence Framework는 마이바티스(MyBatis) 사용</h4>

  - Persistence Framework  :  [데이터](https://ko.wikipedia.org/wiki/데이터)의 저장, **조회, 변경, 삭제**를 다루는 클래스 및 설정 파일들의 집합이다. 퍼시스턴스 프레임워크를 사용하면 [JDBC](https://ko.wikipedia.org/wiki/JDBC) 프로그래밍의 복잡함이나 번거로움 없이 간단한 작업만으로 데이터베이스와 연동되는 시스템을 빠르게 개발할 수 있으며 안정적인 구동도 보장한다.
  - 종류
    -  SQL문장으로 직접 DB데이터를 다루는 SQL 맵퍼
    -  자바 객체를 통해 간접적으로 DB데이터를 다루는 객체 관계 맵퍼(ORM)

- <h4>Maven 대신 Gradle 사용(라이브러리 관리 도구)</h4>

- <h4>Spring Boot 생성 시 추가</h4>

  - Spring Boot DevTools
  - Lombok
  - Spring Configuration Processor
  - Spring Data JPA
  - MyBatis Framework
  - MySQL Driver
  - Thymeleaf
  - Spring Web 



<h2>프로젝트 구조 알아보기</h2>

- ![img](https://blog.kakaocdn.net/dn/t6j5F/btqCxQNynqk/Emejd8VyWtF2zMBk9mdTL0/img.png)

- <h4>MVC 패턴</h4>

  - Model  :  데이터를 처리하는 영역, 흔히 비지니스 로직을 처리하는 영역이라고 이야기 한다. 해당 영역은 데이터베이스와 통신하고 사용자가 원하는 데이터를 가공하는 역할을 함
  - View  :  사용자가 보는 화면을 의미하며, HTML과 타임리프를 사용해서 화면을 처리
  - Controller  :  모델 영역과 뷰 영역의 중간 다리 역할, 사용자가 어떠한 요청을 하면, 가장 먼저 컨트롤러를 경유하고 컨트롤러는 사용자의 요청을 처리할 어떠한 로직을 호출, 호출한 결과를 사용자에게 전달
    - ex) 게시글 작성하고 등록을 요청하면, 
      1. 컨트롤러는 파라미터를 전달받아 유효성을 검증 
      2. 검증이 완료되면 모델 영역에 데이터의 가공 요청
      3. 완료되면 데이터베이스에 데이터를 저장 
      4. 성공, 실패여부 컨트롤러로 전달 
      5. 결과를 뷰로 전달



<h2>데이터베이스 연동</h2>

1. <h4>데이터 소스(DataSource) 설정</h4>

   - @Bean 어노테이션 또는 application.properties 파일 이용 가능( properties 사용 )

   - ```properties
     spring.datasource.hikari.driver-class-name=com.mysql.cj.jdbc.Driver
     // 데이터베이스 주소, board는 스키마 이름
     spring.datasource.hikari.jdbc-url=jdbc:mysql://localhost:3306/board?
     // 한글 등의 기본적인 설정을 처리
     serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false
     spring.datasource.hikari.username=username
     spring.datasource.hikari.password=password
     //커넥션이 정상적으로 맺어졌는지 확인하기 위한 SQL쿼리
     spring.datasource.hikari.connection-test-query=SELECT NOW() FROM dual
     ```

2. <h4>패키지 & 클래스 추가</h4>

   - src/main/java 디렉터리의 com.board 패키지에 configuration 패키지 추가

   - **DBConfiguration 클래스 생성**

   - ```java
     package com.board.configuration;
     
     import javax.sql.DataSource;
     
     import org.apache.ibatis.session.SqlSessionFactory;
     import org.mybatis.spring.SqlSessionFactoryBean;
     import org.mybatis.spring.SqlSessionTemplate;
     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.boot.context.properties.ConfigurationProperties;
     import org.springframework.context.ApplicationContext;
     import org.springframework.context.annotation.Bean;
     import org.springframework.context.annotation.Configuration;
     import org.springframework.context.annotation.PropertySource;
     
     import com.zaxxer.hikari.HikariConfig;
     import com.zaxxer.hikari.HikariDataSource;
     
     // 자바 기반의 설정 파일로 인식
     @Configuration
     // 클래스에서 참조할 properties 파일의 위치 지정
     @PropertySource("classpath:/application.properties")
     public class DBConfiguration {
     
     	@Autowired	//Bean으로 등록된 인스턴스를 객체에 주입하는데 사용
         /*
     	    스프링 컨테이너 : Bean의 생성과 사용, 관계, 주기 등을 관리
     	    ex) 프로젝트에 100개의 클래스가 있으면, 100개의 클래스 간의 의존적인 문제가 많으면 
     	    	"결합도가 높다" 
     	    	-> 이러한 문제를 컨테이너에서 Bean을 주입받는 방법으로 해결 가능
         */
     	private ApplicationContext applicationContext;
     
     	@Bean	//Configuration 클래스의 메서드 레벨에만 지정 가능
         /*
         	@PropertySource에 지정된 파일에서 spring.datasource.hikari로 시작하는 설정을 모두 		읽어 들여 해당 메서드에 매핑
     	    ,클래스 레벨에도 지정 가능
         */
     	@ConfigurationProperties(prefix = "spring.datasource.hikari")
         // 히카리CP 객체 생성 (커넥션 풀 라이브러리)
     	public HikariConfig hikariConfig() {
     		return new HikariConfig();
     	}
     
         /*
         	- 순수 JDBC는 SQL을 실행할 때마다 커넥션을 맺고 끊는 I/O작업을 함.
         	- 이러한 작업은 상단한 리소스를 잡아 먹어 해결책으로 커넥션 풀이 등장.
         	
         	커넥션 풀 : 커넥션 객체를 생성해두고, 데이터베이스에 접근하는 사용자에게 미리 생성해둔 커					 넥션을 제공했다가 다시 돌려받는 방법
         	DataSource : 커넥션 풀을 지원하기 위한 인터페이스
         */
     	@Bean
     	public DataSource dataSource() {
     		return new HikariDataSource(hikariConfig());
     	}
     
         //SqlSessionFactory : 데이터베이스의 커넥션과 SQL 실행에 대한 모든 것을 갖는 중요한 역						  할을 함.
     	@Bean
     	public SqlSessionFactory sqlSessionFactory() throws Exception {
             /* 
             	- MyBatis와 Spring의 연동 모듈,
             	- MyBatis XML Mapper, 설정 파일 위치 등을 지정하고 SqlSessionFactoryBean 
             	  자체가 아닌, getObject 메서드가 리턴하는 SqlSessionFactory를 생성
             */
     		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
     		factoryBean.setDataSource(dataSource());
     //factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/**/*Mapper.xml"));
     		return factoryBean.getObject();
     	}
     
         /*
         	1. SqlSessionTemplate은 마이바티스 스프링 연동 모듈의 핵심
         	2. SqlSessionTemplate은 SqlSession을 구현하고, 코드에서 SqlSession을 대체
         	3. SqlSessionTemplate은 쓰레드에 안전하고 여러 개의 DAO나 Mapper에서 공유 가능
         	4. 필요한 시점에 세션을 닫고, 커밋 또는 롤백하는 것을 포함한 세션의 생명주기 관리
         */
     	@Bean
     	public SqlSessionTemplate sqlSession() throws Exception {
     		return new SqlSessionTemplate(sqlSessionFactory());
     	}
     
     }
     ```

   - 1. @Configuration
     2. PropertySource로 properties파일 불러옴
     3. ApplicationContext를 Autowired
     4. ConfigurationProperties로 "spring.datasource.hikari"로 시작하는 설정 매핑
     5. hikari설정
     6. datasource설정(커넥션 풀 인터페이스)
     7. SqlSessionFactory -> db커넥션과 sql실행의 모든것
     8. SqlSessionTemplate -> 핵심



<h2>CRUD 처리</h2>

1. <h4>게시판 테이블 만들기</h4>

   - ```mysql
     CREATE TABLE tb_board(
     	idx INT NOT NULL AUTO_INCREMENT COMMENT '번호(PK)',
         title VARCHAR(100) NOT NULL COMMENT '제목',
         content VARCHAR(3000) NOT NULL COMMENT '내용',
         writer VARCHAR(20) NOT NULL COMMENT '작성자',
         view_cnt INT NOT NULL DEFAULT 0 COMMENT '조회 수',
         notice_yn ENUM('Y', 'N') NOT NULL DEFAULT 'N' COMMENT '공지글 여부',
         secret_yn ENUM('Y', 'N') NOT NULL DEFAULT 'N' COMMENT '비밀글 여부',
         delete_yn ENUM('Y', 'N') NOT NULL DEFAULT 'N' COMMENT '삭제 여부',
         insert_time DATETIME NOT NULL DEFAULT NOW() COMMENT '등록일',
         update_time DATETIME NULL COMMENT '수정일',
         delete_time DATETIME NULL COMMENT '삭제일',
         PRIMARY KEY(idx)
     )COMMENT '게시판';
     ```

     

2. <h4>도메인 클래스 생성</h4>

   - 게시판 테이블의 구조화 역할을 하는 클래스 생성

   - 4개의 패키지 추가

   - ![img](https://blog.kakaocdn.net/dn/27zPt/btqCBw9CvjV/C0IkZrcX6fJFEysIflGoZ1/img.png)

   - domain 패키지에 BoardDTO 클래스 추가

   - ```java
     package com.board.domain;
     
     import java.time.LocalDateTime;
     
     import lombok.Getter;
     import lombok.Setter;
     
     //Lombok 라이브러리에서 제공해주는 기능
     @Getter
     @Setter
     public class BoardDTO {
     
     	/** 번호 (PK) */
     	private Long idx;
     	/** 제목 */
     	private String title;
     	/** 내용 */
     	private String content;
     	/** 작성자 */
     	private String writer;
     	/** 조회 수 */
     	private int viewCnt;
     	/** 공지 여부 */
     	private String noticeYn;
     	/** 비밀 여부 */
     	private String secretYn;
     	/** 삭제 여부 */
     	private String deleteYn;
     	/** 등록일 */
     	private LocalDateTime insertTime;
     	/** 수정일 */
     	private LocalDateTime updateTime;
     	/** 삭제일 */
     	private LocalDateTime deleteTime;
     }
     ```

   

3. <h4>Mapper 인터페이스 생성</h4>

   - ![img](https://blog.kakaocdn.net/dn/bXWheN/btqCy4GopDJ/RsNBa80ivwC1ug7gO3qFek/img.png)

   - 데이터베이스와 통신 역할을 하는 Mapper 인터페이스를 생성

   - ```java
     package com.board.mapper;
     
     import java.util.List;
     import org.apache.ibatis.annotations.Mapper;
     import com.board.domain.BoardDTO;
     
     @Mapper
     public interface BoardMapper {
     
     	public int insertBoard(BoardDTO params);
     	public BoardDTO selectBoardDetail(Long idx);
     	public int updateBoard(BoardDTO params);
     	public int deleteBoard(Long idx);
     	public List<BoardDTO> selectBoardList();
     	public int selectBoardTotalCount();
     
     }
     ```

   - 기존의 스프링은 DAO클래스에 @Repository를 선언

   -  but, MyBatis는 인터페이스에 @Mapper만 지정해주면 XML Mapper에서 일치하는 SQL문을 찾아 실행

   - SQL 쿼리를 호출하는 것이 전부



4. <h4>MyBatis XML Mapper 생성하기</h4>

   - SQL문 작성

   - ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
     
     <mapper namespace="com.board.mapper.BoardMapper">
     	<sql id="boardColumns">
         	 idx
             ,title
             ,content
             ,writer
             ,view_cnt
             ,notice_yn
             ,secret_yn
             ,delete_yn
             ,insert_time
             ,update_time
             ,delete_time
         </sql>
         
         <insert id="insertBoard" parameterType="BoardDTO">
         	INSERT INTO tb_board(
             	<include refid="boardColumns" />
             )VALUES(
                	 #{idx}
             	,#{title}
             	,#{writer}
             	,0
     	        ,IFNULL(#{noticeYn}, 'N')
                 ,IFNULL(#{secretYn}, 'N')
         	    ,'N'
             	,NOW()
     	        ,NULL
     	        ,NULL    
             )
         </insert>
         
         <select id="selectBoardDetail" parameterType="long" resultType="BoardDTO">
     		SELECT
     			<include refid="boardColumns" />
     		FROM
     			tb_board
     		WHERE
     			delete_yn = 'N'
     		AND
     			idx = #{idx}
     	</select>
         
         <update id="updateBoard" parameterType="BoardDTO">
     		UPDATE tb_board
     		SET
     			  update_time = NOW()
     			, title = #{title}
     			, content = #{content}
     			, writer = #{writer}
     			, notice_yn = IFNULL(#{noticeYn}, 'N')
     			, secret_yn = IFNULL(#{secretYn}, 'N')
     		WHERE
     			idx = #{idx}
     	</update>
         
         <update id="deleteBoard" parameterType="long">
     		UPDATE tb_board
     		SET
     			  delete_yn = 'Y'
     			, delete_time = NOW()
     		WHERE
     			idx = #{idx}
     	</update>
         
         <select id="selectBoardList" parameterType="BoardDTO" resultType="BoardDTO">
     		SELECT
     			<include refid="boardColumns" />
     		FROM
     			tb_board
     		WHERE
     			delete_yn = 'N'
     		ORDER BY
     			notice_yn ASC,
     			idx DESC,
     			insert_time DESC
     	</select>
         
         <select id="selectBoardTotalCount" parameterType="BoardDTO" resultType="int">
     		SELECT
     			COUNT(*)
     		FROM
     			tb_board
     		WHERE
     			delete_yn = 'N'
     	</select>
     </mapper>
     ```

   - XML Mapper의 SQL 조각은 테이블의 컬럼명과 같이 언더바(_)로 연결하는 **스네이크 케이스**를 사용

   - but, 자바에서는 변수의 이름은 소문자로 시작하고, 구분되는 앞 글자만 대문자로 처리하는 **카멜 케이스**를 사용

   - ```properties
     #properties파일에 설정을 추가하여 해결 가능
     #MyBatis
     mybatis.configuration.map-underscore-to-camel-case=true
     ```



5. <h4>DBConfiguration 클래스 처리</h4>

   - properties파일에 MyBatis 설정이 추가되었으니, 해당 설정을 처리할 Bean을 정의

   - ```java
     	@Bean
       	public SqlSessionFactory sqlSessionFactory() throws Exception {
       		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
       		factoryBean.setDataSource(dataSource());
             //getResource 메서드의 인자로 지정된 패턴에 포함하는 XML Mapper를 인식하도록 하는 역할
       		factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/**/*Mapper.xml"));
             /*
             	BoardMapper XML에서 parameterType과 resultType은 클래스의 풀 패키지 경로가 포함되어야 함
             	setTypeAliasesPackage을 사용해서 풀 패키지 경로를 생략 가능
             */
       		factoryBean.setTypeAliasesPackage("com.board.domain");
       		factoryBean.setConfiguration(mybatisConfg());
             
       		return factoryBean.getObject();
       	}
       
       	@Bean
       	//properties파일에서 mybatis.configuration으로 시작하는 모든 설정을 읽어 Bean으로 등록
       	@ConfigurationProperties(prefix = "mybatis.configuration")
       	public org.apache.ibatis.session.Configuration mybatisConfg() {
       		return new org.apache.ibatis.session.Configuration();
       	}
     ```

   

6. <h4>CRUD 테스트</h4>

   - ```java
     package com.board;
     
     import org.junit.jupiter.api.Test;
     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.boot.test.context.SpringBootTest;
     
     import com.board.domain.BoardDTO;
     import com.board.mapper.BoardMapper;
     
     @SpringBootTest
     class MapperTests {
     
     	@Autowired
     	private BoardMapper boardMapper;
     
     	@Test
     	public void testOfInsert() {
     		BoardDTO params = new BoardDTO();
     		params.setTitle("1번 게시글 제목");
     		params.setContent("1번 게시글 내용");
     		params.setWriter("테스터");
     
     		int result = boardMapper.insertBoard(params);
     		System.out.println("결과는 " + result + "입니다.");
     	}
     
         @Test
     	public void testOfSelectDetail() {
     		BoardDTO board = boardMapper.selectBoardDetail((long) 1);
     		try {
     			String boardJson = new ObjectMapper().writeValueAsString(board);
     
     			System.out.println("=========================");
     			System.out.println(boardJson);
     			System.out.println("=========================");
     
     		} catch (JsonProcessingException e) {
     			e.printStackTrace();
     		}
     	}
         
         @Test
     	public void testOfUpdate() {
     		BoardDTO params = new BoardDTO();
     		params.setTitle("1번 게시글 제목을 수정합니다.");
     		params.setContent("1번 게시글 내용을 수정합니다.");
     		params.setWriter("홍길동");
     		params.setIdx((long) 1);
     
     		int result = boardMapper.updateBoard(params);
     		if (result == 1) {
     			BoardDTO board = boardMapper.selectBoardDetail((long) 1);
     			try {
     				String boardJson = new ObjectMapper().writeValueAsString(board);
     
     				System.out.println("=========================");
     				System.out.println(boardJson);
     				System.out.println("=========================");
     
     			} catch (JsonProcessingException e) {
     				e.printStackTrace();
     			}
     		}
     	}
         
         @Test
     	public void testOfDelete() {
     		int result = boardMapper.deleteBoard((long) 1);
     		if (result == 1) {
     			BoardDTO board = boardMapper.selectBoardDetail((long) 1);
     			try {
     				String boardJson = new ObjectMapper().writeValueAsString(board);
     
     				System.out.println("=========================");
     				System.out.println(boardJson);
     				System.out.println("=========================");
     
     			} catch (JsonProcessingException e) {
     				e.printStackTrace();
     			}
     		}
     	}
         
         @Test
     	public void testSelectList() {
     		int boardTotalCount = boardMapper.selectBoardTotalCount();
     		if (boardTotalCount > 0) {
     			List<BoardDTO> boardList = boardMapper.selectBoardList();
     			if (CollectionUtils.isEmpty(boardList) == false) {
     				for (BoardDTO board : boardList) {
     					System.out.println("=========================");
     					System.out.println(board.getTitle());
     					System.out.println(board.getContent());
     					System.out.println(board.getWriter());
     					System.out.println("=========================");
     				}
     			}
     		}
     	}
     }
     ```




<h2>게시글 등록 구현하기</h2>

- Service, View, Controller 영역 처리 



1. <h4>서비스 처리하기</h4>

   - BoardService 인터페이스 

   - ```java
     package com.board.service;
     
     import java.util.List;
     import com.board.domain.BoardDTO;
     
     public interface BoardService {
     
     	public boolean registerBoard(BoardDTO params); //참, 거짓
     	public BoardDTO getBoardDetail(Long idx);
     	public boolean deleteBoard(Long idx); //참, 거짓
     	public List<BoardDTO> getBoardList();
     
     }
     ```

   - BoardServiceImpl 클래스

   - ```java
     package com.board.service;
     
     import java.util.Collections;
     import java.util.List;
     
     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.stereotype.Service;
     
     import com.board.domain.BoardDTO;
     import com.board.mapper.BoardMapper;
     
     @Service
     public class BoardServiceImpl implements BoardSerivice{
         
         @Autowired
         private BoardMapper boardMapper;
         
         @Override
         public boolean registerBoard(BoardDTO params){
             int queryRersult = 0;
             
             if(params.getIdx() == null){
                 queryResult = boardMapper.insertBoard(params);
             }else{
                 queryResult = boardMapper.updateBoard(params);
             }    
             return (queryResult == 1) ? true : false;
         }
         
         @Override
         public BoardDTO getBoardDetail(Long idx){
             return boardMapper.selectBoardDetail(idx);
         }
         
         @Override
         public boolean deleteBoard(Long idx){
             int queryResult = 0;
             
     		BoardDTO board = boardMapper.selectBoardDetail(idx);
             
             if(board != null && board.getDeleteYn().equals("N")){
                 queryResult = boardMapper.deleteBoard(idx);
             }
             return (queryResult == 1) ? true : false;
         }
         
         @Override
         public List<BoardDTO> getBoardList(){
             List<BoardDTO> boardList = Collections.emptyList(); //NPE방지
             
             int boardTotalCount = boardMapper.selectBoardTotalCount();
             if(boardTotalCount > 0){
                 boardList = boardMapper.selectBoardList();
             }
             
             return boardList;
         }
     }
     ```

     

2. <h4>컨트롤러 처리하기</h4>

   - BoardController 생성

   - ```java
     package com.board.controller;
     
     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.stereotype.Controller;
     import org.springframework.ui.Model;
     import org.springframework.web.bind.annotation.GetMapping;
     
     import com.board.service.BoardService;
     
     @Controller
     public class BoardController{
         
         @Autowired
         private BoardService boardService;
         
         @GetMapping(value = "/board/wirte.do")
         public String openBoardWrite(@RequestParam(value = "idx", required = false) Long idx, Model model){
     		if(idx == null){
                 model.addAttribute("board", new BoardDTO());
             }else{
                 BoardDTO board = boardService.getBoardDetail(idx);
                 if(board == null){
                     return "redirect:/board/list.do";
                 }
                 model.addAttribute("board", board);
             }
             return "board/write";
         }
     }
     ```

     

3. <h4>화면 처리하기</h4>

   - 리턴타입으로 지정된 경로에 화면(HTML)을 생성

   - write.html

   - Tymeleaf 사용

   - ```html
     <html>
     <form th:action="@{/board/register.do}" th:object="${board}" method="post" onsubmit="return registerBoard(this)">
         <!-- /*update의 경우 서버로 전달한 게시글 번호(PK) */ -->
         <input type="hidden" th:if="*{idx != null and idx > 0}" th:field="*{idx}" />
         
         <label for="noticeYn">공지글 설정</label>
         <input type="checkbox" th:value="*{noticeYn}" id="noticeYn" name="noticeYn" th:checked="*{String.equals(noticeYn, 
                                                                                                 'Y')}" />
         <label for="secretYn">비밀글 설정</label>
         <input type="checkbox" th:value="*{secretYn}" id="secretYn" name="secretYn" th:checked="*{String.equals(secretYn, 
                                                                                                 'Y')}" />
         <label for="title">제목</label>
         <input type="text" th:field="*{title}" placeholder="제목을 입력해 주세요." />
         
         <label for="writer">작성자</label>
         <input type="text" th:field="*{writer}" placeholder="이름을 입력해 주세요." />
         
         <label for="content">내용</label>
         <textarea th:field="*{content}" placeholder="내용을 입력해 주세요." />
         
         <a href="@{/board/list.do}">뒤로가기</a>
         <button type="submit">저장하기</button>
     </form>
     
     <script th:inline="javascript">
     	/*<![CDATA[*/
         	fucntion registerBoard(form){
                 form.noticeYn.value = form.noticeYn.checked == false ? 'N' : 'Y';
                 form.secretYn.value = form.secretYn.checked == false ? 'N' : 'Y';
                 
                 var result = (
                 					isValid(form.title, "제목", null, null)
                     			&&	isValid(form.writer, "이름", null, null)
                        			&&	isValid(form.content, "내용", null, null)
                 );
                 
                 if(result == false){
                     return false;
                 }
             }
         /*]]>*/
     </script>
     </html>
     ```



4. <h4>등록 컨트롤러 추가</h4>

   - th:action="@{/board/register.do}"에 지정한 메서드 작성

   - ```java
     @PostMapping(value="/board/register.do")
     public String registerBoard(final BoardDTO params){
         try{
             boolean isRegisterd = boardService.registerBoard(params);
             if(isRegisterd == false){
                 //게시글 등록 실패
             }catch(DataAccessException e){
                 //db처리 과정 문제
             }catch(Exception e){
                 //시스템 문제
             }
             
             return "redirect:/board/list.do";
         }
     }
     ```



<h2>게시글 리스트 구현하기</h2>

1. <h4>컨트롤러 추가</h4>

   - ```java
     @GetMapping(value="/board/list.do")
     public String openBoardList(Model model){
         List<BoardDTO> boardList = boardService.getBoardList();
         model.addAttribute("boardList", boardList);
         
         return "board/list";
     }
     ```

     

2. <h4>화면 추가</h4>

   - list.html

   - ```html
     <html>
         <tbody>
             <tr th:if="${not #lists.isEmpty( boardList )}" th:each="row : ${boardList}">
                 <td scope="row" th:text="${#strings.equals( row.noticeYn, 'Y') ? 공지 : row.idx}"></td>
                 <td a th:href="@{/board/view.do( idx = ${row.idx} )}" th:text="${row.title}"></td>
                 <td th:text="${row.writer}"></td>
                 <td th:text="${#calendars.format( row.insertTime, 'yyyy-MM-dd' )}"></td>
                 <td th:text="${row.viewCnt}"></td>
             </tr>
             <tr th:unless="${not #lists.isEmpty( boardList )}">
             	<td colspan="5">조회된 결과가 없습니다.</td>
             </tr>
         </tbody>
         
         
         
     </html>
     ```

   - 