package edu.cibertec.rueditas_backend.dto.response;

import java.math.BigDecimal;

public record RueditaResponseDTO(
        String marca,
        String modelo,
        Integer numeroAsiento,
        BigDecimal precio,
        String color
) {
}
