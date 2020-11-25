package todo.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.todolist.domain.TodoDTO;
import todo.todolist.mapper.TodoMapper;

import java.util.Collections;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    private TodoMapper todoMapper;

    public TodoServiceImpl(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Override
    public boolean registerTodo(TodoDTO todoDTO) {
        int result = 0;

        if(todoDTO.getIdx() == null){
            result = todoMapper.insertTodo(todoDTO);
        }else{
            result = todoMapper.updateTodo(todoDTO);
        }

        return result == 1 ? true : false;
    }

    @Override
    public boolean deleteTodo(Long idx) {
        int result = 0;

        TodoDTO todoDTO = todoMapper.selectTodoDetail(idx);
        if(todoDTO != null && todoDTO.getDeleteYn().equals("N")){
            result = todoMapper.deleteTodo(idx);
        }

        return result == 1 ? true : false;
    }

    @Override
    public TodoDTO getTodoDetail(Long idx) {
        TodoDTO todoDTO = todoMapper.selectTodoDetail(idx);

        return todoDTO;
    }

    @Override
    public List<TodoDTO> getTodoList() {
        List<TodoDTO> list = Collections.emptyList();

        int TodoListCount = todoMapper.selectTodoTotalCount();
        if(TodoListCount > 0){
            list = todoMapper.selectTodoList();
        }

        return list;
    }
}
