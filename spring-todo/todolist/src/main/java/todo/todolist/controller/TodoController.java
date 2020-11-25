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
import todo.todolist.constant.Method;
import todo.todolist.domain.TodoDTO;
import todo.todolist.service.TodoService;
import todo.todolist.util.UiUtils;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController extends UiUtils{

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /*
    글 작성
     */
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

    /*
    글 등록
     */
    @PostMapping(value = "todo/register.do")
    public String register(final TodoDTO todoDTO, Model model){
        try {
            boolean isRegistered = todoService.registerTodo(todoDTO);
            if (isRegistered == false) {
                return showMessageWithRedirect("게시글 등록에 실패하였습니다.", "/todo/list.do", Method.GET, null, model);
            }
        }catch (DataAccessException e){
            return showMessageWithRedirect("데이터베이스 문제가 발생하였습니다.", "/todo/list.do", Method.GET, null, model);
        }catch (Exception e){
            return showMessageWithRedirect("시스템 문제가 발생하였습니다.", "/todo/list.do", Method.GET, null, model);

        }
        return showMessageWithRedirect("게시글 등록이 완료되었습니다.", "/todo/list.do", Method.GET, null, model);
    }

    /*
    글 목록
     */
    @GetMapping(value = "todo/list.do")
    public String openTodoList(Model model){

        List<TodoDTO> list = todoService.getTodoList();
        model.addAttribute("list", list);

        return "todo/list";
    }

    /*
    글 상세정보
     */
    @GetMapping(value = "todo/view.do")
    public String openTodoDetail(@RequestParam(value = "idx", required = false) Long idx, Model model){
        if(idx == null){
            //올바르지 않은 접근
            return "redirect:/todo/list.do";
        }

        TodoDTO todoDTO = todoService.getTodoDetail(idx);
        if(todoDTO == null || todoDTO.getDeleteYn().equals("Y")){
            //없거나 삭제
            return "redirect:/todo/list.do";
        }
        model.addAttribute("todo", todoDTO);

        return "todo/view";
    }

    /*
    글 삭제
     */
    @PostMapping(value = "todo/delete.do")
    public String deleteTodo(@RequestParam(value = "idx", required = false)Long idx, Model model){
        if(idx == null){
            //올바르지 않은 접근
            return "redirect:/todo/list.do";
        }

        try {
            boolean isDelete = todoService.deleteTodo(idx);
            if(isDelete == false){
                return showMessageWithRedirect("게시글 삭제에 실패하였습니다.", "/todo/list.do", Method.GET, null, model);
            }
        }catch (DataAccessException e){
            return showMessageWithRedirect("데이터베이스 문제가 발생하였습니다.", "/todo/list.do", Method.GET, null, model);
        }catch (Exception e){
            return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/todo/list.do", Method.GET, null, model);
        }

        return showMessageWithRedirect("게시글 삭제가 완료되었습니다.", "/todo/list.do", Method.GET, null, model);
    }

}
