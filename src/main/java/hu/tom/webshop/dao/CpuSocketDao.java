package hu.tom.webshop.dao;

import hu.tom.webshop.domain.CpuSocket;
import hu.tom.webshop.domain.CpuVendor;

import javax.persistence.Query;
import java.util.List;

public class CpuSocketDao extends BaseDao<CpuSocket> {

    public CpuSocketDao() {
        super(CpuSocket.class);
    }

    public List<CpuSocket> findAllCpuSockets() {
        Query query = currentSession.createQuery("SELECT s FROM CpuSocket s");
        return query.getResultList();
    }

    public List<CpuSocket> findAllCpuSocketsBelongToSpecificVendor(CpuVendor vendor) {
        Query query = currentSession.createQuery("SELECT s FROM CpuVendor v JOIN v.cpuSockets s WHERE s.cpuVendor=:cpuVendor");
        query.setParameter("cpuVendor" , vendor);
        List<CpuSocket> cpuSockets=query.getResultList();
        return cpuSockets;
    }
}
