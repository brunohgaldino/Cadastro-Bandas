package br.com.projeto.zup2.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBandaRequest {

    @NotBlank
    @JsonProperty(value = "nome")
    private String name;

    @NotBlank
    @JsonProperty(value = "estilo")
    private String style;

    @NotBlank
    @JsonProperty(value = "musica")
    private String song;
}
