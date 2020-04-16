package hu.tom.webshop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CpuSocket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String cpuSocketType;

    @ManyToOne
    private CpuVendor cpuVendor;

    @OneToMany(mappedBy = "cpuSocket")
    private Set<Processor> processors = new HashSet<>();

    @OneToMany(mappedBy = "cpuSocket")
    private Set<CpuFamily> cpuFamilies = new HashSet<>();

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

    public CpuVendor getCpuVendor() {
        return cpuVendor;
    }

    public void setCpuVendor(CpuVendor cpuVendor) {
        this.cpuVendor = cpuVendor;
    }
}
