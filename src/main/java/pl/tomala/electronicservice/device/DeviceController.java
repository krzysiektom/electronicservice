package pl.tomala.electronicservice.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("devices")
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    DeviceService deviceService;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "devices";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        return Arrays.toString(deviceRepository.findAll().toArray());
    }

    @RequestMapping("/add/{categoryName}/{parametersList}/{valuesList}")
    @ResponseBody
    public String add(@PathVariable("categoryName") String categoryName, @PathVariable("parametersList") List<Long> parametersList, @PathVariable("valuesList") List<Long> valuesList) {
        return deviceService.add(categoryName, parametersList, valuesList).toString();
    }

}
