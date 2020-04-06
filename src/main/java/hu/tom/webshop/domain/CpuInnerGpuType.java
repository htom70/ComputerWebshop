package hu.tom.webshop.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CpuInnerGpuType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String cpuInnerGpuTypeName;

    public CpuInnerGpuType(String cpuInnerGpuTypeName) {
        this.cpuInnerGpuTypeName = cpuInnerGpuTypeName;
    }

    public CpuInnerGpuType() {
    }

    public String getCpuInnerGpuTypeName() {
        return cpuInnerGpuTypeName;
    }

    public void setCpuInnerGpuTypeName(String cpuInnerGpuTypeName) {
        this.cpuInnerGpuTypeName = cpuInnerGpuTypeName;
    }
}
