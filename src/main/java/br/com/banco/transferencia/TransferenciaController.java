package br.com.banco.transferencia;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @GetMapping("/getTransferenciasByFilter/{dataTransferenciaStart}/{dataTransferenciaEnd}/{nomeOperadorTransacao}")
    public List<Transferencia> getTransferenciasByFilter(@PathVariable String dataTransferenciaStart,@PathVariable String dataTransferenciaEnd,@PathVariable String nomeOperadorTransacao) {
        return transferenciaService.getTransferenciaByFilter(dataTransferenciaStart,dataTransferenciaEnd,nomeOperadorTransacao);
    }
}
