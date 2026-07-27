package cinevento.repository;

import cinevento.irl.*;

import java.util.List;

public interface Cinema {

    //Filmes
    void cadastrarFilme(Filme filme);
    Filme pesquisarFilme(int id);
    List<Filme> listarFilmes();
    void removerFilme(int id);

    //Cliente
    void cadastrarCliente(Cliente cliente);
    Cliente pesquisarCliente(String codigo);
    List<Cliente> listarClientes();
    void removerCliente(String codigo);

    //Ingressos - Sessões
    Ingresso comprarIngresso(Cliente cliente, Sessao sessao);
    void cancelarIngresso(String codigoReserva);

    //Sessões
    void cadastrarSessao(Sessao sessao);
    Sessao pesquisarSessao(int numero);
    List<Sessao> listarSessoes();
    void removerSessao(int numero);
}
