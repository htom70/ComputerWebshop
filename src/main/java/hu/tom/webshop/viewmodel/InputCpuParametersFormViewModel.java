package hu.tom.webshop.viewmodel;

import hu.tom.webshop.business.*;
import hu.tom.webshop.domain.*;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Notification;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import java.util.ArrayList;
import java.util.List;

public class InputCpuParametersFormViewModel {

    private CpuSocketServiceImpl cpuSocketService = new CpuSocketServiceImpl();
    private CpuVendorServiceImpl cpuVendorService = new CpuVendorServiceImpl();
    private CpuFamilyServiceImpl cpuFamilyService = new CpuFamilyServiceImpl();
    private CpuVgaTypesServiceImpl cpuVgaTypesService = new CpuVgaTypesServiceImpl();
    private ProcessorServiceImpl processorService = new ProcessorServiceImpl();

    private String cpuType = "";
    private String cpuVendorName = "";
    private String cpuSocketName = "";
    private String cpuFamilyName = "";
    private String cpuVgaTypeName = "";
    private int numberOfCores = 2;
    private CpuVendor actualCpuVendor;
    private CpuSocket actualCpuSocket;
    private CpuFamily actualCpuFamily;
    private CpuVgaType actualCpuVgaType;
    private List<CpuVendor> cpuVendors = new ArrayList<>();
    private ListModel<CpuSocket> cpuSockets = new ListModelList<>();
    private List<CpuFamily> cpuFamilies = new ArrayList<>();
    private List<CpuVgaType> cpuVgaTypes = new ArrayList<>();
    private boolean newVendorTextboxEnabled;
    private boolean newSocketTextboxEnabled;
    private boolean newFamilyTextboxEnabled;
    private boolean newVgaTypeTextboxEnabled;

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public String getCpuVendorName() {
        return cpuVendorName;
    }

    public void setCpuVendorName(String cpuVendorName) {
        this.cpuVendorName = cpuVendorName;
    }

    public String getCpuSocketName() {
        return cpuSocketName;
    }

    public void setCpuSocketName(String cpuSocketName) {
        this.cpuSocketName = cpuSocketName;
    }

    public List<CpuVendor> getCpuVendors() {
        return cpuVendors;
    }

    public CpuVendor getActualCpuVendor() {
        return actualCpuVendor;
    }

    public void setActualCpuVendor(CpuVendor actualCpuVendor) {
        this.actualCpuVendor = actualCpuVendor;
    }

    public void setCpuVendors(List<CpuVendor> cpuVendors) {
        this.cpuVendors = cpuVendors;
    }

    public boolean isNewVendorTextboxEnabled() {
        return newVendorTextboxEnabled;
    }

    public void setNewVendorTextboxEnabled(boolean newVendorTextboxEnabled) {
        this.newVendorTextboxEnabled = newVendorTextboxEnabled;
    }

    public CpuSocket getActualCpuSocket() {
        return actualCpuSocket;
    }

    public void setActualCpuSocket(CpuSocket actualCpuSocket) {
        this.actualCpuSocket = actualCpuSocket;
    }

    public ListModel<CpuSocket> getCpuSockets() {
        return cpuSockets;
    }

    public void setCpuSockets(ListModel<CpuSocket> cpuSockets) {
        this.cpuSockets = cpuSockets;
    }

    public boolean isNewSocketTextboxEnabled() {
        return newSocketTextboxEnabled;
    }

    public void setNewSocketTextboxEnabled(boolean newSocketTextboxEnabled) {
        this.newSocketTextboxEnabled = newSocketTextboxEnabled;
    }

    public CpuFamily getCpuFamily() {
        return actualCpuFamily;
    }

    public void setCpuFamily(CpuFamily cpuFamily) {
        this.actualCpuFamily = cpuFamily;
    }

    public List<CpuFamily> getCpuFamilies() {
        return cpuFamilies;
    }

    public void setCpuFamilies(List<CpuFamily> cpuFamilies) {
        this.cpuFamilies = cpuFamilies;
    }

    public boolean isNewFamilyTextboxEnabled() {
        return newFamilyTextboxEnabled;
    }

    public void setNewFamilyTextboxEnabled(boolean newFamilyTextboxEnabled) {
        this.newFamilyTextboxEnabled = newFamilyTextboxEnabled;
    }

