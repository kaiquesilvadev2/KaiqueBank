package conta;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ContaController.ContaController;
import conta.model.Cargo;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.model.Usuario;
import conta.util.Cores;

// ✅ Nome da classe deve começar com letra maiúscula
public class Menu {

	// ✅ Scanner declarado apenas uma vez (removida duplicação)
	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		// Instância do controlador de contas
		ContaController contas = new ContaController();

		// Variáveis que serão usadas no menu
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

		// Loop infinito até o usuário escolher sair
		while (true) {

			// ✅ Menu colorido
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1  - Criar Usuário                       ");
			System.out.println("            2  - Criar Conta                         ");
			System.out.println("            3  - Listar todas as Contas              ");
			System.out.println("            4  - Buscar Conta por Numero             ");
			System.out.println("            5  - Atualizar Dados da Conta            ");
			System.out.println("            6  - Apagar Conta                        ");
			System.out.println("            7  - Sacar                               ");
			System.out.println("            8  - Depositar                           ");
			System.out.println("            9  - Transferir valores entre Contas     ");
			System.out.println("            10 - Sair                                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			// ✅ Tratamento de erro caso usuário digite letras
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			// ✅ Condição de saída
			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
				leia.close();
				System.exit(0);
			}

			try {

				// ✅ Switch com todas as opções do menu
				switch (opcao) {

				case 1:
					Usuario usuario = new Usuario();
					System.out.println("=== Cadastro de Usuário ===");

					System.out.print("Digite o ID: ");
					usuario.setId(leia.nextLong());
					leia.nextLine(); // consome quebra de linha

					System.out.print("Digite o Nome Completo: ");
					usuario.setNomeCompleto(leia.nextLine());

					System.out.print("Digite o Email de Login: ");
					usuario.setEmailLogin(leia.nextLine());

					System.out.print("Digite o CPF: ");
					usuario.setCpf(leia.nextLine());

					System.out.print("Digite a Senha: ");
					usuario.setSenha(leia.nextLine());

					// Cargos
					ArrayList<Cargo> cargos = new ArrayList<>();
					String resposta;
					do {
						System.out.print("Digite o nome do Cargo: ");
						String nomeCargo = leia.nextLine();

						Cargo cargo = new Cargo();
						cargo.setNomeCargo(nomeCargo);
						cargos.add(cargo);

						System.out.print("Deseja adicionar mais cargos? (s/n): ");
						resposta = leia.nextLine();

					} while (resposta.equalsIgnoreCase("s"));

					usuario.setCargosd(cargos);

					System.out.println("\n=== Usuário Cadastrado com Sucesso ===");
					System.out.println("ID: " + usuario.getId());
					System.out.println("Nome: " + usuario.getNomeCompleto());
					System.out.println("Email: " + usuario.getEmailLogin());
					System.out.println("CPF: " + usuario.getCpf());
					System.out.println("Senha: " + usuario.getSenha());
					System.out.println("Cargos: ");
					usuario.getCargosd().forEach(c -> System.out.println("- " + c.getNomeCargo()));

					break;

				case 2:
					System.out.println("\nDigite o número da agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o nome do titular: ");
					leia.skip("\\R?"); // consome enter
					titular = leia.nextLine();

					// ✅ Corrigido: validação do tipo de conta
					do {
						System.out.println("Digite o tipo da conta (1-cc ou 2-cp): ");
						tipo = leia.nextInt();
					} while (tipo < 1 || tipo > 2);

					System.out.println("Digite o saldo da conta (R$): ");
					saldo = leia.nextFloat();

					// ✅ Conta Corrente ou Poupança
					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite de crédito (R$): ");
						limite = leia.nextFloat();
						contas.cadastrar(
								new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = leia.nextInt();
						contas.cadastrar(
								new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
					}
					keyPress();
					break;

				case 3:
					System.out.println("\n Listar todas as Contas");
					contas.listarTodas();
					keyPress();
					break;

				case 4:
					System.out.println("\n Buscar Conta por número");
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();

					contas.procurarPorNumero(numero);
					keyPress();
					break;

				case 5:
					System.out.println("\n Atualizar dados da Conta");

					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();

					// ✅ Só atualiza se a conta existir
					if (contas.buscarNaCollection(numero) != null) {

						System.out.println("Digite o número da agência: ");
						agencia = leia.nextInt();
						System.out.println("Digite o nome do titular: ");
						leia.skip("\\R?");
						titular = leia.nextLine();

						// ✅ Corrigido texto
						System.out.println("Digite o saldo da conta (R$): ");
						saldo = leia.nextFloat();

						// ✅ Método deve ser retornaTipo (ajuste de nome)
						tipo = contas.retornaTIpo(numero);

						switch (tipo) {
						case 1 -> {
							System.out.println("Digite o limite de crédito (R$): ");
							limite = leia.nextFloat();
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("Digite o dia do aniversário da conta: ");
							aniversario = leia.nextInt();
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
						default -> {
							System.out.println("Tipo de conta inválido! ");
						}
						}
					} else {
						System.out.println("\nConta não encontrada! ");
					}

					keyPress();
					break;

				case 6:
					System.out.println("\n Apagar Conta");
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();

					contas.deletar(numero);
					keyPress();
					break;

				case 7:
					System.out.println("\n Sacar");
					// ✅ Aqui você pode implementar a lógica de saque
					keyPress();
					break;

				case 8:
					System.out.println("\n Depositar");
					// ✅ Aqui você pode implementar a lógica de depósito
					keyPress();
					break;

				case 9:
					System.out.println("\n Transferir");
					// ✅ Aqui você pode implementar a lógica de transferência
					keyPress();
					break;

				default:
					System.out.println("\nOpção Inválida" + Cores.TEXT_RESET);
					keyPress();
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("\n Algo de errado tente de novo!");
				leia.nextLine();
				opcao = 0;
			}

		}
	}

	// ✅ Método auxiliar para pausar execução até usuário pressionar Enter
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
