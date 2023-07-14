package br.com.banco.conta;
import javax.persistence.*;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    public Conta() {
    }

    public Conta(Long idConta, String nomeResponsavel) {
        this.idConta = idConta;
        this.nomeResponsavel = nomeResponsavel;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long id) {
        this.idConta = id;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}
