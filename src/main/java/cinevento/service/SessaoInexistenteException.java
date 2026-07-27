package cinevento.service;

public class SessaoInexistenteException extends RuntimeException {
    public SessaoInexistenteException(String mensagem) {
        super(mensagem);
    }
}
