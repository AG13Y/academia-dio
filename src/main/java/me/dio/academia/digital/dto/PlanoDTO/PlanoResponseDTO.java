package me.dio.academia.digital.dto.PlanoDTO;

import java.math.BigDecimal;

public record PlanoResponseDTO(
        Long id,
        String descricao,
        BigDecimal valor,
        Integer duracaoDePlano
) {
}
