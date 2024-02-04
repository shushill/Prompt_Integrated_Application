package sushil.knitai.project.payload;

import lombok.Data;

@Data
public class PostResponseDto {
    private boolean success;

    private String responseText;
    private MetaDto metadata;
}
