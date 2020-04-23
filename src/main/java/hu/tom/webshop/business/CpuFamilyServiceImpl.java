package hu.tom.webshop.business;

import hu.tom.webshop.dao.CpuFamilyDao;
import hu.tom.webshop.domain.CpuFamily;
import hu.tom.webshop.domain.CpuSocket;

import java.util.List;

public class CpuFamilyServiceImpl implements BaseService<CpuFamily> {

    private CpuFamilyDao cpuFamilyDao;

    public CpuFamilyServiceImpl() {
        cpuFamilyDao = new  CpuFamilyDao();
    }

    @Override
    public void create(CpuFamily cpuFamily) {
        cpuFamilyDao.save(cpuFamily);
    }

    @Override
    public CpuFamily findById(Long Id) {
        return cpuFamilyDao.findById(Id);
    }

    @Override
    public CpuFamily update(CpuFamily cpuFamily) {
        return cpuFamilyDao.merge(cpuFamily);
    }

    @Override
    public void delete(CpuFamily cpuFamily) {
        cpuFamilyDao.delete(cpuFamily);
    }

    public List<CpuFamily> findAllCpuFamilysBelongToSpecificSocket(CpuSocket cpuSocket) {
        return cpuFamilyDao.findAllCpuFamilysBelongToSpecificSocket(cpuSocket);
    }

    public List<CpuFamily> findAllCpuFamilies() {
        return cpuFamilyDao.findAllCpuFamilies();
    }
}
