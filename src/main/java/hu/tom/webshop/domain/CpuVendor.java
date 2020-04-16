package hu.tom.webshop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CpuVendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @OneToMany(mappedBy = "cpuVendor")
    private Set<Processor> processors = new HashSet<>();

    @OneToMany(mappedBy = "cpuVendor")
    private Set<CpuSocket> cpuSockets = new HashSet<>();

    public CpuVendor(String name) {
        this.name = name;
    }

    public CpuVendor() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CpuSocket> getCpuSockets() {
        return cpuSockets;
    }

    public void setCpuSockets(Set<CpuSocket> cpuSocketSet) {
        this.cpuSockets = cpuSocketSet;
    }
}
