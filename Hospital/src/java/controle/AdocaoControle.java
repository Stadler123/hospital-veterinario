package controle;

import dao.AdocaoDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.AnimalAdocao;

@ManagedBean(name = "AdocaoControle")
@SessionScoped
public class AdocaoControle implements Serializable {

    private AnimalAdocao anml;
    private List<AnimalAdocao> lista;
    private AdocaoDao adocaoDao;

    public AdocaoControle() {        
        anml = new AnimalAdocao();
        adocaoDao = new AdocaoDao();
        lista = adocaoDao.listarTodos();
    }
    
    public void excluir(AnimalAdocao anml) {
        getAnmlDao().excluir(anml);
        getLista().remove(anml);
        listar();
    }

    public void incluir() {
        getAnmlDao().inserir(getAnml());
        getLista().add(getAnml());
        limpar();
        listar();
    }

    public void limpar() {
        setAnml(new AnimalAdocao());
    }

    public void listar() {
        setLista(getAnmlDao().listarTodos());
    }

    public AnimalAdocao getAnml() {
        return anml;
    }

    public void setAnml(AnimalAdocao anml) {
        this.anml = anml;
    }

    public List<AnimalAdocao> getLista() {//metodo publico
        return lista;//visibilidade: modificador: public ou private
    }

    public void setLista(List<AnimalAdocao> lista) {
        this.lista = lista;
    }

    public AdocaoDao getAnmlDao() {
        return adocaoDao;
    }

    public void setAnmlDao(AdocaoDao adocaoDao) {
        this.adocaoDao = adocaoDao;
    }

}
