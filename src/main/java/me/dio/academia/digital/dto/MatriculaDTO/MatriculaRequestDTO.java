package me.dio.academia.digital.dto.MatriculaDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MatriculaRequestDTO(
        @NotNull(message = "O ID do aluno é obrigatório")
        @Positive(message = "ID do aluno inválido")
        Long alunoId,

        @NotNull(message = "O ID do plano é obrigatório")
        @Positive(message = "ID do plano inválido")
        Long planoId
) {
}
