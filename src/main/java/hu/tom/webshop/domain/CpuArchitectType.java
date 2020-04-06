package hu.tom.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CpuArchitectType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String cpuArchitectTypeName;

    public CpuArchitectType(String cpuArchitectTypeName) {
        this.cpuArchitectTypeName = cpuArchitectTypeName;
    }

    public CpuArchitectType() {
    }

    public String getCpuArchitectTypeName() {
        return cpuArchitectTypeName;
    }

    public void setCpuArchitectTypeName(String cpuArchitectTypeName) {
        this.cpuArchitectTypeName = cpuArchitectTypeName;
    }
}
