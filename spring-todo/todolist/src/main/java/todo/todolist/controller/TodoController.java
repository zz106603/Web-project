package todo.todolist.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todo.todolist.domain.TodoDTO;
import todo.todolist.service.TodoService;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(value = "todo/write.do")
    public String openTodoWrite(@RequestParam(value = "idx", required = false) Long idx, Model model){

        //신규 입력
        if(idx == null){
            model.addAttribute("todo", new TodoDTO());
        }
        //기존 수정
        else{
            TodoDTO todoDTO = todoService.getTodoDetail(idx);
            if(todoDTO == null){
                return "redirect:/todo/list.do";
            }
            model.addAttribute("todo", todoDTO);
        }

        return "todo/write";
    }

    @PostMapping(value = "todo/register.do")
    public String register(final TodoDTO todoDTO){

        try {
            boolean isRegistered = todoService.registerTodo(todoDTO);
            if (isRegistered == false) {
                System.out.println("실패");
                //실패
            }
        }catch (DataAccessException e){
            System.out.println("db문제");
        }catch (Exception e){
            System.out.println("시스템문제");
        }
        return "redirect:/todo/list.do";
    }

    @GetMapping(value = "todo/list.do")
    public String openTodoList(Model model){

        List<TodoDTO> list = todoService.getTodoList();
        model.addAttribute("list", list);

        return "todo/list";
    }

}
