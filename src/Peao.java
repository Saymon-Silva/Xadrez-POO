import java.util.ArrayList;

public class Peao extends Peca{
    public Peao(String cor, Posicao posicao){
        super(cor, posicao);
    }
    private boolean primMov = true;

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> posicaoTabuleiro = tabuleiro.getPosicoes();
       if(this.getCor().equals("Preto")){
           if(posicaoTabuleiro.get(posicaoNoTabuleiro+8).getPeca() != null) {
               possiveisMovimentos.add(posicaoTabuleiro.get(posicaoNoTabuleiro + 8));
               if (this.primMov) {
                   if(posicaoTabuleiro.get(posicaoNoTabuleiro+16).getPeca() != null){
                   possiveisMovimentos.add(posicaoTabuleiro.get(posicaoNoTabuleiro + 16));
                    }
               }
           }
           if (posicaoTabuleiro.get(posicaoNoTabuleiro+9).getPeca().getCor().equals("Branco") && !validaExtremidade( posicaoNoTabuleiro+1)){
               possiveisMovimentos.add(posicaoTabuleiro.get(posicaoNoTabuleiro+9));
           }
           if (posicaoTabuleiro.get(posicaoNoTabuleiro+7).getPeca().getCor().equals("Branco") && !validaExtremidade( posicaoNoTabuleiro)){
               possiveisMovimentos.add(posicaoTabuleiro.get(posicaoNoTabuleiro+7));
            }
       }
        else{
           if(posicaoTabuleiro.get(posicaoNoTabuleiro-8).getPeca()!=null) {
               possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro - 8));
               if (this.primMov) {
                   if(posicaoTabuleiro.get(posicaoNoTabuleiro-16).getPeca()!=null){
                       possiveisMovimentos.add(posicaoTabuleiro.get(posicaoNoTabuleiro - 16));
                   }
               }
           }
           if (posicaoTabuleiro.get(posicaoNoTabuleiro-9).getPeca().getCor().equals("Preto")  &&  !validaExtremidade( posicaoNoTabuleiro)){
               possiveisMovimentos.add(posicaoTabuleiro.get(posicaoNoTabuleiro-9));
           }
           if (posicaoTabuleiro.get(posicaoNoTabuleiro-7).getPeca().getCor().equals("Preto")  &&  !validaExtremidade( posicaoNoTabuleiro+1)){
               possiveisMovimentos.add(posicaoTabuleiro.get(posicaoNoTabuleiro-7));
           }
        }

        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        String letra = this.getCor().substring(0,1);
        return "P - " + letra;
    }
}
