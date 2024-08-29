package query.compra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idNf;
    private Long idItem;
    private Long codProd;
    private Double valorUnitario;
    private Long quantidade;
    private int desconto;

    
    //  @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    // private String assunto;

    // private Date dataEnvio;

    // @OneToOne
    // @JoinColumn(name = "mensagemCorpo_id", referencedColumnName = "id")
    // private MensagemCorpo mensagemCorpo;

    //  private List<PostComment> comments = new ArrayList<PostComment>();

}
