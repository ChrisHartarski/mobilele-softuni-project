package bg.softuni.mobilele.web;

import bg.softuni.mobilele.data.dto.RegisterUserDTO;
import bg.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute ("registerUserDTO")
    public RegisterUserDTO registerUserDTO() {
        return new RegisterUserDTO();
    }


    @GetMapping("/register")
    public String getRegisterPage() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerUser(RegisterUserDTO registerUserDTO) {
        //service -> register user (and validate)
        userService.registerUser(registerUserDTO);

        //redirect
        return "redirect:/";
    }
}
