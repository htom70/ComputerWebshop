package hu.tom.webshop.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CpuSocket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String cpuSocketType;

    public CpuSocket(String cpuSocketType) {
        this.cpuSocketType = cpuSocketType;
    }

    public CpuSocket() {
    }

    public String getCpuSocketType() {
        return cpuSocketType;
    }

    public void setCpuSocketType(String cpuSocketType) {
        this.cpuSocketType = cpuSocketType;
    }
}
