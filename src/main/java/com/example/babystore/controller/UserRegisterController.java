package com.example.babystore.controller;

import com.example.babystore.exception.DuplicationException;
import com.example.babystore.model.dto.UserRegistrationDto;
import com.example.babystore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegisterController {

    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @ModelAttribute("userRegistrationDto")
    public UserRegistrationDto initForm() {
        return new UserRegistrationDto();
    }

//    @PostMapping("/register")
//    public String register(@Valid UserRegistrationDto userRegistrationDto,
//                           BindingResult bindingResult,
//                           RedirectAttributes redirectAttributes) throws DuplicationException {
//
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
//            redirectAttributes.addFlashAttribute(
//                    "org.springframework.validation.BindingResult.userRegistrationDto", bindingResult);
//            return "redirect:/users/register";
//        }
//
//        this.userService.registerAndLogin(userRegistrationDto);
//        return "redirect:/";
//    }

    @PostMapping("/register")
    public String register(UserRegistrationDto userRegistrationDto, Model model) {
        try {
            userService.registerAndLogin(userRegistrationDto);
        } catch (DuplicationException e) {
            model.addAttribute("error", e);
            return "redirect:/400";
        }

        return "redirect:/";
    }
}
