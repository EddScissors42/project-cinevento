package cinevento.service;

import cinevento.irl.*;
import cinevento.repository.Cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CinemaService implements Cinema {

    private Map<Integer, Filme> filmes = new HashMap<>();
    private Map<String, Cliente> clientes = new HashMap<>();
    private Map<Integer, Sessao> sessoes = new HashMap<>();
    private Map<String, Ingresso> ingressos = new HashMap<>();

    //os filme
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
        return new ArrayList<>(filmes.values());
    }

    @Override
    public void removerFilme(int id) {
        filmes.remove(id);
    }

    //coisa dos cliente
    @Override
    public void cadastrarCliente(Cliente cliente) {
        clientes.put(cliente.getCodigo(), cliente);
    }

    @Override
    public Cliente pesquisarCliente(String codigo) {
        return clientes.get(codigo);
    }

    @Override
    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes.values());
    }

    @Override
    public void removerCliente(String codigo) {
        clientes.remove(codigo);
    }

    //sessões
    @Override
    public void cadastrarSessao(Sessao sessao) {
        sessoes.put(sessao.getNumero(), sessao);
    }

    @Override
    public Sessao pesquisarSessao(int numero) {
        return sessoes.get(numero);
    }

    @Override
    public List<Sessao> listarSessoes() {
        return new ArrayList<>(sessoes.values());
    }

    @Override
    public void removerSessao(int numero) {
        sessoes.remove(numero);
    }

    //agora os ingresso (uma implementação de vdd)
    @Override
    public Ingresso comprarIngresso(Cliente cliente, Sessao sessao) {
        if (cliente == null || sessao == null) {
            throw new IllegalArgumentException("[ERRO]Eita, cliente e sessão não podem ser nulos!");
        }

        String codigoReserva = UUID.randomUUID().toString();
        Ingresso ingresso = new Ingresso(codigoReserva, sessao);
        ingressos.put(codigoReserva, ingresso);

        return ingresso;
    }

    @Override
    public void cancelarIngresso(String codigoReserva) {
        if (!ingressos.containsKey(codigoReserva)) {
            throw new IllegalArgumentException("O ingresso com o codigo " + codigoReserva + " não foi encontrado");
        }
        ingressos.remove(codigoReserva);
    }

}
