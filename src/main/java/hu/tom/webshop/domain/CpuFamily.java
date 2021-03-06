package hu.tom.webshop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CpuFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @ManyToOne
    private CpuSocket cpuSocket;

    @OneToMany(mappedBy = "cpuFamily")
    private Set<Processor> processors = new HashSet<>();

    @OneToMany(mappedBy = "cpuFamily")
    private Set<CpuVgaType> cpuVgaTypes=new HashSet<>();

    public CpuFamily(String name) {
        this.name = name;
    }

    public CpuFamily() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CpuSocket getCpuSocket() {
        return cpuSocket;
    }

    public void setCpuSocket(CpuSocket cpuSocket) {
        this.cpuSocket = cpuSocket;
    }
}
