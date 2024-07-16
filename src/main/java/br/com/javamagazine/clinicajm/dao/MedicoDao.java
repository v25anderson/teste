package br.com.javamagazine.clinicajm.dao;

import br.com.javamagazine.clinicajm.domain.Medico;

import java.util.List;

public interface MedicoDao {

    void salvar(Medico medico);
    List<Medico> recuperar();
    Medico recuperarPorID(long id);
    void atualizar(Medico medico);
    void excluir(long id);


}
