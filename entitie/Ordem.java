package entitie;

import entities.enuns.StatusDaOrdem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ordem {
    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    private Date horaPedido;
    private StatusDaOrdem status;
    private Cliente client;
    private EnderecoSalvoPrincipal endSalvo;
    private List<ItensDoPedido> items = new ArrayList<>();

    public Ordem(){}

    public Ordem(Date horaPedido, StatusDaOrdem status, Cliente client, EnderecoSalvoPrincipal endSalvo) {
        this.horaPedido = horaPedido;
        this.status = status;
        this.client = client;
        this.endSalvo = endSalvo;
    }

    public EnderecoSalvoPrincipal getEndSalvo() {
        return endSalvo;
    }

    public void setEndSalvo(EnderecoSalvoPrincipal endSalvo) {
        this.endSalvo = endSalvo;
    }

    public Date getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(Date horaPedido) {
        this.horaPedido = horaPedido;
    }

    public StatusDaOrdem getStatus() {
        return status;
    }

    public void setStatus(StatusDaOrdem status) {
        this.status = status;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public void addItem(ItensDoPedido item){
        items.add(item);
    }

    public void removeItem (ItensDoPedido item) {
        items.remove(item);
    }

    public Double total(){
        double soma = 0;
        for(ItensDoPedido it : items){
            soma = soma + it.subtotal();
        }
        return soma;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("\n"+ "Hora do pedido: ");
        builder.append(sdf.format(horaPedido));
        builder.append("\n" + "Status da Ordem: ");
        builder.append(status);
        builder.append("\n"+ "Items do pedido: ");
        for (ItensDoPedido item : items){
            builder.append("\n"+item);
        }
        builder.append("\n"+"Preço total da nota: $");
        builder.append(String.format("%.2f", total())+"\n");
        builder.append("\n----------------------------------------------------------");
        builder.append("\nCliente: ");
        builder.append(client);
        builder.append("\nEndereço de entrega: "
                + "\nRua: " + endSalvo.getNomeRua()
                + " Bairro: " +  endSalvo.getBairro()
                + " CEP: "+ endSalvo.getCep());
        return builder.toString();
    }


}
