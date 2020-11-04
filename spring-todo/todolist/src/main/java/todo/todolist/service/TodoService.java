package todo.todolist.service;

import todo.todolist.domain.TodoDTO;

import java.util.List;

public interface TodoService {

    //insert, update
    public boolean registerTodo(TodoDTO todoDTO);
    public boolean deleteTodo(Long idx);
    public TodoDTO getTodoDetail(Long idx);
    public List<TodoDTO> getTodoList();
}
