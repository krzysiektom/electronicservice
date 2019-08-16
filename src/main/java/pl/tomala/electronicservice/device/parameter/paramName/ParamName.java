package pl.tomala.electronicservice.device.parameter.paramName;

import pl.tomala.electronicservice.device.parameter.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "params")
public class ParamName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Parameter parameter;

    public ParamName() {
    }

    public ParamName(String name, Parameter parameter) {
        this.name = name;
        this.parameter = parameter;
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

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "ParamName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
