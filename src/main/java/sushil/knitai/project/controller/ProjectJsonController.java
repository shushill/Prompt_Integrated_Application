package sushil.knitai.project.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sushil.knitai.project.payload.PostDto;
import sushil.knitai.project.payload.PostResponseDto;
import sushil.knitai.project.service.ProjectService;

import javax.validation.Valid;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/travel")
@Validated
public class ProjectJsonController {

    private ProjectService projectService;

    public ProjectJsonController(ProjectService projectService){
        this.projectService = projectService;
    }


    @PostMapping("/info")
    public ResponseEntity<PostResponseDto> fetchData(@Valid @RequestBody PostDto postDto){

        PostResponseDto dataMono = projectService.fetchDataFromAPI(postDto);
        return new ResponseEntity<>(dataMono, HttpStatus.CREATED);

    }


//    @GetMapping(value="/square-number")
//    public String streamDataFlux( Model model) {
//
//        List<Integer> l = new ArrayList<>();
//        l.add(1);
//        l.add(2);
//        l.add(3);
//        l.add(4);
//        l.add(5);
//        l.add(6);
//
//      //Flux<Integer> f = Flux.fromIterable(l);
//
//        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
//                new ReactiveDataDriverContextVariable(l, 1);
//
//        model.addAttribute("data", reactiveDataDrivenMode);
//       //model.addAttribute("data", l);
//        return "index";
//    }

}
