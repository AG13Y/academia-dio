package me.dio.academia.digital.controller;

import jakarta.validation.Valid;
import me.dio.academia.digital.dto.PlanoDTO.PlanoRequestDTO;
import me.dio.academia.digital.dto.PlanoDTO.PlanoResponseDTO;
import me.dio.academia.digital.dto.PlanoDTO.PlanoUpdateDTO;
import me.dio.academia.digital.service.PlanoService.PlanoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoServiceImpl service;

    @GetMapping
    public ResponseEntity<List<PlanoResponseDTO>> getAll() {
        List<PlanoResponseDTO> planos = service.getAll();
        return ResponseEntity.ok(planos);
    }

    @PostMapping
    public ResponseEntity<PlanoResponseDTO> create(@Valid @RequestBody PlanoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody PlanoUpdateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
