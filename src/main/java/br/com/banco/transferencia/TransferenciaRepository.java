package br.com.banco.transferencia;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

}
