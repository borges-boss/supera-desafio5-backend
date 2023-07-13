package br.com.banco.conta;
import javax.persistence.*;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeResponsavel;

    // Constructors, getters, and setters

    public Conta() {
    }

    public Conta(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}
