package hu.tom.webshop.business;

import hu.tom.webshop.dao.ProcessorDao;
import hu.tom.webshop.domain.Processor;

import java.util.List;

public class ProcessorServiceImpl implements BaseService<Processor> {

    private final ProcessorDao processorDao;

    public ProcessorServiceImpl() {
        processorDao = new ProcessorDao();
    }

    @Override
    public void create(Processor processor) {
        processorDao.save(processor);
    }

    @Override
    public Processor findById(Long Id) {
        return processorDao.findProcessorById(Id);
    }

    public List<Processor> findAllProcessors() {
        return processorDao.findAllProcessors();
    }

    @Override
    public Processor update(Processor processor) {
        return processorDao.merge(processor);
    }

    @Override
    public void delete(Processor processor) {
        processorDao.delete(processor);
    }

    public void deleteAll() {
        processorDao.deleteAllProcessors();
    }

    public int getSize() {
        return Math.toIntExact(processorDao.getSize());
    }
}
