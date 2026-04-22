package me.dio.academia.digital.dto.AlunoDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record AlunoUpdateDTO(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 50)
        String nome,

        @NotBlank(message = "O bairro é obrigatório")
        String bairro,

        @NotNull(message = "A data de nascimento é obrigatória")
        @Past(message = "A data deve ser no passado")
        LocalDate dataDeNascimento
) {
}
