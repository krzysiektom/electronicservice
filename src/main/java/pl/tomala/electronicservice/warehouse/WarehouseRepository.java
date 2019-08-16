package pl.tomala.electronicservice.warehouse;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomala.electronicservice.State;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    List<Warehouse> findAllByState(State state);
}