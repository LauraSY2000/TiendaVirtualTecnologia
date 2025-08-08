package com.tienda.controller;

import com.tienda.model.Imagen;
import com.tienda.repository.ImagenRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/imagenes")
public class ImagenController {

    @Autowired
    private ImagenRepository imagenRepository;

    @PostMapping("/cargar")
    public String cargarDesdeCSV() {
        List<Imagen> imagenes = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/imagenes.csv"))) {
            String[] linea;
            reader.readNext(); // saltar cabecera

            while ((linea = reader.readNext()) != null) {
                Imagen img = new Imagen();
                img.setProductoId(Long.parseLong(linea[0]));
                img.setDireccion(linea[1]);
                img.setAltText(linea[2]);
                img.setOrden(Integer.parseInt(linea[3]));
                imagenes.add(img);
            }

            imagenRepository.saveAll(imagenes);
            return "Imágenes cargadas correctamente: " + imagenes.size();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al cargar imágenes: " + e.getMessage();
        }
    }
}
