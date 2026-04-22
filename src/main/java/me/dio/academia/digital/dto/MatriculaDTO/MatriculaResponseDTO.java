package me.dio.academia.digital.dto.MatriculaDTO;

import java.time.LocalDateTime;

public record MatriculaResponseDTO(
        Long id,
        String nomeAluno,
        String cpfAluno,
        LocalDateTime dataDaMatricula,
        LocalDateTime dataVencimento
) {
}
