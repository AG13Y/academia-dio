package me.dio.academia.digital.dto.MatriculaDTO;

public record AcessoResponseDTO(
        String nomeAluno,
        boolean acessoLiberado,
        String mensagem,
        String dataVencimento
) {
}
