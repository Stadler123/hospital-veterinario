package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Animal;
import util.JPAUtil;

public class AnimalDao implements Serializable {

    EntityManager manager;

    public boolean excluir(Animal anml) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Animal temp = manager.find(Animal.class, anml.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }

    public boolean inserir(Animal anml) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(anml);
        tx.commit();
        manager.close();
        return true;
    }

    public List<Animal> listarTodos() {
        manager = JPAUtil.getEntityManager();
        CriteriaQuery<Animal> query = manager.getCriteriaBuilder().createQuery(Animal.class);
        query.select(query.from(Animal.class));
        List<Animal> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }

    public Animal buscarPorNome(String nome) {
        Animal temp;
        manager = JPAUtil.getEntityManager();
        String consulta = "SELECT c FROM Animal c WHERE c.Nome = :nome";
        TypedQuery<Animal> query = manager.createQuery(consulta, Animal.class);
        query.setParameter("nome", nome);
        temp = query.getSingleResult();
        manager.close();
        return temp;
    }
}
