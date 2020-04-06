package hu.tom.webshop.business;

import hu.tom.webshop.dao.CpuArchitectTypeDao;
import hu.tom.webshop.domain.CpuArchitectType;

public class CpuArchitectTypeServiceImpl implements BaseService<CpuArchitectType> {

    private final CpuArchitectTypeDao cpuArchitectTypeDao;

    public CpuArchitectTypeServiceImpl() {
        cpuArchitectTypeDao = new CpuArchitectTypeDao();
    }

    @Override
    public void create(CpuArchitectType cpuArchitectType) {
        cpuArchitectTypeDao.save(cpuArchitectType);
    }

    @Override
    public CpuArchitectType findById(Long Id) {
        return cpuArchitectTypeDao.findById(Id);
    }

    @Override
    public CpuArchitectType update(CpuArchitectType cpuArchitectType) {
        return cpuArchitectTypeDao.merge(cpuArchitectType);
    }

    @Override
    public void delete(CpuArchitectType cpuArchitectType) {
        cpuArchitectTypeDao.delete(cpuArchitectType);
    }
}
