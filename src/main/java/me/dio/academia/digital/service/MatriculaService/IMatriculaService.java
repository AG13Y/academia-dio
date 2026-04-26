package me.dio.academia.digital.service.MatriculaService;

import me.dio.academia.digital.dto.MatriculaDTO.AcessoResponseDTO;
import me.dio.academia.digital.dto.MatriculaDTO.MatriculaRequestDTO;
import me.dio.academia.digital.dto.MatriculaDTO.MatriculaResponseDTO;
import me.dio.academia.digital.entity.Matricula;

import java.util.List;

public interface IMatriculaService {

    MatriculaResponseDTO create(MatriculaRequestDTO dto);

    List<MatriculaResponseDTO> getAll(String bairro);

    List<MatriculaResponseDTO> getMatriculasAtivas();

    AcessoResponseDTO verificarAcesso(Long alunoId);

    void delete(Long id);
}
