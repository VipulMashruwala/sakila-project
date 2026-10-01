package project.curd.sakila.exceptions;

public class ActorNotFoundException extends RuntimeException{

    public ActorNotFoundException(String message){
        super(message);
    }
}
