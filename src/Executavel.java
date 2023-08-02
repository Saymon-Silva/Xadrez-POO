import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Jogador j1 = new Jogador("jorge","Senh@123");
        Jogador j2 = new Jogador("Wilson","wilson");

        Tabuleiro tabuleiro = new Tabuleiro();

        j1.setCor("Branco",tabuleiro);
        j2.setCor("Preto", tabuleiro);

        System.out.println(j1.getPecas());

        int escolhaPeca = sc.nextInt();
        // Escolha da peça
        Peca peca = j1.getPecas().get(escolhaPeca);
        System.out.println(peca);

        //Escolha da posição para o movimento
        ArrayList<Posicao> posicoes = peca.possiveisMovimento(tabuleiro);
        System.out.println("posicoes "+posicoes);
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

        ArrayList<Posicao> posicaoPecasTabuleiro = tabuleiro.getPosicoes();


        for ( int cont = 0; cont == 61; cont++) {
            Peca peca = posicaoPecasTabuleiro.get(cont).getPeca();
            if (cont == 0 || cont == 8 || cont == 16 || cont == 24 || cont == 32 || cont == 40 || cont == 48 || cont == 56) {
                System.out.println("|" + peca + "(" + posicaoPecasTabuleiro + ")");
            }
            else if (cont == 7 || cont == 15 || cont == 23 || cont == 31 || cont == 39 || cont == 47 || cont == 55 || cont == 63) {
                System.out.println(peca + "(" + posicaoPecasTabuleiro + ")|");
            }
            else{
                System.out.println("|" + peca + "(" + posicaoPecasTabuleiro + ")|");
            }
        }
    }
//endregion

}
