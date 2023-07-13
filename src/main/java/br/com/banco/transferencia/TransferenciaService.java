package br.com.banco.transferencia;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TransferenciaService {
    
    @Autowired
    TransferenciaRepositoryImp transferenciaRepository;

    public Transferencia getTransferenciaById(long id) {
        return transferenciaRepository.findById(id).get();
    }

    public List<Transferencia> getAllTransferencias() {
        return transferenciaRepository.findAll();
    }

    public List<Transferencia> getTransferenciaByFilter(String dataTransferenciaStart, String dataTransferenciaEnd,String nomeOperadorTransacao) {
        return transferenciaRepository.findByFilters(dataTransferenciaStart,dataTransferenciaEnd,nomeOperadorTransacao);
    }
    

}
