package sushil.knitai.project.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class MessagesDto {
    @NotEmpty(message = "role should not be null or empty")
    private String role;

    @NotEmpty(message = "content should not be null or empty")
    private String content;

}
