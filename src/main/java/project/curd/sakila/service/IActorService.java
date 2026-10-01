package project.curd.sakila.service;

import project.curd.sakila.model.*;

import java.util.List;

public interface IActorService {

    public BaseHttpResponseModel getAllActors();
    public BaseHttpResponseModel getActorById(Integer actorId);
    public BaseHttpResponseModel addActor(ActorRequestModel request);
    public BaseHttpResponseModel deleteActorById(Integer actorId);

}
