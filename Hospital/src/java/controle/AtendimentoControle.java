package controle;

import dao.AnimalDao;
import dao.AtendimentoDao;
import dao.MedicoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Animal;
import modelo.Medico;
import modelo.Atendimento;

@ManagedBean(name = "AtendimentoControle")
@SessionScoped
public class AtendimentoControle {

    private Atendimento atndmnto;
    private List<Atendimento> lista;
    private final AtendimentoDao dao;
    private final AnimalDao anmlDao;
    private Animal animalSelecionado;
    private List<Animal> animais;
    private final MedicoDao medDao;
    private Medico medicoSelecionado;
    private List<Medico> medicos;

    public AtendimentoControle() {
        atndmnto = new Atendimento();
        dao = new AtendimentoDao();
        anmlDao = new AnimalDao();
        medDao = new MedicoDao();
        lista = dao.listarTodos();
        animais = anmlDao.listarTodos();
        animalSelecionado = new Animal();
        medicos = medDao.listarTodos();
        medicoSelecionado = new Medico();
    }

    public void excluir(Atendimento atndmnto) {
        dao.excluir(atndmnto);
        lista.remove(atndmnto);
        listar();
    }

    public void incluir() {
        atndmnto.setAnimal(getAnimalSelecionado());
        atndmnto.setMedico(getMedicoSelecionado());
        dao.inserir(atndmnto);
        lista.add(atndmnto);
        limpar();
        listar();
    }

    public void limpar() {
        atndmnto = new Atendimento();
    }

    public void listar() {
        lista = dao.listarTodos();
    }

    public Atendimento getAtendimento() {
        return atndmnto;
    }

    public List<Atendimento> getLista() {
        return lista;
    }

    public void setAtendimento(Atendimento atndmnto) {
        this.atndmnto = atndmnto;
    }

    public void setLista(List<Atendimento> lista) {
        this.lista = lista;
    }

    public Animal getAnimalSelecionado() {
        return animalSelecionado;
    }

    public void setAnimalSelecionado(Animal animalSelecionado) {
        this.animalSelecionado = animalSelecionado;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public Medico getMedicoSelecionado() {
        return medicoSelecionado;
    }

    public void setMedicoSelecionado(Medico medicoSelecionado) {
        this.medicoSelecionado = medicoSelecionado;
    }
}
