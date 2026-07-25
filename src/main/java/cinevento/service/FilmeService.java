package cinevento.service;

import cinevento.irl.Filme;
import cinevento.repository.Cinema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmeService implements Cinema {

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
        return null; //n é assim, eu so coloquei qualquer coisa pra IDE parar de encher o saco
    }

    @Override
    public void removerFilme(int id) {
        //TODO
    }

    @Override
    public void comprarIngresso() {
        //todoAAAAAAAAAAAAAAAAAA
    }

    @Override
    public void cancelarIngresso() {
        //todo
    }
}
