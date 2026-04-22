package me.dio.academia.digital.controller;

import jakarta.validation.Valid;
import me.dio.academia.digital.dto.AlunoDTO.AlunoResponseDTO;
import me.dio.academia.digital.dto.MatriculaDTO.MatriculaRequestDTO;
import me.dio.academia.digital.dto.MatriculaDTO.MatriculaResponseDTO;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.service.MatriculaService.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public ResponseEntity<MatriculaResponseDTO> create(@Valid @RequestBody MatriculaRequestDTO dto) {
        MatriculaResponseDTO response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MatriculaResponseDTO>> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        List<MatriculaResponseDTO> matriculas = service.getAll(bairro);
        return ResponseEntity.ok(matriculas);
    }
}
