package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbMedMat")

public class MedicamentoMaterial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMed")
    private Integer IdMed;
    @Column(length = 150, name = "Nome")
    private String Nome;
    @Column(name = "Estoque")
    private Integer Estoque;
    @Column(name = "Valor")
    private Double Valor;

    public MedicamentoMaterial() {
        this.IdMed = 0;
        this.Nome = "";
        this.Estoque = 0;
        this.Valor = 0.0;
    }

    public Integer getCodigo() {
        return IdMed;
    }

    public void setCodigo(Integer IdMed) {
        this.IdMed = IdMed;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Integer getEstoque() {
        return Estoque;
    }

    public void setEstoque(Integer Estoque) {
        this.Estoque = Estoque;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }
    
}
