package br.com.banco.transferencia;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @GetMapping("/")
    public ResponseEntity<?> get() {
        try {
            return new ResponseEntity<List<Transferencia>>(transferenciaService.findAll(), null, 200);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>(ex.getMessage(), null, 500);
        }
    }

    @GetMapping("/{contaId}")
    public ResponseEntity<?> getTransferenciasByConta(@PathVariable String contaId) {
        try {
            return new ResponseEntity<List<Transferencia>>(transferenciaService.getTransferenciaByConta(contaId), null,
                    200);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>(ex.getMessage(), null, 500);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Transferencia transferencia) {
        try {
            return new ResponseEntity<Transferencia>(transferenciaService.save(transferencia), null, 200);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>(ex.getMessage(), null, 500);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            transferenciaService.deleteById(id);
            return new ResponseEntity<Boolean>(true, null, 200);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>(ex.getMessage(), null, 500);
        }
    }

    
    @PostMapping("/getTransferenciasByFilter")
    public ResponseEntity<?> getTransferenciasByFilter(HttpServletRequest request, HttpServletResponse response) {
        try {
            return new ResponseEntity<List<Transferencia>>(transferenciaService.getTransferenciaByFilter(
                    request.getParameter("dataTransferenciaStart"), request.getParameter("dataTransferenciaEnd"),
                    request.getParameter("nomeOperadorTransacao")), null, 200);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>(ex.getMessage(), null, 500);
        }
    }
}
