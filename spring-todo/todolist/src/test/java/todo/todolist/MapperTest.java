package todo.todolist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import todo.todolist.domain.TodoDTO;
import todo.todolist.mapper.TodoMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@Transactional
public class MapperTest {

    @Autowired
    private TodoMapper todoMapper;

    @Test
    public void testOfInsert(){

        for(int i=1; i<=50; i++) {
            TodoDTO todoDTO = new TodoDTO();
            todoDTO.setTitle(i+"번 게시글 제목");
            todoDTO.setContent(i+"번 게시슬 내용");
            todoDTO.setWriter(i+"번 게시글 작성자");

            int result = todoMapper.insertTodo(todoDTO);
            System.out.println(result);
        }
    }

    @Test
    public void testOfDetail(){
        TodoDTO todoDTO = todoMapper.selectTodoDetail((long)1);
        try {
            String todoJson = new ObjectMapper().writeValueAsString(todoDTO);
            System.out.println("==========");
            System.out.println(todoJson);
            System.out.println("==========");


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testOfUpdate(){

        String title = "1번 수정";
        String content = "1번 내용 수정";
        String writer = "1전 작성자 수정";

        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setIdx((long)1);
        todoDTO.setTitle(title);
        todoDTO.setContent(content);
        todoDTO.setWriter(writer);

        int result = todoMapper.updateTodo(todoDTO);
        if(result == 1) {
            TodoDTO test = todoMapper.selectTodoDetail((long)1);
            try {
                String todoJson = new ObjectMapper().writeValueAsString(test);
                System.out.println("==========");
                System.out.println(todoJson);
                System.out.println("==========");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void testOfDelete(){
        long index = 50;

        int result = todoMapper.deleteTodo(index);
        if(result == 1){
            TodoDTO todoDTO = todoMapper.selectTodoDetail((long)50);
            try {
                String todoJson = new ObjectMapper().writeValueAsString(todoDTO);
                System.out.println("==========");
                System.out.println(todoJson);
                System.out.println("==========");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testOfTodoList(){
        int todoCount = todoMapper.selectTodoTotalCount();
        if(todoCount > 0){
            List<TodoDTO> list = todoMapper.selectTodoList();
            if (list.size() > 0) {
                for(TodoDTO todoDTO : list){
                    System.out.println("==========");
                    System.out.println(todoDTO.getTitle());
                    System.out.println(todoDTO.getContent());
                    System.out.println(todoDTO.getWriter());
                    System.out.println("==========");
                }
            }
        }

    }

}
