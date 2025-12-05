package EjercicioPractico2_Fernando_Davila.com.controller;

import EjercicioPractico2_Fernando_Davila.com.domain.User;
import EjercicioPractico2_Fernando_Davila.com.repository.RolRepository;
import EjercicioPractico2_Fernando_Davila.com.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RolRepository rolRepo;

    public UserController(UserService userService, RolRepository rolRepo) {
        this.userService = userService;
        this.rolRepo = rolRepo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("usuarios", userService.findAll());
        return "users/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("usuario", new User());
        model.addAttribute("roles", rolRepo.findAll());
        return "users/form";
    }

    @PostMapping("/save")
    public String save(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", userService.findById(id));
        model.addAttribute("roles", rolRepo.findAll());
        return "users/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", userService.findById(id));
        return "users/detail";
    }
    
    
}

