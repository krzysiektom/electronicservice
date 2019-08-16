package pl.tomala.electronicservice.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tomala.electronicservice.warehouse.WarehouseRepository;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    public List<Comment> all() {
        return commentRepository.findAll();
    }

    public List<Comment> allBy(Long warehouseId) {
        return commentRepository.findAllByWarehouse(warehouseRepository.getOne(warehouseId));
    }

    public Comment add(Long warehouseId, String text) {
        Comment comment = new Comment();
        comment.setWarehouse(warehouseRepository.getOne(warehouseId));
        comment.setComment(text);
        commentRepository.save(comment);
        return comment;
    }

}
