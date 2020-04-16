package hu.tom.webshop.dao;

import hu.tom.webshop.domain.CpuFamily;
import hu.tom.webshop.domain.CpuSocket;
import hu.tom.webshop.domain.CpuVgaType;

import javax.persistence.Query;
import java.util.List;

public class CpuVgaTypeDao extends BaseDao<CpuVgaType> {

    public CpuVgaTypeDao() {
        super(CpuVgaType.class);
    }

    public List<CpuVgaType> findAllCpuVgaTypessBelongToSpecificFamily(CpuFamily cpuFamily) {
        Query query = currentSession.createQuery("SELECT t FROM CpuVendor v JOIN v.cpuSockets s JOIN s.cpuFamilies f JOIN f.cpuVgaTypes t WHERE t.cpuFamily=:cpuFamily");
        query.setParameter("cpuFamily", cpuFamily);
        List<CpuVgaType> cpuVgaTypes = query.getResultList();
        return cpuVgaTypes;
    }
}
