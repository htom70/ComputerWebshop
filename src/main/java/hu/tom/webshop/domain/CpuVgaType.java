package hu.tom.webshop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CpuVgaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @ManyToOne
    private CpuFamily cpuFamily;

    @OneToMany(mappedBy = "cpuVgaType")
    private Set<Processor> processors = new HashSet<>();

    public CpuVgaType() {
    }

    public CpuVgaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CpuFamily getCpuFamily() {
        return cpuFamily;
    }

    public void setCpuFamily(CpuFamily cpuFamily) {
        this.cpuFamily = cpuFamily;
    }
}
