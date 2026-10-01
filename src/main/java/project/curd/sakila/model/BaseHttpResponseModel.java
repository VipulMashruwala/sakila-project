package project.curd.sakila.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseHttpResponseModel {

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("response")
    private Object response;
}
