package hu.tom.webshop.dao;

import hu.tom.webshop.domain.CpuFamily;
import hu.tom.webshop.domain.CpuSocket;
import hu.tom.webshop.domain.CpuVendor;

import javax.persistence.Query;
import java.util.List;

public class CpuFamilyDao extends BaseDao<CpuFamily> {

    public CpuFamilyDao() {
        super(CpuFamily.class);
    }

    public List<CpuFamily> findAllCpuFamilysBelongToSpecificSocket(CpuSocket socket) {
        Query query = currentSession.createQuery("SELECT f FROM CpuVendor v JOIN v.cpuSockets s JOIN s.cpuFamilies f WHERE f.cpuSocket=:cpuSocket");
        query.setParameter("cpuSocket", socket);
        List<CpuFamily> cpuFamilies = query.getResultList();
        return cpuFamilies;
    }

    public List<CpuFamily> findAllCpuFamilies() {
        Query query = currentSession.createQuery("SELECT f FROM CpuFamily f");
        return query.getResultList();
    }
}
