package com.example.smcrudsb.controller;

import com.example.smcrudsb.entity.User;
import com.example.smcrudsb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Тестовая ручка — возвращает просто "OK", чтобы проверить, работает ли Spring
     */
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "OK";
    }

    /**
     * Главная страница со списком пользователей
     */
    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users"; // src/main/webapp/WEB-INF/views/users.jsp
    }

    /**
     * Редирект со страницы /home на /
     */
    @GetMapping("/home")
    public String redirectToRoot() {
        return "redirect:/";
    }

    /**
     * Добавление нового пользователя
     */
    @PostMapping("/add")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User(name, email);
        userService.saveUser(user);
        return "redirect:/";
    }

    /**
     * Обновление существующего пользователя
     */
    @PostMapping("/update")
    public String updateUser(@RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam String email) {
        User user = new User(name, email);
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/";
    }

    /**
     * Удаление пользователя по ID
     */
    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}