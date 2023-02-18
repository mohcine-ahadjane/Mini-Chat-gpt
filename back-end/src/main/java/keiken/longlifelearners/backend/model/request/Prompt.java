package keiken.longlifelearners.backend.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class Prompt implements Serializable {
    private String message;
}
