package br.com.banco.transferencia;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TransferenciaService {
    
    @Autowired
    TransferenciaRepositoryImp transferenciaRepositoryImp;

    public List<Transferencia> getTransferenciaByFilter(String dataTransferenciaStart, String dataTransferenciaEnd,String nomeOperadorTransacao) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        
        Date startDate = null, endDate = null;
        
        if(dataTransferenciaStart != null)
         startDate = formatter.parse(dataTransferenciaStart);
         

        if(dataTransferenciaEnd != null)
         endDate = formatter.parse(dataTransferenciaEnd);
        
        return transferenciaRepositoryImp.findByFilters(startDate,endDate,nomeOperadorTransacao);
    }


    public List<Transferencia> getTransferenciaByConta(String contaId) {
        if(contaId != null)
            return transferenciaRepositoryImp.findByContaId(Long.parseLong(contaId));
        
        return new ArrayList<Transferencia>();
    }
    
}
