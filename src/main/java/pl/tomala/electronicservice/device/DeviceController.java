package pl.tomala.electronicservice.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.tomala.electronicservice.Category;

@Controller
@RequestMapping("devices")
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepository;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "devices";
    }


}
