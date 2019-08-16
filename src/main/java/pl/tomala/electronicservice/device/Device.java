package pl.tomala.electronicservice.device;

import pl.tomala.electronicservice.Category;
import pl.tomala.electronicservice.device.parameter.Parameter;
import pl.tomala.electronicservice.device.parameter.paramName.ParamName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Category category;

    @ManyToMany
    private List<Parameter> parameters = new ArrayList<>();

    @ManyToMany
    private List<ParamName> values = new ArrayList<>();


    public Device() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public List<ParamName> getValues() {
        return values;
    }

    public void setValues(List<ParamName> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", category=" + category +
                ", parameters=" + Arrays.toString(parameters.toArray()) +
                ", values=" + Arrays.toString(values.toArray()) +
                '}';
    }
}
