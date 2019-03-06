package sstoynov.exodia.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sstoynov.exodia.domain.models.binding.UserRegisterBindingModel;
import sstoynov.exodia.domain.models.service.UserServiceModel;
import sstoynov.exodia.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public ModelAndView modelAndView(ModelAndView modelAndView){
        modelAndView.setViewName("register");

        return modelAndView;
    }
    @PostMapping("/register")
    public ModelAndView registerConfirm(@ModelAttribute UserRegisterBindingModel model, ModelAndView modelAndView){
        if (!model.getPassword().equals(model.getConfirmPassword())){
            throw new IllegalArgumentException("Passwords don`t match!");
        }

        if (!this.userService.registerUser(this.modelMapper.map(model, UserServiceModel.class))){
            throw new IllegalArgumentException("User registration failed!");
        }

        modelAndView.setViewName("redirect:/login");

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");

        return modelAndView;
    }
}

