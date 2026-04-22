package me.dio.academia.digital.service.MatriculaService;

import me.dio.academia.digital.dto.MatriculaDTO.MatriculaRequestDTO;
import me.dio.academia.digital.dto.MatriculaDTO.MatriculaResponseDTO;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.Plano;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService{
    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public MatriculaResponseDTO create(MatriculaRequestDTO dto) {

        Aluno aluno = alunoRepository.findById(dto.alunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + dto.alunoId()));

        Plano plano = planoRepository.findById(dto.planoId())
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setPlano(plano);

        LocalDateTime dataInicio = LocalDateTime.now();
        LocalDateTime dataFim = dataInicio.plusMonths(plano.getDuracaoDePlano());

        matricula.setDataDaMatricula(dataInicio);
        matricula.setDataVencimento(dataFim);
        Matricula salvo = matriculaRepository.save(matricula);

        return new MatriculaResponseDTO(
                salvo.getId(),
                salvo.getAluno().getNome(),
                salvo.getAluno().getCpf(),
                salvo.getDataDaMatricula(),
                salvo.getDataVencimento()
        );
    }

    @Override
    public List<MatriculaResponseDTO> getAll(String bairro) {
        List<Matricula> matriculas;

        if (bairro == null) {
            matriculas = matriculaRepository.findAll();
        } else {
            matriculas = matriculaRepository.findByAlunoBairro(bairro);
        }

        // Convertendo a lista de Entity para ResponseDTO
        return matriculas.stream()
                .map(m -> new MatriculaResponseDTO(
                        m.getId(),
                        m.getAluno().getNome(),
                        m.getAluno().getCpf(),
                        m.getDataDaMatricula(),
                        m.getDataVencimento()
                ))
                .toList();
    }

    @Override
    public void delete(Long id) {
        // 1. Verifica se a matrícula existe
        if (!matriculaRepository.existsById(id)) {
            throw new RuntimeException("Matrícula não encontrada com o ID: " + id);
        }

        // 2. Deleta o registro
        matriculaRepository.deleteById(id);
    }
    // Implementar os outros métodos conforme necessário...
}
