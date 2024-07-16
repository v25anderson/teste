package br.com.javamagazine.clinicajm.dao;

import br.com.javamagazine.clinicajm.domain.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PacienteDaoImpl implements PacienteDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Paciente paciente) {
        em.persist(paciente);
    }

    @Override
    public List<Paciente> recuperar() {
        return em.createQuery("from Paciente", Paciente.class).getResultList();
    }

    @Override
    public Paciente recuperarPorID(long id) {
        return em.find(Paciente.class, id);
    }

    @Override
    public void atualizar(Paciente paciente) {
        em.merge(paciente);
    }

    @Override
    public void excluir(long id) {
        em.remove(em.getReference(Paciente.class, id));
    }
}
