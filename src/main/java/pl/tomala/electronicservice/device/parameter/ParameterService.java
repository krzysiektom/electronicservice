package pl.tomala.electronicservice.device.parameter;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tomala.electronicservice.device.parameter.paramName.ParamName;
import pl.tomala.electronicservice.device.parameter.paramName.ParamNameRepository;

import java.util.List;

@Service
@Transactional
public class ParameterService {
    @Autowired
    ParameterRepository parameterRepository;

    @Autowired
    ParamNameRepository paramNameRepository;

    public Parameter add(String name, List<String> paramsList) {
        Parameter parameter = new Parameter();
        parameter.setName(name);
        parameterRepository.save(parameter);
        for (String paramName : paramsList) {
            paramNameRepository.save(new ParamName(paramName, parameter));
        }
        Hibernate.initialize(parameter.getParameters());
        return parameter;
    }


}
