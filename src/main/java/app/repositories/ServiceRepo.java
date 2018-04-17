package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.Service;

public interface ServiceRepo extends JpaRepository<Service, Long>{

}
