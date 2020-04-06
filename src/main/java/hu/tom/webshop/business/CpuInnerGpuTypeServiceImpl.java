package hu.tom.webshop.business;

import hu.tom.webshop.dao.CpuInnerGpuTypeDao;
import hu.tom.webshop.domain.CpuInnerGpuType;

public class CpuInnerGpuTypeServiceImpl implements BaseService<CpuInnerGpuType> {

    private final CpuInnerGpuTypeDao cpuInnerGpuTypeDao;

    public CpuInnerGpuTypeServiceImpl() {
        cpuInnerGpuTypeDao = new CpuInnerGpuTypeDao();
    }

    @Override
    public void create(CpuInnerGpuType cpuInnerGpuType) {
     cpuInnerGpuTypeDao.save(cpuInnerGpuType);
    }

    @Override
    public CpuInnerGpuType findById(Long Id) {
        return cpuInnerGpuTypeDao.findById(Id);
    }

    @Override
    public CpuInnerGpuType update(CpuInnerGpuType cpuInnerGpuType) {
        return cpuInnerGpuTypeDao.merge(cpuInnerGpuType);
    }

    @Override
    public void delete(CpuInnerGpuType cpuInnerGpuType) {
        cpuInnerGpuTypeDao.delete(cpuInnerGpuType);
    }
}
