package hu.tom.webshop.business;

import hu.tom.webshop.dao.CpuVgaTypeDao;
import hu.tom.webshop.domain.CpuFamily;
import hu.tom.webshop.domain.CpuVgaType;

import java.util.List;

public class CpuVgaTypesServiceImpl implements BaseService<CpuVgaType> {

    private CpuVgaTypeDao cpuVgaTypeDao;

    public CpuVgaTypesServiceImpl() {
        cpuVgaTypeDao = new CpuVgaTypeDao();
    }

    @Override
    public void create(CpuVgaType cpuVgaType) {
        cpuVgaTypeDao.save(cpuVgaType);
    }

    @Override
    public CpuVgaType findById(Long Id) {
        return cpuVgaTypeDao.findById(Id);
    }

    @Override
    public CpuVgaType update(CpuVgaType cpuVgaType) {
        return cpuVgaTypeDao.merge(cpuVgaType);
    }

    @Override
    public void delete(CpuVgaType cpuVgaType) {
        cpuVgaTypeDao.delete(cpuVgaType);
    }

    public List<CpuVgaType> findAllCpuVgaTypesBelongToSpecificFamily(CpuFamily cpuFamily) {
        return cpuVgaTypeDao.findAllCpuVgaTypessBelongToSpecificFamily(cpuFamily);
    }
}
