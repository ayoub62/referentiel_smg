package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.Table;

public interface TableRepo extends JpaRepository<Table, Long>{

}
