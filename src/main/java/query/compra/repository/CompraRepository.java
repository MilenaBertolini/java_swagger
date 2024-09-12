package query.compra.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import query.compra.entity.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{

    // Retorna todos os itens que foram vendidos sem desconto. 
    List<Compra> findByDesconto(int desconto);


    // Retorna todos os itens que foram vendidos com desconto. 
    List<Compra> findByDescontoGreaterThan(int desconto);

    //Retorna todos os itens e ordene o resultado por VALOR_UNIT do maior valor para o menor. 
    @Query("select c from Compra c order by c.valorUnitario desc")
    List<Compra> getAllItemsPorValor();

    // Retorna o produto que mais vendeu.
    @Query("select c.codProd from Compra c group by c.codProd order by sum(c.quantidade) desc")
    String findProdutoMaisVendido();

    @Query("select c from Compra c where c.quantidade > :quantidade")
    List<Compra> findNfWithProdutoByQuantidadeGreaterThan(@Param("quantidade") Long quantidade);

    @Query("select c from Compra c group by c.idNf having sum(c.valorUnitario * c.quantidade) > :valor order by sum(c.valorUnitario * c.quantidade) desc")
    List<Compra> findNfByValorTotalGreaterThanOrderByValorTotalDesc(@Param("valor") Double valor);


}
