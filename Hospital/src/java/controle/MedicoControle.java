package controle;

import dao.MedicoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Medico;

@ManagedBean(name = "MedicoControle")
@SessionScoped
public class MedicoControle {

    private Medico med;
    private List<Medico> lista;
    private MedicoDao dao;

    public MedicoControle() {
        med = new Medico();
        dao = new MedicoDao();
        lista = dao.listarTodos();
    }

    public void excluir(Medico med) {
        dao.excluir(med);
        lista.remove(med);
        listar();
    }

    public void incluir() {
        dao.inserir(med);
        lista.add(med);
        limpar();
        listar();
    }

    public void limpar() {
        med = new Medico();
    }

    public void listar() {
        lista = dao.listarTodos();
    }

    public Medico getMedico() {
        return med;
    }

    public void setMedico(Medico med) {
        this.med = med;
    }

    public List<Medico> getLista() {
        return lista;
    }

    public void setLista(List<Medico> lista) {
        this.lista = lista;
    }
}
