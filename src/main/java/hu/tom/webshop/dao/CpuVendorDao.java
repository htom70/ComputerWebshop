package hu.tom.webshop.dao;

import hu.tom.webshop.domain.CpuVendor;
import hu.tom.webshop.domain.Processor;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CpuVendorDao extends BaseDao<CpuVendor> {

    public CpuVendorDao() {
        super(CpuVendor.class);
    }

    public CpuVendor findCpuVendorByName(String name) {
        Query query = currentSession.createQuery("SELECT c FROM CpuVendor c where c.name=:name");
        query.setParameter("name", name);
        CpuVendor cpuVendor = (CpuVendor) query.getSingleResult();
        return cpuVendor;
    }

    public List<CpuVendor> findAllCpuVendors() {
        List<CpuVendor> result = new ArrayList<>();
        Query query = currentSession.createQuery("SELECT c FROM CpuVendor c");
        return query.getResultList();
    }
}
