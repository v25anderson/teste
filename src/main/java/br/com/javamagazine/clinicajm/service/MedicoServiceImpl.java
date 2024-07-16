package br.com.javamagazine.clinicajm.service;

import br.com.javamagazine.clinicajm.dao.MedicoDao;
import br.com.javamagazine.clinicajm.domain.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoDao medicoDao;

    @Override
    public void salvar(Medico medico) {
        medicoDao.salvar(medico);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Medico> recuperar() {
        return medicoDao.recuperar();
    }

    @Override
    @Transactional(readOnly = true)
    public Medico recuperarPorId(Long id) {
        return medicoDao.recuperarPorID(id);
    }

    @Override
    public void atualizar(Medico medico) {
        medicoDao.atualizar(medico);
    }

    @Override
    public void excluir(long id) {
        medicoDao.excluir(id);
    }

}
