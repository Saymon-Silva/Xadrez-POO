import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        Jogador j1 = new Jogador("jorge","Senh@123");
        Jogador j2 = new Jogador("Wilson","wilson");

        Tabuleiro tabuleiro = new Tabuleiro();
        printarTabuleiro(tabuleiro);


        j1.setCor("Branco",tabuleiro);
        j2.setCor("Preto", tabuleiro);

//        System.out.println(j1.getPecas()); // printando as peças do jogador
//        System.out.println(j2.getPecas());

        int escolhaPeca = sc.nextInt();

        // Escolha da peça
        Peca peca = j1.getPecas().get(escolhaPeca);
        System.out.println(peca);

        //Escolha da posição para o movimento
        ArrayList<Posicao> posicoes = peca.possiveisMovimento(tabuleiro);
        for(int i = 0; i <= posicoes.size(); i++) {
            System.out.println("posicoes " + posicoes);
        }
        int escolhaPosicao =sc.nextInt();
        Posicao posicao = posicoes.get(escolhaPosicao);

        // Movimentação da peça escolhida para a posição do tabuleiro
        j1.moverPeca(peca,posicao, tabuleiro,j2);
        System.out.println(validaVitoria(j2));




    }
//region(menu para usuarios)
    public static void menu(){
        //no tabuleiro, escrever em cada posição um "(numero do array(numero dentro da lista(posicao)))"
        //utilizar o indice (numero da posicao) pra fazer o usuario movimentar a peça
    }
//endregion
//region(funções)
    private static boolean validaVitoria(Jogador adversario){
        for(Peca peca : adversario.getPecas()){
            if(peca instanceof Rei){
                return false;
            }
        }
        return true;
    }
    private static void printarTabuleiro( Tabuleiro tabuleiro){

        ArrayList<Posicao> posicao = tabuleiro.getPosicoes();//posicao do tabuleiro

      for( int i = 0; i< posicao.size(); i++){

          if( posicao != null){
              Peca peca = posicao.get(i).getPeca();
              if (i % 8 == 0) {

              }
          }

      }
    }
//endregion

}
