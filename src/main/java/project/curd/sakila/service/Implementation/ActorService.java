package project.curd.sakila.service.Implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.curd.sakila.entity.Actor;
import project.curd.sakila.exceptions.ActorNotFoundException;
import project.curd.sakila.model.*;
import project.curd.sakila.repository.ActorRepository;
import project.curd.sakila.service.IActorService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ActorService implements IActorService {

    private final ActorRepository actorRepository;

    public BaseHttpResponseModel  getAllActors(){
        BaseHttpResponseModel response = new BaseHttpResponseModel();

        List<Actor> responseEntity = actorRepository.findAll();

        if(!responseEntity.isEmpty()){

            List<ActorResponse> actorResponseList = new ArrayList<>();

            for(Actor actor : responseEntity){

                ActorResponse actorResponse = new ActorResponse();
                actorResponse.setId(actor.getId());
                actorResponse.setFirstName(actor.getFirstName());
                actorResponse.setLastName(actor.getLastName());
                actorResponse.setLastUpdate(actor.getLastUpdate());

                actorResponseList.add(actorResponse);
            }

            response.setStatus("Success");
            response.setMessage("Records fetch successfully");
            response.setResponse(actorResponseList);
        }
        else{
            response.setStatus("Failed");
            response.setErrorMessage("Unable to fetch actor details");
        }

        return response;
    }

    public BaseHttpResponseModel getActorById(Integer actorId){

        Optional<Actor> responseEntity = actorRepository.findActorById(actorId);

        if(responseEntity.isPresent()){
            BaseHttpResponseModel response = new BaseHttpResponseModel();

            ActorResponse actorResponse = new ActorResponse();
            Actor actor = responseEntity.get();

            actorResponse.setId(actor.getId());
            actorResponse.setFirstName(actor.getFirstName());
            actorResponse.setLastName(actor.getLastName());
            actorResponse.setLastUpdate(actor.getLastUpdate());

            response.setStatus("Success");
            response.setMessage("Record fetch successfully");
            response.setResponse(actorResponse);

            return response;
        }
        throw new ActorNotFoundException("Actor not found with id : " + actorId);
    }

    public BaseHttpResponseModel addActor(ActorRequestModel request){
        BaseHttpResponseModel response = new BaseHttpResponseModel();

        Actor requestEntity = new Actor();
        requestEntity.setFirstName(request.getFirstName());
        requestEntity.setLastName(request.getLastName());
        requestEntity.setLastUpdate(LocalDateTime.now().toString());

        Actor responseEntity = actorRepository.save(requestEntity);

        if(responseEntity != null){
            response.setMessage("Actor created successfully");
            response.setStatus("Success");
        }
        else{
            response.setErrorMessage("Unable to create actor");
            response.setStatus("Failed");
        }

        return response;
    }

    public BaseHttpResponseModel deleteActorById(Integer actorId){

        boolean isActorIdPresent = actorRepository.existsById(actorId);

        if(isActorIdPresent){
            BaseHttpResponseModel response = new BaseHttpResponseModel();
            actorRepository.deleteById(actorId);

            response.setStatus("Success");
            response.setMessage("Actor Id " + actorId + " removed successfully.");

            return response;
        }
        throw new ActorNotFoundException("Actor not found with id : " + actorId);
    }
}
