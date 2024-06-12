package bg.softuni.mobilele.web;

import bg.softuni.mobilele.data.dto.RegisterUserDTO;
import bg.softuni.mobilele.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @Valid @ModelAttribute ("registerUserDTO")
    public RegisterUserDTO registerUserDTO() {
        return new RegisterUserDTO();
    }


    @GetMapping("/register")
    public String getRegisterPage() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid RegisterUserDTO registerUserDTO, BindingResult bindingResult, RedirectAttributes rAtt) {
        //Validation and error handling
        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("registerUserDTO", registerUserDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.registerUserDTO", bindingResult);
            return "redirect:/users/register";
        }

        //service -> register user (and validate)
        userService.registerUser(registerUserDTO);

        //redirect
        return "redirect:/";
    }
}
