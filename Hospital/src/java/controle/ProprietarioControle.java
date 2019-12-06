package controle;

import dao.ProprietarioDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Proprietario;

@ManagedBean(name = "ProprietarioControle")
@SessionScoped
public class ProprietarioControle {

    private Proprietario prop;
    private List<Proprietario> lista;
    private ProprietarioDao dao;

    public ProprietarioControle() {
        prop = new Proprietario();
        dao = new ProprietarioDao();
        lista = dao.listarTodos();
    }

    public void excluir(Proprietario prop) {
        dao.excluir(prop);
        lista.remove(prop);
        listar();
    }

    public void incluir() {
        dao.inserir(prop);
        lista.add(prop);
        limpar();
        listar();
    }

    public void limpar() {
        prop = new Proprietario();
    }

    public void listar() {
        lista = dao.listarTodos();
    }

    public Proprietario getProprietario() {
        return prop;
    }

    public void setProprietario(Proprietario prop) {
        this.prop = prop;
    }

    public List<Proprietario> getLista() {
        return lista;
    }

    public void setLista(List<Proprietario> lista) {
        this.lista = lista;
    }

}
