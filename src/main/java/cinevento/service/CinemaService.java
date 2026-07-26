package cinevento.service;

import cinevento.irl.Filme;
import cinevento.repository.Cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaService implements Cinema {

    private Map<Integer, Filme> filmes = new HashMap<>();

    @Override
    public void cadastrarFilme(Filme filme) {
        filmes.put(filme.getId(), filme);
    }

    @Override
    public Filme pesquisarFilme(int id) {
        return filmes.get(id);
    }

    @Override
    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmes.values()); //eu sinceramente n sei o que fiz aqui, so sei que funciona
    }

    @Override
    public void removerFilme(int id) {
        filmes.remove(id);
    }

}
