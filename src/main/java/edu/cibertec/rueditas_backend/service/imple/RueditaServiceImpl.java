package edu.cibertec.rueditas_backend.service.imple;

import edu.cibertec.rueditas_backend.dto.request.RueditaRequestDTO;
import edu.cibertec.rueditas_backend.service.RueditaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
@Service
public class RueditaServiceImpl implements RueditaService {

    @Autowired
    private ResourceLoader resourceLoader;
    @Override
    public List<String> findByPlaca(RueditaRequestDTO requestDTO) {
        List<String> list = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculo.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while ((linea = reader.readLine()) != null){
                String[] datos = linea.split(";");
                if(requestDTO.placa().equals(datos[0])){
                    list = List.of(datos[1], datos[2], datos[3], datos[4], datos[5]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
