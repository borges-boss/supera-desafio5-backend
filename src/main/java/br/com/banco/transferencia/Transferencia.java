package br.com.banco.transferencia;
import javax.persistence.*;

import br.com.banco.conta.Conta;

@Entity
@Table(name = "transferencia")
public class Transferencia {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(name = "data_transferencia")
    @Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dataTransferencia;

    @Column(name = "valor")
	private float valor;

    @Column(name = "tipo")
	private String tipo;

    @Column(name = "nome_operador_transacao")
	private String nomeOperadorTransacao;

    @JoinColumn(name = "conta_id")
    private Conta conta;


    public Transferencia() {

    }

    public Transferencia(java.util.Date dataTransferencia, float valor, String tipo, String nomeOperadorTransacao, Conta conta) {
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
        this.conta = conta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.util.Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(java.util.Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeOperadorTransacao() {
        return nomeOperadorTransacao;
    }

    public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
}
