package br.com.banco.transferencia;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @PostMapping("/getTransferenciasByFilter")
    public ResponseEntity<?> getTransferenciasByFilter(HttpServletRequest request,HttpServletResponse response) {
        try {
         return new ResponseEntity<List<Transferencia>>(transferenciaService.getTransferenciaByFilter(request.getParameter("dataTransferenciaStart"),request.getParameter("dataTransferenciaEnd"),request.getParameter("nomeOperadorTransacao")), null, 200);
        } catch(Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>(ex.getMessage(), null, 500);
        }
    }


    @PostMapping("/getTransferenciasByConta")
    public ResponseEntity<?> getTransferenciasByConta(HttpServletRequest request,HttpServletResponse response) {
        try {
         return new ResponseEntity<List<Transferencia>>(transferenciaService.getTransferenciaByConta(request.getParameter("contaId")), null, 200);
        } catch(Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>(ex.getMessage(), null, 500);
        }
    }




}
