package sstoynov.exodia.web.controllers;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sstoynov.exodia.domain.models.binding.DocumentScheduleBindingModel;
import sstoynov.exodia.domain.models.service.DocumentServiceModel;
import sstoynov.exodia.domain.models.view.DocumentDetailsViewModel;
import sstoynov.exodia.service.DocumentService;

import javax.servlet.http.HttpSession;

@Controller
public class DocumentController {

    private final DocumentService documentService;
    private final ModelMapper modelMapper;

    @Autowired
    public DocumentController(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/schedule")
    public ModelAndView schedule(ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("username") == null) {
            modelAndView.setViewName("redirect:/login");
        } else {
            modelAndView.setViewName("schedule");
        }

        return modelAndView;
    }

    @PostMapping("/schedule")
    public ModelAndView scheduleConfirm(@ModelAttribute DocumentScheduleBindingModel model, ModelAndView modelAndView) {
        DocumentServiceModel documentServiceModel = this.documentService.scheduleDocument(this.modelMapper.map(model, DocumentServiceModel.class));

        if (documentServiceModel == null) {
            throw new IllegalIdentifierException("Document creation failed!");
        }
        modelAndView.setViewName("redirect:/details/" + documentServiceModel.getId());

        return modelAndView;
    }

    @GetMapping("details/{id}")
    public ModelAndView details(@PathVariable("id")String id, ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username")==null){
            modelAndView.setViewName("redirect:/login");
        }else{
            DocumentServiceModel documentServiceModel = this.documentService.findDocumentByID(id);

            if (documentServiceModel == null){
                throw new IllegalArgumentException("Document not found!");
            }
            modelAndView.setViewName("details");
            modelAndView.addObject("model", this.modelMapper
                    .map(documentServiceModel, DocumentDetailsViewModel.class));
        }

        return modelAndView;
    }
}
