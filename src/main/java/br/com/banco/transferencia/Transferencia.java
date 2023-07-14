package br.com.banco.transferencia;
import java.util.Date;
import javax.persistence.*;
import br.com.banco.conta.Conta;

@Entity
@Table(name = "transferencia")
public class Transferencia {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_transferencia")
	private Date dataTransferencia;

    @Column(name = "valor")
	private float valor;

    @Column(name = "tipo")
	private String tipo;

    @Column(name = "nome_operador_transacao")
	private String nomeOperadorTransacao;

    @ManyToOne
    @JoinColumn(name="conta_id", nullable=false)
    private Conta contaId;


    public Transferencia() {
    }

    public Transferencia(Date dataTransferencia, float valor, String tipo, String nomeOperadorTransacao, Conta conta) {
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
        this.contaId = conta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
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
        if(this.tipo.equals("DEPOSITO") || this.tipo.equals("SAQUE"))
         return contaId.getNomeResponsavel();
        else
         return nomeOperadorTransacao;
    }

    public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }

    public Conta getContaId() {
        return contaId;
    }

    public void setContaId(Conta conta) {
        this.contaId = conta;
    }
    
}
