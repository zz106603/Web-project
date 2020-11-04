package todo.todolist.mapper;

import org.apache.ibatis.annotations.Mapper;
import todo.todolist.domain.TodoDTO;

import java.util.List;

@Mapper
public interface TodoMapper {

    public int insertTodo(TodoDTO todoDTO);
    public int updateTodo(TodoDTO todoDTO);
    public int deleteTodo(Long idx);
    public TodoDTO selectTodoDetail(Long idx);
    public List<TodoDTO> selectTodoList();

    //페이징 처리에 사용
    public int selectTodoTotalCount();

}
