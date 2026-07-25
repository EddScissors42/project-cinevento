package cinevento.repository;

import cinevento.irl.*;

import java.util.List;

public interface Cinema {
    void cadastrarFilme(Filme filme);
    Filme pesquisarFilme(int id);
    List<Filme> listarFilmes();
    void removerFilme(int id);

    void comprarIngresso (); //TODO
    void cancelarIngresso(); //TODO
}
