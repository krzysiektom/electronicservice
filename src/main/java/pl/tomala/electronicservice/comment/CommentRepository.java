package pl.tomala.electronicservice.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomala.electronicservice.warehouse.Warehouse;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByWarehouse(Warehouse warehouse);
}
