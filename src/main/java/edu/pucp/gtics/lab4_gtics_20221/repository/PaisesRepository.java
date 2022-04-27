package edu.pucp.gtics.lab4_gtics_20221.repository;

import edu.pucp.gtics.lab4_gtics_20221.entity.Paises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PaisesRepository extends JpaRepository<Paises,Integer> {
}
