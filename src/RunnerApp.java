import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * No java tudo é classe, então fiz uma classe RunnerApp, com o objetivo de rodar a aplicação
 * 
 *  a execução irá partir do main.
 * 
 * */
public class RunnerApp {

	// assim como no C, temos um método main para rodar aplicação, a partir daqui ele começa a executar o App.
	public static void main(String[] args) {
		
		Integer numeroCidades;
		System.out.println("==== IBGE ==== \n \n");
		System.out.println("Digite a quantidade de cidades a serem cadastradas: ");
		
		Scanner s = new Scanner(System.in);
		numeroCidades = s.nextInt();
		
		List<Cidade> cidades = popularDadosCidade(numeroCidades);
		
		for (Cidade cidade : cidades) {
			System.out.println(cidade);
		}
		
		Integer menu = 5;
		Scanner valorMenu = new Scanner(System.in);
		
		while (menu != 0) {
			imprimirMenuDeInformacoes();
			menu = valorMenu.nextInt();
			switch (menu) {
			case 1:
				Relatorios.descobriCidadeComMaiorNAcidentes(cidades, numeroCidades);
				break;
			case 2:
				Relatorios.descobriCidadeComMenorNAcidentes(cidades, numeroCidades);
				break;
			case 3:
				Relatorios.mediaVeiculosCidades(cidades, numeroCidades);
				break;
			case 4:
				Relatorios.mediaAcidentesCidadesMenor2000Veiculos(cidades, numeroCidades);
				break;
			case 0:
				System.out.println("\nSaindo da aplicação");
				break;
			default:
				System.out.println("\nValor inválido");
				break;
			}
		}
		
	}


	private static void imprimirMenuDeInformacoes() {
		System.out.println("\n\n----RELATÓRIOS----- \n\n");
	    System.out.println("\nDigite a opção desjada para: ");
	    System.out.println("\n1 - DESCOBRIR CIDADE COM MAIOR NUMERO DE ACIDENTES: ");
	    System.out.println("\n2 - DESCOBRIR CIDADE COM MENOR NUMERO DE ACIDENTES: ");
	    System.out.println("\n3 - MÉDIA DE VEICULOS ENTRE AS CIDADES: ");
	    System.out.println("\n4 - MÉDIA DE ACIDENTES ENTRE AS CIDADES COM MENOS DE 2000 VEICULOS: ");
	    System.out.println("\n0 - SAIR DA APLICAÇÃO: ");
	    System.out.println("\nopcaçõ:");
	}


	private static List<Cidade> popularDadosCidade(Integer numeroCidades) {
		
		System.out.println("\n\nAgora digite os dados da cidade: \n\n");
		List<Cidade> cidades = new ArrayList<Cidade>();
		
		for (int i = 0; i < numeroCidades; i++) {

			Scanner s = new Scanner(System.in);
			Cidade cidade = new Cidade();
			
			System.out.println("------------------------------");
			System.out.println("Cadastro da cidade:"+ (i + 1));

			System.out.println("Digite o código da cidade: \n");
			cidade.setCodigoCidade(s.nextInt());
			cidade.setNomeCidade(s.nextLine()); //para pular linha após o next int
			
			System.out.println("Digite o nome da cidade: \n");
			cidade.setNomeCidade(s.nextLine()); //recebe a linha após a syso 

			System.out.println("Digite o número de veiculos de passeio da cidade: \n");
			cidade.setQuantidadeVeiculo(s.nextInt());

			System.out.println("Digite o número de acidentes de trânsito com vítimas: \n");
			cidade.setQuantidadeVitimas(s.nextInt());
			
			cidades.add(cidade);
		}
		
		return cidades;
	}
}
