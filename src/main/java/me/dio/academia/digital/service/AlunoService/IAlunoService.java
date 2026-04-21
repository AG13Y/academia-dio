package me.dio.academia.digital.service.AlunoService;

import me.dio.academia.digital.dto.AlunoDTO.AlunoRequestDTO;
import me.dio.academia.digital.dto.AlunoDTO.AlunoResponseDTO;
import me.dio.academia.digital.entity.Aluno;


import java.util.List;

public interface IAlunoService {

  AlunoResponseDTO create(AlunoRequestDTO dto);


  AlunoResponseDTO get(Long id);


  List<AlunoResponseDTO> getAll(String dataDeNascimento);


  Aluno update(Long id, AlunoRequestDTO dto);


  void delete(Long id);

  List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);
}
