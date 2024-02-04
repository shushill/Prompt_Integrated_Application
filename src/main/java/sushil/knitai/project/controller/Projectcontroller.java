package sushil.knitai.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;
import sushil.knitai.project.payload.PostDto;
import sushil.knitai.project.payload.PostResponseDto;
import sushil.knitai.project.service.ProjectService;

import javax.validation.Valid;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/v1/travel")
@Validated
public class Projectcontroller {

    private ProjectService projectService;
    private ModelAndView model = new ModelAndView("index");

    public Projectcontroller(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/frontend")
    public ModelAndView answerData(){
        String d = new String("sushil");

        model.addObject("name", d);
        return model;

    }


    @PostMapping("/frontend")
    public String sendDataToFrontend(@Valid @RequestBody PostDto postDto){

        System.out.println(postDto);
        PostResponseDto dataMono = projectService.fetchDataFromAPI(postDto);

       // String dataMono = "sushil";
        System.out.println(dataMono);

//        ModelAndView model = new ModelAndView("index");
        model.addObject("data", dataMono);

        return "redirect:/api/v1/travel/frontend";

    }


}
