package com.eespindola.ms.post.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Result<T> extends Folio {

    @JsonProperty("isCorrect")
    private Boolean isCorrect;

    @JsonProperty("objects")
    private List<T> objects;

    @JsonProperty("object")
    private T object;

    @JsonPropertyOrder("exception")
    private Exception exception;

    @JsonProperty("message")
    private String message;


}
