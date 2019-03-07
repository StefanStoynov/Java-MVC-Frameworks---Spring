package sstoynov.exodia.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import sstoynov.exodia.domain.models.view.DocumentHomeViewModel;
import sstoynov.exodia.service.DocumentService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final DocumentService documentService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView modelAndView(ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("username") != null) {
            modelAndView.setViewName("redirect:/home");
        } else {

            modelAndView.setViewName("index");
        }

        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("username") == null) {
            modelAndView.setViewName("redirect:/login");
        } else {
            List<DocumentHomeViewModel> documents = this.documentService.findAllDocuments()
                    .stream()
                    .map( d-> this.modelMapper.map(d, DocumentHomeViewModel.class))
                    .map(d->
                    {
                        if (d.getTitle().length()>12){
                            d.setTitle(d.getTitle().substring(0,11) + "...");
                        }
                        return d;
                    })
                    .collect(Collectors.toList());

            modelAndView.addObject("documents", documents);
            modelAndView.setViewName("home");
        }

        return modelAndView;
    }
}
