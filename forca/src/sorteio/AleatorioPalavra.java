package sorteio;
import java.util.Random;
import java.util.Scanner;
public class AleatorioPalavra {
	private String frase[] = new String[] {"Frigideira", "palmito", "java", "teclado", "cachorro", "galinha", "ovo", "areia vermelha", 
	"caçador de bruxa"};
	private String sorteia;


	private void sorteiaFrase() {//gera palavras aleatorias 
		Random gerador = new Random();

		String sorteia = frase[gerador.nextInt(frase.length)];

		this.sorteia = sorteia.toLowerCase();
	}



	private char[] imprimePalavra() {//inicia o sorteio, cria o char para receber a frase e imprime o cenario
		this.sorteiaFrase();//ativa o metodo sorteiaFrase

		char palavra[] = new char[this.sorteia.length()];//cria um char com o numero de caracteres que a palavra sorteada tem


		for(int i = 0; i < this.sorteia.length(); i++) {//cria uma string de caracteres com '_' e caso tenha espaço com '-' para separar.
			if(sorteia.charAt(i) == ' ') {
				palavra[i] = ' ';
			}
			else palavra[i] = '_';
		}

		for(int i = 0; i < this.sorteia.length(); i++) System.out.print(palavra[i] + " ");

		System.out.println("\n");
		return palavra;
	}



	public void jogo() {//realiza o jogo
		Scanner sc = new Scanner(System.in);
		char palavra[] = this.imprimePalavra();//imprime a palavra em caracteres 
		
		int tentativas = 0;//controla se já tentou as 6 letras
		char adv;//escreve a letra
		boolean venceu = false;

		do {
			boolean verifica = false;//se acertou a letra recebe true se errou retorna false

			System.out.print("Digite uma letra -> ");
			adv = sc.next().charAt(0);

			for(int i = 0; i < this.sorteia.length(); i++) {//verifica se existe a letra na palavra sorteada
				if(adv == this.sorteia.charAt(i)) {
					verifica = true;
					palavra[i] = adv;
				}
			}

			if(!verifica) tentativas++;//se errou a letra, tentativas incrementa + 1;

			for(int i = 0; i < this.sorteia.length(); i++) System.out.print(palavra[i] + " ");//imprime a frase
			System.out.println();
			System.out.println("Numero de tentativas: "+tentativas+"/ 6");//informa quantas tentativas foram
			System.out.println("***************************************************");


			for(int i = 0; i < this.sorteia.length(); i++) {//verifica se venceu
				if(sorteia.charAt(i) == palavra[i]) {
					venceu = true;
				}
				else {
					venceu = false;
					break;
				}
			}

		}while(tentativas != 6 && !venceu);

		if(venceu) {
			System.out.print("você venceu parabens, aqui está a palavra completa -> ");
			System.out.println(this.sorteia);
		}
		else {
			System.out.print("Que pena, você perdeu, a palavra era -> ");
			System.out.println(this.sorteia);
		}
	}
}