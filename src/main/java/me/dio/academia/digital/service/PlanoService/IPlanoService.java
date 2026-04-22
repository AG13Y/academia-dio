package me.dio.academia.digital.service.PlanoService;

import me.dio.academia.digital.dto.PlanoDTO.PlanoRequestDTO;
import me.dio.academia.digital.dto.PlanoDTO.PlanoResponseDTO;

public interface IPlanoService {

    PlanoResponseDTO create(PlanoRequestDTO dto);
}
