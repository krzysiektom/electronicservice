package pl.tomala.electronicservice.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tomala.electronicservice.Category;
import pl.tomala.electronicservice.device.parameter.Parameter;
import pl.tomala.electronicservice.device.parameter.ParameterRepository;
import pl.tomala.electronicservice.device.parameter.paramName.ParamName;
import pl.tomala.electronicservice.device.parameter.paramName.ParamNameRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    ParameterRepository parameterRepository;

    @Autowired
    ParamNameRepository paramNameRepository;

    public Device add(String categoryName, List<Long> parametersList, List<Long> valuesList) {
        Device device = new Device();
        device.setCategory(Category.valueOf(categoryName));
        List<Parameter> parameters = new ArrayList<>();
        for (Long parameterId : parametersList) {
            parameters.add(parameterRepository.getOne(parameterId));
        }
        device.setParameters(parameters);
        List<ParamName> values = new ArrayList<>();
        for (Long paramNameId : valuesList) {
            values.add(paramNameRepository.getOne(paramNameId));
        }
        device.setValues(values);
        deviceRepository.save(device);
        return device;
    }
}
