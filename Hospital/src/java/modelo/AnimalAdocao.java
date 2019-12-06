package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbAnimalAdocao")

public class AnimalAdocao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAnimal")
    private Integer IdAnimal;
    @Column(length = 150, name = "Nome")
    private String Nome;
    @Column(length = 100, name = "Especie")
    private String Especie;
    @Column(length = 100, name = "Raca")
    private String Raca;
    @Column(length = 100, name = "Idade")
    private Integer Idade;
    @Column(length = 300, name = "Descricao")
    private String Descricao;

    public AnimalAdocao() {
        this.IdAnimal = 0;
        this.Especie = "";
        this.Nome = "";
        this.Raca = "";
        this.Idade = 0;
        this.Descricao = "";
    }

    public Integer getCodigo() {
        return IdAnimal;
    }

    public void setCodigo(Integer IdAnimal) {
        this.IdAnimal = IdAnimal;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String Especie) {
        this.Especie = Especie;
    }

    public String getRaca() {
        return Raca;
    }

    public void setRaca(String Raca) {
        this.Raca = Raca;
    }

    public Integer getIdade() {
        return Idade;
    }

    public void setIdade(Integer Idade) {
        this.Idade = Idade;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
}
