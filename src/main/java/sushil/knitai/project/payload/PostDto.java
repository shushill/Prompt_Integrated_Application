package sushil.knitai.project.payload;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Validated
public class PostDto {
    @Size(min = 1, message = "Messages body must be minimum 1 length")
    @NotEmpty(message = "messages should not be null or empty")
    private List<MessagesDto> messages;
    @NotEmpty(message = "model should not be null or empty")
    private ModelDto model;

    private List<VariablesDto> variables;

}
