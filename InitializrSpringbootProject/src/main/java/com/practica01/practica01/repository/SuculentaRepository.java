package com.practica01.practica01.repository;

import com.practica01.practica01.domain.Suculenta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SuculentaRepository extends JpaRepository<Suculenta, Integer> {
   
//Consulta nombre de suculenta 
    public List<Suculenta> findAllByOrderByNombreComunAsc();
    
    //Consulta nombre de familia, misma funcion que categoria 
    public List<Suculenta> findByFamiliaOrderByNombreComunAsc(String familia);

     @Query("SELECT DISTINCT s.familia FROM Suculenta s ORDER BY s.familia")
    public List<String> findFamilias();
}
