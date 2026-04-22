package me.dio.academia.digital.dto.PlanoDTO;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record PlanoRequestDTO(

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotNull(message = "O valor é obrigatório")
        @Positive(message = "O valor deve ser positivo")
        BigDecimal valor,

        @NotNull(message = "A duração é obrigatória")
        @Min(value = 1, message = "A duração mínima é de 1 mês")
        @Max(value = 12, message = "A duração máxima é de 12 mês")
        Integer duracaoDePlano
) {
}
