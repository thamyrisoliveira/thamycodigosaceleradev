package challenge;


import java.util.LinkedList;
import java.util.Queue;

public class Estacionamento {
    private Queue<Carro> vagas = new LinkedList<>();
    private int LIMITE_VAGAS = 10;


    public void estacionar(Carro carro) {
        if(carro.getMotorista() == null){
            throw new EstacionamentoException("Não é permitido carro autônomo");
        }
        if(carro.getMotorista().getIdade() < 18){
            throw new EstacionamentoException("O motorista não pode ter menos de 18 anos!");
        }
        if(carro.getMotorista().getPontos() > 20){
            throw new EstacionamentoException("A carteira de habilitação não pode estar suspensa!");
        }
        if (vagas.size() < LIMITE_VAGAS) {
            vagas.add(carro);
        } else {
            Carro aSairDoEstacionamento = null;
            for (Carro carroEstacionado : vagas) {
                if (!carroEstacionado.isMotoristaIdoso()) {
                    aSairDoEstacionamento = carroEstacionado;
                    break;
                }
            }
            if(aSairDoEstacionamento == null){
                throw new EstacionamentoException("Estacionamento Lotado!");
            }
            vagas.remove(aSairDoEstacionamento);
            vagas.add(carro);
        }
    }

    public int carrosEstacionados() {
        return vagas.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return vagas.contains(carro);
    }
}
