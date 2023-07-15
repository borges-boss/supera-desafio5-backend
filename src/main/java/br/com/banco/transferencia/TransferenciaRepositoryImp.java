package br.com.banco.transferencia;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import br.com.banco.conta.Conta;

@Repository
public class TransferenciaRepositoryImp implements TransferenciaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Transferencia> findAll() {
        return entityManager.createQuery("SELECT * FROM transferencia", Transferencia.class)
        .getResultList();
    }

    @Override
    public List<Transferencia> findAll(Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Transferencia> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @Override
    public <S extends Transferencia> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'flush'");
    }

    @Override
    public <S extends Transferencia> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
    }

    @Override
    public <S extends Transferencia> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
    }

    @Override
    public void deleteAllInBatch(Iterable<Transferencia> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @Override
    public Transferencia getOne(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @Override
    public Transferencia getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public <S extends Transferencia> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends Transferencia> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Page<Transferencia> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends Transferencia> S save(S entity) {
        if (entity.getId() == 0L) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

    @Override
    public Optional<Transferencia> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void deleteById(Long id) {
        Transferencia transferencia = entityManager.find(Transferencia.class, id);
        if (transferencia != null) {
            entityManager.remove(transferencia);
        }
    }

    @Override
    public void delete(Transferencia entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        for (Long id : ids) {
            Transferencia transferencia = entityManager.find(Transferencia.class, id);
            if (transferencia != null) {
                entityManager.remove(transferencia);
            }
        }
    }

    @Override
    public void deleteAll(Iterable<? extends Transferencia> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public <S extends Transferencia> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public <S extends Transferencia> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends Transferencia> long count(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public <S extends Transferencia> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public <S extends Transferencia, R> R findBy(Example<S> example,
            Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }


    public List<Transferencia> findByContaId(Long contaId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Transferencia> query = cb.createQuery(Transferencia.class);
        Root<Transferencia> root = query.from(Transferencia.class);
        List<Predicate> predicates = new ArrayList<>();
        Join<Transferencia, Conta> join = root.join("contaId");
        predicates.add(cb.equal(join.get("idConta"), contaId));

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).setMaxResults(500).getResultList();
    }

    public List<Transferencia> findByFilters(Date dataTransferenciaStart, Date dataTransferenciaEnd,String nomeOperadorTransacao) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Transferencia> query = cb.createQuery(Transferencia.class);
        Root<Transferencia> root = query.from(Transferencia.class);
        List<Predicate> predicates = new ArrayList<>();

        if (dataTransferenciaStart != null && dataTransferenciaEnd != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("dataTransferencia"), dataTransferenciaStart));
            predicates.add(cb.lessThanOrEqualTo(root.get("dataTransferencia"), dataTransferenciaEnd));
        }
        else if(dataTransferenciaStart != null && dataTransferenciaEnd == null){
            predicates.add(cb.greaterThanOrEqualTo(root.get("dataTransferencia"), dataTransferenciaStart));
        }
        else if(dataTransferenciaStart == null && dataTransferenciaEnd != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("dataTransferencia"), dataTransferenciaEnd));
        }

        if (nomeOperadorTransacao != null) {
            Join<Transferencia, Conta> join = root.join("contaId");
            Expression<Boolean> deposito = cb.and(cb.equal(root.get("tipo"), "DEPOSITO"), cb.equal(join.get("nomeResponsavel"), nomeOperadorTransacao));

            Expression<Boolean> saque = cb.and(cb.equal(root.get("tipo"), "SAQUE"), cb.equal(join.get("nomeResponsavel"), nomeOperadorTransacao));
            Expression<Boolean> transferencia = cb.and(cb.equal(root.get("tipo"), "TRANSFERENCIA"), cb.equal(root.get("nomeOperadorTransacao"), nomeOperadorTransacao));
            Expression<Boolean> responsavel =  cb.or(saque,transferencia);

            predicates.add(cb.or(deposito,responsavel));
        }

        query.where(predicates.toArray(new Predicate[0]));
        
        return entityManager.createQuery(query).setMaxResults(500).getResultList();
    }

}
