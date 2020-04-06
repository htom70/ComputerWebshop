package hu.tom.webshop.business;

import hu.tom.webshop.dao.CpuSocketDao;
import hu.tom.webshop.domain.CpuSocket;

public class CpuSocketServiceImpl implements BaseService<CpuSocket> {

    private final CpuSocketDao cpuSocketDao;

    public CpuSocketServiceImpl() {
        cpuSocketDao = new CpuSocketDao();
    }

    @Override
    public void create(CpuSocket cpuSocket) {
        cpuSocketDao.save(cpuSocket);
    }

    @Override
    public CpuSocket findById(Long Id) {
        return cpuSocketDao.findById(Id);
    }

    @Override
    public CpuSocket update(CpuSocket cpuSocket) {
        return cpuSocketDao.merge(cpuSocket);
    }

    @Override
    public void delete(CpuSocket cpuSocket) {
        cpuSocketDao.delete(cpuSocket);
    }
}
