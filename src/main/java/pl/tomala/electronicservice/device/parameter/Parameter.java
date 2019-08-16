package pl.tomala.electronicservice.device.parameter;

import pl.tomala.electronicservice.device.parameter.paramName.ParamName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "parameters")
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parameter")
    private List<ParamName> parameters = new ArrayList<>();

    public Parameter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParamName> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParamName> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parameters=" + Arrays.toString(parameters.toArray()) +
                '}';
    }
}
