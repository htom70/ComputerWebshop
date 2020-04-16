package hu.tom.webshop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String type;

    private int numberOfCores;

    @ManyToOne
    private CpuVendor cpuVendor;

    @ManyToOne
    private CpuSocket cpuSocket;

    @ManyToOne
    private CpuFamily cpuFamily;

    @ManyToOne
    private CpuVgaType cpuVgaType;

    public Processor() {
    }

    public Processor(String type, int numberOfCores, CpuVendor cpuVendor, CpuSocket cpuSocket, CpuFamily cpuFamily, CpuVgaType cpuVgaType) {
        this.type = type;
        this.numberOfCores = numberOfCores;
        this.cpuVendor = cpuVendor;
        this.cpuSocket = cpuSocket;
        this.cpuFamily = cpuFamily;
        this.cpuVgaType = cpuVgaType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public CpuVendor getCpuVendor() {
        return cpuVendor;
    }

    public void setCpuVendor(CpuVendor cpuVendor) {
        this.cpuVendor = cpuVendor;
    }

    public CpuSocket getCpuSocket() {
        return cpuSocket;
    }

    public void setCpuSocket(CpuSocket cpuSocket) {
        this.cpuSocket = cpuSocket;
    }

    public CpuFamily getCpuFamily() {
        return cpuFamily;
    }

    public void setCpuFamily(CpuFamily cpuFamily) {
        this.cpuFamily = cpuFamily;
    }

    public CpuVgaType getCpuVgaType() {
        return cpuVgaType;
    }

    public void setCpuVgaType(CpuVgaType cpuVgaType) {
        this.cpuVgaType = cpuVgaType;
    }
}
