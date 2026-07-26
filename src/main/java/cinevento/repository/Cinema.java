package cinevento.repository;

import cinevento.irl.*;

import java.util.List;

public interface Cinema {

    //Filmes
    void cadastrarFilme(Filme filme);
    Filme pesquisarFilme(int id);
    List<Filme> listarFilmes();
    void removerFilme(int id);

    //Ingressos - Sessões
    Ingresso comprarIngresso(Cliente cliente, Sessao sessao);
    void cancelarIngresso(String codigoReserva);

    //TODO - Cliente
}
