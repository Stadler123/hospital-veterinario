package controle;

import dao.FuncionarioDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Funcionario;

@ManagedBean(name = "FuncionarioControle")
@SessionScoped
public class FuncionarioControle {

    private Funcionario func;
    private List<Funcionario> lista;
    private FuncionarioDao dao;

    public FuncionarioControle() {
        func = new Funcionario();
        dao = new FuncionarioDao();
        lista = dao.listarTodos();
    }

    public void excluir(Funcionario func) {
        dao.excluir(func);
        lista.remove(func);
        listar();
    }

    public void incluir() {
        dao.inserir(func);
        lista.add(func);
        limpar();
        listar();
    }

    public Funcionario getFuncionario() {
        return func;
    }

    public List<Funcionario> getLista() {
        return lista;
    }

    public void limpar() {
        func = new Funcionario();
    }

    public void listar() {
        lista = dao.listarTodos();
    }

    public void setFuncionario(Funcionario func) {
        this.func = func;
    }

    public void setLista(List<Funcionario> lista) {
        this.lista = lista;
    }
}
