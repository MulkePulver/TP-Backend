package culturemedia.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record Video(@NotNull String code, @Size(min=3) String title, String description, Double duration){

}