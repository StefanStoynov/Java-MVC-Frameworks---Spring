package realestate.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import realestate.domain.models.binding.OfferRegisterBindingModel;

@Controller
public class OfferController {

    @GetMapping("/reg")
    public String register(){
        return "register.html";
    }

    @PostMapping("/reg")
    public String registerConfirm(@ModelAttribute(name = "model")OfferRegisterBindingModel model){
        return null;
    }
}
