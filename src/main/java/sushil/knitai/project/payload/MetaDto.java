package sushil.knitai.project.payload;

import lombok.Data;

@Data
public class MetaDto {
     private int promptTokens;
     private int completionTokens;
     private int totalTokens;
     private int statusCode;
     private double timeTaken;
     private double cost;
}
