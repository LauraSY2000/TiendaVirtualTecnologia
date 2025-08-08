package com.tienda.config;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.tienda.services.CargaImagenService;

@Component
public class InicioImagenes {

    @Autowired
    private CargaImagenService cargaImagenService;

    @PostConstruct
    public void init() {
        cargaImagenService.cargarImagenesDesdeCSV();
    }
}