package edu.cibertec.rueditas_backend.controller;

import edu.cibertec.rueditas_backend.dto.request.RueditaRequestDTO;
import edu.cibertec.rueditas_backend.dto.response.RueditaResponseDTO;
import edu.cibertec.rueditas_backend.service.RueditaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/search")
public class RueditaController {

    @Autowired
    private RueditaService rueditaService;

    @PostMapping("")
    public ResponseEntity<RueditaResponseDTO> findByPlaca (@RequestBody RueditaRequestDTO requestDTO){
        try{
            List<String> datos = rueditaService.findByPlaca(requestDTO);
            if(datos == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            RueditaResponseDTO responseDTO = new RueditaResponseDTO(
                    datos.get(0),
                    datos.get(1),
                    Integer.parseInt(datos.get(2)),
                    BigDecimal.valueOf(Double.parseDouble(datos.get(3))),
                    datos.get(4)
            );
            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

}
