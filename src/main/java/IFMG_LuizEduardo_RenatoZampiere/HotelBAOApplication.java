package IFMG_LuizEduardo_RenatoZampiere;

import IFMG_LuizEduardo_RenatoZampiere.utils.InputOutputPers;

/**
 * Hotel BAO
 * Trabalho Prático disciplina de BackEnd (JAVA + Spring Boot)
 * IFMG - Campus Formiga (2025.1)
 * Integrantes:
 * 	> Luiz Eduardo Meireles Fernandes (0057517)
 * 	  luizedluimf10@gmail.com
 * 	  ------------------------------------------
 * 	> Renato Zampiere Maciente (0010710)
 * 	  renato.maciente@gmail.com
 * */



public class HotelBAOApplication {

	static InputOutputPers console = new InputOutputPers();

	public static void authenticationMethod(){
		boolean autentication;
		String op="";
		String user, password;

		do{
			user = console.input("Usuario: ");
			password = console.input("Senha: ");
			autentication = user.equals("jj") && password.equals("jj");

			if (!autentication){
				console.print(">> Impossível fazer login!\nÉ necessário um usuário e senha cadastrado no sistema\n\n");
				op = console.input("""
                        >> Aperte ENTER para retornar ao login, ou
                        digite exit, para finalizar programa.
                        $\s""");
			}

			if (op.equals("exit"))
				System.exit(0);

		}while (! autentication);
	}

	public static void main(String[] args) {
		console.print
				("""
				===============================================================
							 Bem vindo ao Sistema do Hotel BAO
				===============================================================
				""");

		// __ Autenticacao
		authenticationMethod();

		// Aplicacao principal
		String op;

		do{
			op = console.input("""
			\n===============================================================
									Menu de Opções
			===============================================================
			(1)  - Seção de Clientes
			(2)  - Cadastro de Quarto
			(3)  - Lancamento de Estadias
			(4)  - Listar dados dos Clientes
			(5)  - Listar dados dos Quartos
			(6)  - Listar Estadias cadastradas
			(7)  - Emitir nota Fiscal
			(8)  - Limpar banco de dados
			(9)  - Relatório - Maior valor da estadia do cliente
			(10) - Relatório - Menor valor da estadia do cliente
			(11) - Relatório - Totalizar as estadias do cliente
			(0)  - Finalizar Programa.
			===============================================================
			Sua Escolha:\s"""
			);

			switch (op){
				case "1":
					ClientSection();
					break;

				case "2":
					BedroomSection();
					break;

				case "0":
					break;

				default:
					console.input("ERRO, Escolha entre as opções disponíveis apenas!\nAperte ENTER para continuar.");

			}
		}while (! op.equals("0"));
	}


	public static void BedroomSection(){
		String op;
		do{
			op = console.input("""
			\n===============================================================
								Seção de Quartos
			===============================================================
			(1) - Inserir quarto.
			(2) - Deletar quarto.
			(3) - Alterar quarto.
			(0) - Voltar ao menu principal.
			===============================================================
			Sua escolha:\s"""
			);

			switch (op){
				case "1":
					break;


				case "2":
					break;

				case "3":
					break;

				case "0":
					break;

				default:
					console.input("ERRO, Escolha entre as opções disponíveis apenas!\nAperte ENTER para continuar.");
					break;
			}

		}while (!op.equals("0"));

	}


	public static void ClientSection(){
		String op;
		do{
			op = console.input("""
			\n===============================================================
								Seção de Clientes
			===============================================================
			(1) - Cadastrar cliente.
			(2) - Deletar cliente.
			(3) - Alterar Cliente.
			(0) - Voltar ao menu principal.
			===============================================================
			Sua escolha:\s"""
			);

			switch (op){
				case "1":
					break;

				case "2":
					break;

				case "3":
					break;

				case "0":
					break;

				default:
					console.input("ERRO, Escolha entre as opções disponíveis apenas!\nAperte ENTER para continuar.");
					break;
			}

		}while (! op.equals("0"));
	}


}
