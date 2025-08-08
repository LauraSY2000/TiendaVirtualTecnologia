package com.tienda.services;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.tienda.model.Imagen;
import com.tienda.repository.ImagenRepository;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CargaImagenService {
    @Autowired
    private ImagenRepository imagenRepository;

    public void cargarImagenesDesdeCSV() {
        System.out.println(">>> INICIO DE CARGA CSV <<<");
        try {
            CSVReader reader = new CSVReader(
                new InputStreamReader(new ClassPathResource("imagenes.csv").getInputStream())
            );

            List<Imagen> imagenes = new ArrayList<>();
            String[] fila;
            reader.readNext(); // saltar encabezado

            while ((fila = reader.readNext()) != null) {
                Imagen img = new Imagen();
                img.setProductoId(Long.parseLong(fila[0]));
                img.setDireccion(fila[1]);
                img.setAltText(fila[2]);
                img.setOrden(Integer.parseInt(fila[3]));

                imagenes.add(img);
            }

            imagenRepository.saveAll(imagenes);
            System.out.println("Imágenes cargadas correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
