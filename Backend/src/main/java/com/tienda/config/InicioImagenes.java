package com.tienda.config;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.tienda.services.CargaImagenService;

@Component
public class InicioImagenes {

    private final CargaImagenService cargaImagenService;

    public InicioImagenes(CargaImagenService cargaImagenService) {
        this.cargaImagenService = cargaImagenService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        cargaImagenService.cargarImagenesDesdeCSV();
    }
}
