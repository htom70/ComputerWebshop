package hu.tom.webshop.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CpuFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String cpuFamilyName;

    public CpuFamily(String cpuFamilyName) {
        this.cpuFamilyName = cpuFamilyName;
    }

    public CpuFamily() {
    }

    public String getCpuFamilyName() {
        return cpuFamilyName;
    }

    public void setCpuFamilyName(String cpuFamilyName) {
        this.cpuFamilyName = cpuFamilyName;
    }

}
