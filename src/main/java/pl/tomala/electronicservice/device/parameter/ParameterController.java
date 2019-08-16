package pl.tomala.electronicservice.device.parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("devices/parameters")
public class ParameterController {
    @Autowired
    ParameterRepository parameterRepository;

    @Autowired
    ParameterService parameterService;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "parameters";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        return Arrays.toString(parameterRepository.findAll().toArray());
    }

    @RequestMapping("/add/{parameterName}/{parametersList}")
    @ResponseBody
    public String add(@PathVariable("parameterName") String parameterName, @PathVariable("parametersList") List<String> parametersList) {
        return parameterService.add(parameterName, parametersList).toString();
    }

}
