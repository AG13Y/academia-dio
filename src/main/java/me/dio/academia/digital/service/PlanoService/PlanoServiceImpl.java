package me.dio.academia.digital.service.PlanoService;

import me.dio.academia.digital.dto.PlanoDTO.PlanoRequestDTO;
import me.dio.academia.digital.dto.PlanoDTO.PlanoResponseDTO;
import me.dio.academia.digital.dto.PlanoDTO.PlanoUpdateDTO;
import me.dio.academia.digital.entity.Plano;
import me.dio.academia.digital.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoServiceImpl implements IPlanoService{

    @Autowired
    private PlanoRepository planoRepository;

    @Override
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

    @Override
    public PlanoResponseDTO update(Long id, PlanoUpdateDTO dto) {
        // 1. Busca o plano ou lança erro
        Plano planoExistente = planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado com ID: " + id));

        planoExistente.setValor(dto.valor());

        Plano atualizado = planoRepository.save(planoExistente);

        return new PlanoResponseDTO(
                atualizado.getId(),
                atualizado.getDescricao(),
                atualizado.getValor(),
                atualizado.getDuracaoDePlano()
        );
    }

    @Override
    public List<PlanoResponseDTO> getAll() {
        // 1. Busca todos os planos do repositório
        List<Plano> planos = planoRepository.findAll();

        // 2. Transforma a lista de Entidades em lista de DTOs
        return planos.stream()
                .map(plano -> new PlanoResponseDTO(
                        plano.getId(),
                        plano.getDescricao(),
                        plano.getValor(),
                        plano.getDuracaoDePlano()
                ))
                .toList(); // Retorna uma lista imutável (Java 17+)
    }
}
