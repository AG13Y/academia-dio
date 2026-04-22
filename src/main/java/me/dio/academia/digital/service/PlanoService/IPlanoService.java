package me.dio.academia.digital.service.PlanoService;

import me.dio.academia.digital.dto.PlanoDTO.PlanoRequestDTO;
import me.dio.academia.digital.dto.PlanoDTO.PlanoResponseDTO;
import me.dio.academia.digital.dto.PlanoDTO.PlanoUpdateDTO;

import java.util.List;

public interface IPlanoService {

    PlanoResponseDTO create(PlanoRequestDTO dto);

    PlanoResponseDTO update(Long id, PlanoUpdateDTO dto);

    List<PlanoResponseDTO> getAll();

}
