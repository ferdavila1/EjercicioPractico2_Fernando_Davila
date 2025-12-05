package EjercicioPractico2_Fernando_Davila.com.controller;

import EjercicioPractico2_Fernando_Davila.com.domain.Rol;
import EjercicioPractico2_Fernando_Davila.com.service.RolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("roles", rolService.findAll());
        return "roles/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("rol", new Rol());
        return "roles/form";
    }

    @PostMapping("/save")
    public String save(Rol rol) {
        rolService.save(rol);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("rol", rolService.findById(id));
        return "roles/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        rolService.delete(id);
        return "redirect:/roles";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("rol", rolService.findById(id));
        return "roles/detail";
    }
}
