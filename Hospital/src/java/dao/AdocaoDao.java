package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.AnimalAdocao;
import util.JPAUtil;

public class AdocaoDao implements Serializable {

    EntityManager manager;

    public boolean excluir(AnimalAdocao anm) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        AnimalAdocao temp = manager.find(AnimalAdocao.class, anm.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }

    public boolean inserir(AnimalAdocao anm) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(anm);
        tx.commit();
        manager.close();
        return true;
    }

    public List<AnimalAdocao> listarTodos() {
        manager = JPAUtil.getEntityManager();
        CriteriaQuery<AnimalAdocao> query = manager.getCriteriaBuilder().createQuery(AnimalAdocao.class);
        query.select(query.from(AnimalAdocao.class));
        List<AnimalAdocao> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
}
