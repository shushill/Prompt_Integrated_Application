package sushil.knitai.project.service;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClientRequest;
import sushil.knitai.project.payload.PostDto;
import sushil.knitai.project.payload.PostResponseDto;

import java.time.Duration;

@Service
public class ProjectService {


    private final WebClient webClient;

    public ProjectService(){
        this.webClient = WebClient.builder()
                .baseUrl("https://api.getknit.ai/")
                .build();
    }

    public PostResponseDto fetchDataFromAPI(PostDto postDto) {
        PostResponseDto response = webClient.post()
                .uri("/v1/router/run")
                .header("x-auth-token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiMTA0NzE3NzU0Mjk1MDU4NjExMzA5In0sImlhdCI6MTcwNjg3MDg4MCwiZXhwIjoxNzA3OTUwODgwfQ.N1snByQz4fehOEDHIZyV9wt2w7IL4bHrXraKsdl9TGY")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(postDto))
                .httpRequest(httpRequest -> {
                    HttpClientRequest reactorRequest = httpRequest.getNativeRequest();
                    reactorRequest.responseTimeout(Duration.ofSeconds(20));
                })
                .retrieve()
                .bodyToMono(PostResponseDto.class)
                .block();


        return response;
    }

}

