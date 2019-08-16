package pl.tomala.electronicservice.device.parameter.paramName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping("devices/parameters/params")
public class ParamNameController {
    @Autowired
    ParamNameRepository paramNameRepository;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "params";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        return Arrays.toString(paramNameRepository.findAll().toArray());
    }

}
