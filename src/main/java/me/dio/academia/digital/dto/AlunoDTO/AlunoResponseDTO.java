package me.dio.academia.digital.dto.AlunoDTO;

import java.time.LocalDate;

public record AlunoResponseDTO(
        Long id,
        String nome,
        String bairro,
        LocalDate dataDeNascimento
) {
}
