package me.dio.academia.digital.service.PlanoService;

import me.dio.academia.digital.dto.PlanoDTO.PlanoRequestDTO;
import me.dio.academia.digital.dto.PlanoDTO.PlanoResponseDTO;
import me.dio.academia.digital.entity.Plano;
import me.dio.academia.digital.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoServiceImpl {

    @Autowired
    private PlanoRepository planoRepository;

    public PlanoResponseDTO create(PlanoRequestDTO dto) {
        Plano plano = new Plano();
        plano.setDescricao(dto.descricao());
        plano.setValor(dto.valor());
        plano.setDuracaoDePlano(dto.duracaoDePlano());

        Plano salvo = planoRepository.save(plano);

        return new PlanoResponseDTO(
                salvo.getId(),
                salvo.getDescricao(),
                salvo.getValor(),
                salvo.getDuracaoDePlano()
        );
    }
}
