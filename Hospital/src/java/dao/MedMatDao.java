package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.MedicamentoMaterial;
import util.JPAUtil;

public class MedMatDao implements Serializable {

    EntityManager manager;

    public boolean alterar(MedicamentoMaterial med){
        manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(med);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
    
    public boolean excluir(MedicamentoMaterial med) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        MedicamentoMaterial temp = manager.find(MedicamentoMaterial.class, med.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }

    public boolean inserir(MedicamentoMaterial med) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(med);
        tx.commit();
        manager.close();
        return true;
    }

    public List<MedicamentoMaterial> listarTodos() {
        manager = JPAUtil.getEntityManager();
        CriteriaQuery<MedicamentoMaterial> query = manager.getCriteriaBuilder().createQuery(MedicamentoMaterial.class);
        query.select(query.from(MedicamentoMaterial.class));
        List<MedicamentoMaterial> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
    
}
