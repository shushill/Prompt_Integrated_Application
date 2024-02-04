package sushil.knitai.project.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class VariablesDto {

    @NotEmpty(message = "name should not be null or empty")
    private String name;

    @NotEmpty(message = "value should not be null or empty")
    private String value;
}