    public String getCpuFamilyName() {
        return cpuFamilyName;
    }

    public void setCpuFamilyName(String cpuFamilyName) {
        this.cpuFamilyName = cpuFamilyName;
    }

    public CpuFamily getActualCpuFamily() {
        return actualCpuFamily;
    }

    public void setActualCpuFamily(CpuFamily actualCpuFamily) {
        this.actualCpuFamily = actualCpuFamily;
    }

    public String getCpuVgaTypeName() {
        return cpuVgaTypeName;
    }

    public void setCpuVgaTypeName(String cpuVgaTypeName) {
        this.cpuVgaTypeName = cpuVgaTypeName;
    }

    public CpuVgaType getActualCpuVgaType() {
        return actualCpuVgaType;
    }

    public void setActualCpuVgaType(CpuVgaType actualCpuVgaType) {
        this.actualCpuVgaType = actualCpuVgaType;
    }

    public List<CpuVgaType> getCpuVgaTypes() {
        return cpuVgaTypes;
    }

    public void setCpuVgaTypes(List<CpuVgaType> cpuVgaTypes) {
        this.cpuVgaTypes = cpuVgaTypes;
    }

    public boolean isNewVgaTypeTextboxEnabled() {
        return newVgaTypeTextboxEnabled;
    }

    public void setNewVgaTypeTextboxEnabled(boolean newVgaTypeTextboxEnabled) {
        this.newVgaTypeTextboxEnabled = newVgaTypeTextboxEnabled;
    }

    @Init
    public void init() {
        loadCpuVendors();

    }

    @Command
    @NotifyChange("cpuVendor")
    public void savecurrentCpuVendor() {
        cpuVendorService.create(new CpuVendor(cpuVendorName));
        cpuVendorName = "";
    }

    @Command
    @NotifyChange("cpuSocket")
    public void saveCurrentCpuSocket() {
//        CpuVendor cpuVendor = cpuVendorService.findCpuVendorByName(cpuVendorName);
        CpuSocket cpuSocket = new CpuSocket(cpuSocketName);
        cpuSocket.setCpuVendor(actualCpuVendor);
        cpuSocketService.create(cpuSocket);
        actualCpuVendor.getCpuSockets().add(new CpuSocket(cpuSocketName));
        cpuVendorService.update(actualCpuVendor);
    }

    @Command
    @NotifyChange("newVendorTextboxEnabled")
    public void activateNewCpuVendorTextBox() {
        newVendorTextboxEnabled = true;
    }

    @Command
    @NotifyChange({"newVendorTextboxEnabled", "cpuVendorName"})
    public void deactivateNewCpuVendorTextBox() {
        newVendorTextboxEnabled = false;
        cpuVendorName = "";
    }

    @Command
    @NotifyChange({"cpuVendorName", "cpuVendors"})
    public void saveNewCpuVendor() {
        CpuVendor cpuVendor = new CpuVendor(cpuVendorName);
        cpuVendorService.create(cpuVendor);
        loadCpuVendors();
        cpuVendorName = "";
        newVendorTextboxEnabled = false;
    }

    @Command
    @NotifyChange("newSocketTextboxEnabled")
    public void activateNewCpuSocketTextBox() {
        newSocketTextboxEnabled = true;
    }

    @Command
    @NotifyChange({"newSocketTextboxEnabled", "cpuSocketName"})
    public void deactivateNewCpuSocketTextBox() {
        newSocketTextboxEnabled = false;
        cpuSocketName = "";
    }

    @Command
    @NotifyChange({"cpuVendorName", "cpuSockets"})
    public void saveNewCpuSocket() {
        CpuSocket cpuSocket = new CpuSocket(cpuSocketName);
        cpuSocket.setCpuVendor(actualCpuVendor);
        cpuSocketService.create(cpuSocket);
        cpuSocketName = "";
        newSocketTextboxEnabled = false;
        loadCpuSocketsUponVendor();
    }

    @Command
    public void loadCpuSocketsUponVendor() {
        clearActualCpuSocketAndCpuSockets();
        clearActualCpuFamilyAndCpuFamilies();
        clearActualCpuVgaTypeAndCpuVgaTypes();
        cpuSockets = new ListModelList<>(cpuSocketService.findAllCpuSocketsBelongToSpecificVendor(actualCpuVendor));
    }

