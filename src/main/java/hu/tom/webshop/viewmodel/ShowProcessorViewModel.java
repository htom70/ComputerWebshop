package hu.tom.webshop.viewmodel;

import hu.tom.webshop.business.CpuSocketServiceImpl;
import hu.tom.webshop.domain.CpuSocket;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.idom.Item;

import java.util.ArrayList;
import java.util.List;

public class ShowProcessorViewModel {

    CpuSocketServiceImpl cpuSocketService = new CpuSocketServiceImpl();

    private List<CpuSocket> cpuSockets;
    private List<CpuSocket> pickedCpuCpuSockets = new ArrayList<>();

    public List<CpuSocket> getCpuSockets() {
        return cpuSockets;
    }

    public void setCpuSockets(List<CpuSocket> cpuSockets) {
        this.cpuSockets = cpuSockets;
    }

    @Init
    public void init() {
        loadCpuSockets();
    }

    private void loadCpuSockets() {
        cpuSockets = cpuSocketService.findAllCpuSockets();
    }

    @Command
    public void pick(@BindingParam("checked") boolean isPicked, @BindingParam("picked") CpuSocket cpuSocket){
        if (isPicked){
            pickedCpuCpuSockets.add(cpuSocket);
        }else{
            pickedCpuCpuSockets.remove(cpuSocket);
        }
    }

}
