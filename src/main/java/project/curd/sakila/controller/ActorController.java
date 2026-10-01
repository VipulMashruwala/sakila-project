package project.curd.sakila.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.curd.sakila.model.*;
import project.curd.sakila.service.Implementation.ActorService;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/sakila")
public class ActorController {

    private final ActorService actorService;

    @GetMapping("/show-actors")
    public ResponseEntity<BaseHttpResponseModel> getAllActors(){
        try{
            BaseHttpResponseModel response = actorService.getAllActors();
            return ResponseEntity.ok(response);
        }
        catch (Exception ex){
            log.error("Exception occurred while fetching actor details", ex);
            throw ex;
        }
    }

    @GetMapping("/show-actor/{actorId}")
    public ResponseEntity<BaseHttpResponseModel> getActorById(@PathVariable Integer actorId){
        BaseHttpResponseModel response =  actorService.getActorById(actorId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create-actor")
    public ResponseEntity<BaseHttpResponseModel> addActor(@Valid @RequestBody ActorRequestModel request){
        try{
            BaseHttpResponseModel response =  actorService.addActor(request);
            return ResponseEntity.ok(response);
        }
        catch(Exception ex){
            log.error("Exception occurred while creating actor", ex);
            throw ex;
        }
    }

    @DeleteMapping("/delete-actor/{actorId}")
    public ResponseEntity<BaseHttpResponseModel> deleteActorById(@PathVariable Integer actorId){
        BaseHttpResponseModel response = actorService.deleteActorById(actorId);
        return ResponseEntity.ok(response);
    }
}