    @NotifyChange({"cpuSockets"})
    public void clearCpuSockets() {
        actualCpuSocket = null;
        cpuSockets=null;
        BindUtils.postNotifyChange(null,null, this,"actualCpuSocket");
    }

    @Command
    @NotifyChange("newFamilyTextboxEnabled")
    public void activateNewCpuFamilyTextBox() {
        newFamilyTextboxEnabled = true;
    }


    @Command
    @NotifyChange({"newFamilyTextboxEnabled", "cpuFamilyName"})
    public void deactivateNewCpuFamilyTextBox() {
        newFamilyTextboxEnabled = false;
        cpuFamilyName = "";
    }

    @Command
    @NotifyChange({"cpuVendorName", "cpuFamilies"})
    public void saveNewCpuFamily() {
        CpuFamily cpuFamily = new CpuFamily(cpuFamilyName);
        cpuFamily.setCpuSocket(actualCpuSocket);
        cpuFamilyService.create(cpuFamily);
        cpuFamilyName = "";
        newFamilyTextboxEnabled = false;
        loadCpuFamiliesUponSocket();
    }

    @Command
    @NotifyChange("cpuFamilies")
    public void loadCpuFamiliesUponSocket() {
        clearActualCpuFamilyAndCpuFamilies();
        clearActualCpuVgaTypeAndCpuVgaTypes();
        cpuFamilies = cpuFamilyService.findAllCpuFamilysBelongToSpecificSocket(actualCpuSocket);
    }

    @Command
    @NotifyChange("newVgaTypeTextboxEnabled")
    public void activateNewCpuVgaTypeTextBox() {
        newVgaTypeTextboxEnabled = true;
    }

    @Command
    @NotifyChange({"newVgaTypeTextboxEnabled", "cpuVgaTypeName"})
    public void deactivateNewCpuVgaTypeTextBox() {
        newVgaTypeTextboxEnabled = false;
        cpuVgaTypeName = "";
    }

    @Command
    @NotifyChange({"cpuVgaTypeName", "cpuVgaTypes"})
    public void saveNewCpuVgaType() {
        CpuVgaType cpuVgaType = new CpuVgaType(cpuVgaTypeName);
        cpuVgaType.setCpuFamily(actualCpuFamily);
        cpuVgaTypesService.create(cpuVgaType);
        cpuVgaTypeName = "";
        newVgaTypeTextboxEnabled = false;
        loadCpuVgaTypesUponFamily();
    }

    @Command
    @NotifyChange("cpuVgaTypes")
    public void loadCpuVgaTypesUponFamily() {
        clearActualCpuVgaTypeAndCpuVgaTypes();
        cpuVgaTypes = cpuVgaTypesService.findAllCpuVgaTypesBelongToSpecificFamily(actualCpuFamily);
    }

    @Command
    @NotifyChange
    public void saveProcessor() {
        Processor processor = new Processor(cpuType, numberOfCores, actualCpuVendor, actualCpuSocket, actualCpuFamily, actualCpuVgaType);
        processorService.create(processor);
    }

    public void loadCpuVendors() {
        cpuVendors = cpuVendorService.findAllCpuVendors();
    }

    public void loadCpuSockets() {
        cpuSockets = new ListModelList<>(cpuSocketService.findAllCpuSockets());
    }

    private void clearActualCpuSocketAndCpuSockets() {
        actualCpuSocket=null;
        cpuSockets=null;
        BindUtils.postNotifyChange(null,null,this,"actualCpuSocket");
        BindUtils.postNotifyChange(null,null,this,"cpuSockets");
    }

    private void clearActualCpuFamilyAndCpuFamilies() {
        actualCpuFamily=null;
        cpuFamilies=null;
        BindUtils.postNotifyChange(null,null,this,"actualCpuFamily");
        BindUtils.postNotifyChange(null,null,this,"cpuFamilies");
    }

    private void clearActualCpuVgaTypeAndCpuVgaTypes() {
        actualCpuVgaType=null;
        cpuVgaTypes=null;
        BindUtils.postNotifyChange(null,null,this,"actualCpuVgaType");
        BindUtils.postNotifyChange(null,null,this,"cpuVgaTypes");
    }

    @Command
    public void cancel() {
        BindUtils.postGlobalCommand(null, null, "refresh", null);
    }



    @Command
    public void noti() {
        Notification.show("Model changed");
    }
}
