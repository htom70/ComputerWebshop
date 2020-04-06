package hu.tom.webshop.viewmodel;

import hu.tom.webshop.domain.*;

public class InputCpuParametersFormViewModel {

    private String currentCpuVendor;
    private String currentCpuSocket;
    private String cpuInnerGpuType;
    private String cpuFamily;
    private String cpuArchitectType;

    public String getCurrentCpuVendor() {
        return currentCpuVendor;
    }

    public void setCurrentCpuVendor(String currentCpuVendor) {
        this.currentCpuVendor = currentCpuVendor;
    }

    public String getCurrentCpuSocket() {
        return currentCpuSocket;
    }

    public void setCurrentCpuSocket(String currentCpuSocket) {
        this.currentCpuSocket = currentCpuSocket;
    }

    public String getCpuInnerGpuType() {
        return cpuInnerGpuType;
    }

    public void setCpuInnerGpuType(String cpuInnerGpuType) {
        this.cpuInnerGpuType = cpuInnerGpuType;
    }

    public String getCpuFamily() {
        return cpuFamily;
    }

    public void setCpuFamily(String cpuFamily) {
        this.cpuFamily = cpuFamily;
    }

    public String getCpuArchitectType() {
        return cpuArchitectType;
    }

    public void setCpuArchitectType(String cpuArchitectType) {
        this.cpuArchitectType = cpuArchitectType;
    }
}
