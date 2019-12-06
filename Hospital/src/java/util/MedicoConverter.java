package util;

import dao.MedicoDao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import modelo.Medico;

@FacesConverter(value = "MedicoConverter", forClass = Medico.class)
public class MedicoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Medico temp = null;
        MedicoDao medDao = new MedicoDao();
        try {
            nome = value;
            temp = (Medico) medDao.buscarPorNome(nome);
        } catch (Exception e) {
            System.out.println("Erro MedicoConverter: " + e.toString());
        }
        return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Medico) {
            Medico med = (Medico) obj;
            return med.getNome();
        } else {
            throw new ConverterException(new FacesMessage(obj + " não é um medico válido"));
        }
    }
}
