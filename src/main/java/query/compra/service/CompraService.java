package query.compra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import query.compra.entity.Compra;
import query.compra.exceptions.NaoAcheiException;
import query.compra.repository.CompraRepository;

@Service
public class CompraService {

    @Autowired
    CompraRepository compraRepository;

    public Compra create(Compra compra){

        Compra createCompra = compraRepository.save(compra);


        return createCompra;
    }

    public List<Compra> getAll(){
        try {
            List<Compra> compras = new ArrayList<Compra>();
            compraRepository.findAll().forEach(compras::add);
            
            return compras;
        } catch (NaoAcheiException e) {
            return null;
        }
    }

    public List<Compra> findByDesconto(int desconto){

        // List<Compra> zeroDesconto = compraRepository.findByDesconto(desconto);
        List<Compra> zeroDesconto = new ArrayList<Compra>();
        compraRepository.findByDesconto(desconto).forEach(zeroDesconto::add);
        
        return zeroDesconto;
    }

    public List<Compra> comprasComDesconto(int desconto){

        // List<Compra> comDesconto = compraRepository.findByDescontoGreaterThan(desconto);
        List<Compra> comDesconto = new ArrayList<Compra>();
        compraRepository.findByDescontoGreaterThan(desconto).forEach(comDesconto::add);
        return comDesconto;

    }

    public List<Compra> getAllItemsPorValor(){

        // List<Compra> allItems = compraRepository.getAllItemsPorValor();
        List<Compra> allItems = new ArrayList<Compra>();
        compraRepository.getAllItemsPorValor().forEach(allItems::add);
        
        return allItems;
        
    }

    public String getProdutoMaisVendido(){

        String produtoMaisVendido = compraRepository.findProdutoMaisVendido();

        return produtoMaisVendido;

    }

    public List<Compra> getNfComQuantidadeProdutoMaior(Long quantidade){

        List<Compra> quantidadeMaior = new ArrayList<Compra>();
        compraRepository.findNfWithProdutoByQuantidadeGreaterThan(quantidade).forEach(quantidadeMaior::add);
        
        return quantidadeMaior;
        
    }


    public List<Compra> getNfComQuantidadeProdutoMaior(Double valor){

        List<Compra> valorMaior = new ArrayList<Compra>();
        compraRepository.findNfByValorTotalGreaterThanOrderByValorTotalDesc(valor).forEach(valorMaior::add);
        
        return valorMaior;
        
    }


    
}
