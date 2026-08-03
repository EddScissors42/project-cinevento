package cinevento.irl;
import java.io.Serializable;

public class Ingresso implements Serializable{

    private String codigoReserva;
    private Sessao sessao;

    public Ingresso(String codigoReserva, Sessao sessao){
        this.codigoReserva= codigoReserva;
        this.sessao = sessao;
    }
    public String getCodigoReserva(){
        return codigoReserva;
    }
    public Sessao getSessao(){
        return this.sessao;
    }
    public void setSessao(Sessao sessao){
        this.sessao = sessao;
    }
    public String toString(){
        return "Ingresso: " + codigoReserva + " para a Sessão " + sessao;
    }
}
