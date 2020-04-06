package hu.tom.webshop.dao;

import hu.tom.webshop.domain.Processor;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProcessorDao extends BaseDao<Processor> {

    public ProcessorDao() {
        super(Processor.class);
    }

    public Processor findProcessorById(Long Id) {
        return currentSession.get(Processor.class, Id);
    }

    public List<Processor> findAllProcessors() {
        List<Processor> result = new ArrayList<>();
        Query query = currentSession.createQuery("SELECT p FROM Processor p");
        return query.getResultList();
    }

    public void deleteAllProcessors() {
        openTransaction();
        currentTransaction.begin();
        String stringQuery = "DELETE FROM Processor";
        Query query = currentSession.createQuery(stringQuery);
        query.executeUpdate();
        currentTransaction.commit();
    }

    public Long getSize() {
        Criteria criteriaCount = currentSession.createCriteria(Processor.class);
        criteriaCount.setProjection(Projections.rowCount());
        return (Long) criteriaCount.uniqueResult();
    }

}
