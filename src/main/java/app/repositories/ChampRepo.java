package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.Champ;

public interface ChampRepo extends JpaRepository<Champ, Long>{

}
