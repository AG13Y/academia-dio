package me.dio.academia.digital.service.AlunoService;

import jakarta.persistence.EntityNotFoundException;
import me.dio.academia.digital.dto.AlunoDTO.AlunoRequestDTO;
import me.dio.academia.digital.dto.AlunoDTO.AlunoResponseDTO;
import me.dio.academia.digital.dto.AlunoDTO.AlunoUpdateDTO;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository repository;

    @Override
    public AlunoResponseDTO create(AlunoRequestDTO dto) {
        // Conversão manual: DTO -> Entity
        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setCpf(dto.cpf());
        aluno.setBairro(dto.bairro());
        aluno.setDataDeNascimento(dto.dataDeNascimento());

        Aluno alunoSalvo = repository.save(aluno);

        // Conversão manual: Entity -> DTO
        return mapToResponse(alunoSalvo);
    }
    private AlunoResponseDTO mapToResponse(Aluno aluno) {
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getBairro(),
                aluno.getDataDeNascimento()
        );
    }

    @Override
    public AlunoResponseDTO get(Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com ID: " + id));

        return mapToResponse(aluno);
    }


    @Override
    public List<AlunoResponseDTO> getAll(String dataDeNascimento) {
        List<Aluno> alunos;

        if (dataDeNascimento == null) {
            alunos = repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento);
            alunos = repository.findByDataDeNascimento(localDate);
        }

        // Convertendo a lista de Entity para ResponseDTO
        return alunos.stream()
                .map(this::mapToResponse) // Reutilizando o método de mapeamento que criamos
                .toList();
    }

    @Override
    public AlunoResponseDTO update(Long id, AlunoUpdateDTO dto) {
        // Procurar o aluno existente ou lançar erro
        Aluno alunoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));

        alunoExistente.setNome(dto.nome());
        alunoExistente.setBairro(dto.bairro());
        alunoExistente.setDataDeNascimento(dto.dataDeNascimento());

        // Salvar (O JPA entende que é um update porque o objeto tem ID)
        Aluno alunoAtualizado = repository.save(alunoExistente);

        return mapToResponse(alunoAtualizado);
    }


    @Override
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }

}
