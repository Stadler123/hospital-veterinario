package controle;

import dao.MedMatDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.MedicamentoMaterial;

@ManagedBean(name = "MedMatControle")
@SessionScoped
public class MedMatControle implements Serializable {

    private MedicamentoMaterial med;
    private MedicamentoMaterial aux;
    private List<MedicamentoMaterial> lista;
    private MedMatDao medDao;

    public void preparaAlterar(MedicamentoMaterial med) {
        setAux(med);
    }

    public void alterar() {
        medDao.alterar(getAux());
    }

    public MedMatControle() {
        med = new MedicamentoMaterial();
        medDao = new MedMatDao();
        lista = medDao.listarTodos();
    }

    public void excluir(MedicamentoMaterial med) {
        getMedDao().excluir(med);
        getLista().remove(med);
        listar();
    }

    public void incluir() {
        getMedDao().inserir(getMed());
        getLista().add(getMed());
        limpar();
        listar();
    }

    public void limpar() {
        setMed(new MedicamentoMaterial());
    }

    public void listar() {
        setLista(getMedDao().listarTodos());
    }

    public MedicamentoMaterial getMed() {
        return med;
    }

    public void setMed(MedicamentoMaterial med) {
        this.med = med;
    }

    public List<MedicamentoMaterial> getLista() {
        return lista;
    }

    public void setLista(List<MedicamentoMaterial> lista) {
        this.lista = lista;
    }

    public MedMatDao getMedDao() {
        return medDao;
    }

    public void setMedDao(MedMatDao medDao) {
        this.medDao = medDao;
    }

    public MedicamentoMaterial getAux() {
        return aux;
    }

    public void setAux(MedicamentoMaterial aux) {
        this.aux = aux;
    }

    
}
