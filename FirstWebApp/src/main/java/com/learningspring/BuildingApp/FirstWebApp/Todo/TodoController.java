package com.learningspring.BuildingApp.FirstWebApp.Todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("names")
public class TodoController {

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private TodoService todoService;

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername(model); // Removed Hardcoding
        List<Todo> todos = todoService.findByUsername(username);
        model.addAttribute("todos", todos);

        return "listTodos";
    }



    @RequestMapping(value = "add-todos", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = getLoggedInUsername(model); // getting username from Loggedin username function
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "Todo";
    }

    @RequestMapping(value = "add-todos", method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "Todo";
        }

        String username = getLoggedInUsername(model);
        todoService.addTodo(username, todo.getDescription(), todo.getTarget(), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {

        // Delete todo with this ID

        todoService.deleteByID(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "Todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String UpdateTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "Todo";
        }

        String username = getLoggedInUsername(model);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }


    // Getting the username fromSpring Security instead of getting from user input/hardcoding
    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

    //    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
//    public String updateByID(ModelMap model){
//        String username = (String)model.get("name");
//        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false  );
//        model.put("todo", todo);
//        return "Todo";
//    }
//
//    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
//    public String showUpdateTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
//        if (result.hasErrors()) {
//            return "Todo";
//        }
//        String username = (String)model.get("name");
//        todoService.addTodo(username,todo.getDescription(), LocalDate.now().plusYears(1),false);
//        return "redirect:list-todos";
//    }


    /*

//        String username = getLoggedInUsername(model);
//        todo.setUsername(username);
//        todoService.updateTodo(todo);
      //  return "redirect:list-todos";

//    private String getLoggedInUsername(ModelMap model) {
//        Authentication authentication =
//                SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//    }

}
*/