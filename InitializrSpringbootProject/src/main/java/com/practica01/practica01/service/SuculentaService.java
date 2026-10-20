package com.practica01.practica01.service;

import com.practica01.practica01.domain.Suculenta;
import com.practica01.practica01.repository.SuculentaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SuculentaService {

    // El repositorio es final para asegurar la inmutabilidad
    private final SuculentaRepository suculentaRepository;

    @Transactional(readOnly = true)
    public List<Suculenta> getSuculentas() {
        return suculentaRepository.findAllByOrderByNombreComunAsc();
    }

      @Transactional(readOnly = true)
    public List<String> getFamilias() {
        return suculentaRepository.findFamilias();
    }
    
     @Transactional(readOnly = true)
    public List<Suculenta> getSuculentasPorFamilia(String familia) {
        return suculentaRepository.findByFamiliaOrderByNombreComunAsc(familia);
    }
    
    @Transactional(readOnly = true)
    public Optional<Suculenta> getSuculenta(Integer idSuculenta) {
        return suculentaRepository.findById(idSuculenta);
    }
 
    
    @Transactional
    public void save(Suculenta suculenta) {
        suculentaRepository.save(suculenta);
        log.info("Suculenta guardada: {}", suculenta.getNombreComun());
    }

    @Transactional
    public void delete(Integer idSuculenta) {
        // Verifica si la suculenta existe antes de intentar eliminarla
        if (!suculentaRepository.existsById(idSuculenta)) {
            throw new IllegalArgumentException("La suculenta con ID " + idSuculenta + " no existe.");
        }
        try {
            suculentaRepository.deleteById(idSuculenta);
            suculentaRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("No se puede eliminar la suculenta. Tiene datos asociados.", e);
        }
    }
}
