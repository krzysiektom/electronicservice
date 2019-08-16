package pl.tomala.electronicservice.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tomala.electronicservice.State;
import pl.tomala.electronicservice.device.DeviceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    DeviceRepository deviceRepository;

    public Warehouse add(Long deviceId) {
        Warehouse warehouse = new Warehouse();
        warehouse.setDevice(deviceRepository.getOne(deviceId));
        warehouseRepository.save(warehouse);
        return warehouse;
    }

    public List<Warehouse> all() {
        List<Warehouse> list = new ArrayList<>();
        for (Warehouse warehouse : warehouseRepository.findAll()) {
            if (warehouse.getState() != State.COLLECTED) {
                list.add(warehouse);
            }
        }
        return list;
    }

    public Warehouse repair(Long id) {
        Warehouse warehouse = warehouseRepository.getOne(id);
        warehouse.setState(State.FUNCTIONAL);
        return warehouse;
    }

    public Warehouse breakDown(Long id) {
        Warehouse warehouse = warehouseRepository.getOne(id);
        warehouse.setState(State.BROKEN);
        return warehouse;
    }

    public Warehouse collect(Long id) {
        Warehouse warehouse = warehouseRepository.getOne(id);
        if (warehouse.getState() == State.FUNCTIONAL) {
            warehouse.setState(State.COLLECTED);
        }
        return warehouse;
    }

}
