package br.senac.tads.dsw.usuariocrud.services;

import br.senac.tads.dsw.usuariocrud.entity.Papel;
import br.senac.tads.dsw.usuariocrud.repositories.PapelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PapelService {

    @Autowired
    private final PapelRepository repository;

    public List<Papel> listar(){
        List<Papel> listaPapel = repository.findAll();

        return listaPapel;
    }

}
