package hu.tom.webshop.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CpuVendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String cpuVendorName;

    public CpuVendor(String cpuVendorName) {
        this.cpuVendorName = cpuVendorName;
    }

    public CpuVendor() {
    }

    public String getCpuVendorName() {
        return cpuVendorName;
    }

    public void setCpuVendorName(String cpuVendorName) {
        this.cpuVendorName = cpuVendorName;
    }
}
