package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Простой тест для проверки Spring
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "OK";
    }

    // Показ всех пользователей на главной странице
    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users"; // имя твоей view, например users.jsp или users.html
    }



    // Переадресация для удобства, если кто-то откроет /home
    @GetMapping("/home")
    public String redirectToRoot() {
        return "redirect:/";
    }

    // Проверка страницы, также возвращает всех пользователей
    @GetMapping("/check")
    public ModelAndView check() {
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("users", userService.getAllUsers());
        return mav;
    }

    // Добавление пользователя
    @PostMapping("/add")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        userService.saveUser(new User(name, email));
        return "redirect:/";
    }

    // Обновление пользователя
    @PostMapping("/update")
    public String updateUser(@RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam String email) {
        User user = new User(name, email);
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/";
    }

    // Удаление пользователя
    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}