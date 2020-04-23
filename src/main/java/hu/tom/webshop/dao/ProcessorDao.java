package hu.tom.webshop.dao;

import hu.tom.webshop.domain.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
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

    public List<Processor> findProcessorsByCPuSockets(List<CpuSocket> cpuSockets) {
        Query query = currentSession.createQuery("SELECT p FROM Processor p WHERE p.cpuSocket IN :sockets");
        query.setParameter("sockets", cpuSockets);
        return query.getResultList();
    }

    public List<Processor> findAllProcessorByCpuParameters(List<CpuVendor> vendors, List<CpuSocket> sockets, List<CpuFamily> families, List<CpuVgaType> vgaTypes) {
        List<Processor> processors;
        if (vendors.isEmpty() & sockets.isEmpty() & families.isEmpty() & vgaTypes.isEmpty()) {
            processors = findAllProcessors();
        } else {
            CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
            CriteriaQuery<Processor> criteriaQuery = criteriaBuilder.createQuery(Processor.class);
            Root<Processor> root = criteriaQuery.from(Processor.class);
            criteriaQuery.select(root);
            List<Predicate> criteria = new ArrayList<>();
            if (!vendors.isEmpty()) {
                criteria.add(criteriaBuilder.in(root.get("cpuVendor")).value(vendors));
            }
            if (!sockets.isEmpty()) {
                criteria.add(criteriaBuilder.in(root.get("cpuSocket")).value(sockets));
            }
            if (!families.isEmpty()) {
                criteria.add(criteriaBuilder.in(root.get("cpuFamily")).value(families));
            }
            if (!vgaTypes.isEmpty()) {
                criteria.add(criteriaBuilder.in(root.get("cpuVgaType")).value(vgaTypes));
            }

            if (criteria.size() == 0) {
                throw new RuntimeException("no criteria");
            } else if (criteria.size() == 1) {
                criteriaQuery.where(criteria.get(0));
            } else {
                criteriaQuery.where(criteriaBuilder.and(criteria.toArray(new Predicate[0])));
            }
            TypedQuery<Processor> query = currentSession.createQuery(criteriaQuery);
            processors = query.getResultList();
        }
        return processors;
    }

}
