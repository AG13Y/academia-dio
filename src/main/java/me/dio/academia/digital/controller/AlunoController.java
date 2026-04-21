package me.dio.academia.digital.controller;

import jakarta.validation.Valid;
import me.dio.academia.digital.dto.AlunoDTO.AlunoRequestDTO;
import me.dio.academia.digital.dto.AlunoDTO.AlunoResponseDTO;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.service.AlunoService.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento) {
        List<AlunoResponseDTO> alunos = service.getAll(dataDeNascimento);
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }


    @PostMapping
    public ResponseEntity<AlunoResponseDTO> create(@Valid @RequestBody AlunoRequestDTO dto) {
        AlunoResponseDTO response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }




}
