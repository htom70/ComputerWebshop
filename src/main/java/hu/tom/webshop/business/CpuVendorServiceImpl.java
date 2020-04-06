package hu.tom.webshop.business;

import hu.tom.webshop.dao.CpuVendorDao;
import hu.tom.webshop.domain.CpuVendor;

public class CpuVendorServiceImpl implements BaseService<CpuVendor> {

    private final CpuVendorDao cpuVendorDao;

    public CpuVendorServiceImpl() {
        cpuVendorDao = new CpuVendorDao();
    }

    @Override
    public void create(CpuVendor cpuVendor) {
        cpuVendorDao.save(cpuVendor);
    }

    @Override
    public CpuVendor findById(Long Id) {
        return cpuVendorDao.findById(Id);
    }

    @Override
    public CpuVendor update(CpuVendor cpuVendor) {
        return cpuVendorDao.merge(cpuVendor);
    }

    @Override
    public void delete(CpuVendor cpuVendor) {
        cpuVendorDao.delete(cpuVendor);
    }
}
