package edu.cibertec.rueditas_backend.service;

import edu.cibertec.rueditas_backend.dto.request.RueditaRequestDTO;

import java.util.List;

public interface RueditaService {
    List<String> findByPlaca (RueditaRequestDTO requestDTO);
}
