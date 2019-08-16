package pl.tomala.electronicservice.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping("comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "comments";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        return Arrays.toString(commentService.all().toArray());
    }

    @RequestMapping("/all/{warehouseId}")
    @ResponseBody
    public String allBy(@PathVariable("warehouseId") Long warehouseId) {
        return Arrays.toString(commentService.allBy(warehouseId).toArray());
    }

    @RequestMapping("/add/{warehouseId}/{text}")
    @ResponseBody
    public String add(@PathVariable("warehouseId") Long warehouseId, @PathVariable("text") String text) {
        return commentService.add(warehouseId, text).toString();
    }

}
