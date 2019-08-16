package pl.tomala.electronicservice.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping("warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "warehouse";
    }

    @RequestMapping("/add/{deviceId}")
    @ResponseBody
    public String add(@PathVariable("deviceId") Long deviceId) {
        return warehouseService.add(deviceId).toString();
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        return Arrays.toString(warehouseService.all().toArray());
    }

    @RequestMapping("/repair/{id}")
    @ResponseBody
    public String repair(@PathVariable("id") Long id) {
        return warehouseService.repair(id).toString();
    }

    @RequestMapping("/collect/{id}")
    @ResponseBody
    public String collect(@PathVariable("id") Long id) {
        return warehouseService.collect(id).toString();
    }
}
