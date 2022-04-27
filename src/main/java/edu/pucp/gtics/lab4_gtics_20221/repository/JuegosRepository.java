package edu.pucp.gtics.lab4_gtics_20221.repository;

import edu.pucp.gtics.lab4_gtics_20221.entity.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JuegosRepository extends JpaRepository<Juegos,Integer> {
}
