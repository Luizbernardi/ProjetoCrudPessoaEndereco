package ArrayListPessoaEndereco;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MainEndereçoPessoa {
	
	static List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	

	public static void main(String[] args) {
		menuPessoa();
	}
	private static void menuPessoa() {
		int opcao;
		do {opcao = Integer.parseInt(JOptionPane.showInputDialog("=== Menu Pessoa ===\n" +
				"1. cadastrar Pessoa  \n" +
				"2. remover Pessoa \n"  +
				"3. atualizar Pessoa \n" +
				"4. listar Pessoa \n" +
				"5. pesquisa Avançada \n" +
				"0. Sair"
				));
				switch (opcao) {
				case 1:
					cadastrarPessoa();
					break;
				case 2:
					removerPessoa();
					break;
				case 3: 
					consultar();
					break;
				case 4:
					atualizarPessoa();
				case 5:
					listarPessoa();
				case 6:
					pesquisaAvancada();
				case 0:
					JOptionPane.showMessageDialog(null, "Saindo");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção invalida");
				}
		} while (opcao !=0);
	}
	private static void consultar() {
		String pessoaConsultar = JOptionPane.showInputDialog("Digite o nome da pessoa que deseja consultar");
		
		for (Pessoa pessoa : listaPessoas) {
			if(pessoa.getNome().equalsIgnoreCase(pessoaConsultar)) {
				System.out.println(pessoa.toString());
			}
			
		}
	}
	private static void pesquisaAvancada() {
	String ruapesquisa = JOptionPane.showInputDialog("Digite a rua que deseja pesquisar");
		
		for (Pessoa pessoa : listaPessoas) {
			if (pessoa.getEndereco().getRua().equalsIgnoreCase(ruapesquisa)) {
				JOptionPane.showMessageDialog(null, pessoa.toString());
			}
			
		}
		JOptionPane.showMessageDialog(null, "Rua não encontrada");	
	}

	private static void listarPessoa() {
		for (Pessoa pessoa : listaPessoas) {
			JOptionPane.showMessageDialog(null,pessoa.toString());
		}
		
	}

	private static void atualizarPessoa() {
		String pessoaToRefresh = JOptionPane.showInputDialog("Digite o nome da pessoa que deseja atualizar:");

		for (Pessoa pessoa : listaPessoas) {
			if(pessoa.getNome().equalsIgnoreCase(pessoaToRefresh)) {
				String novoNome = JOptionPane.showInputDialog("Digite o novo nome:");
				int novaIdade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova idade:"));
				String novaRua = JOptionPane.showInputDialog("Digite a nova rua do endereço:");
				String novaCidade = JOptionPane.showInputDialog("Digite a nova cidade do endereço:");
				String novoEstado = JOptionPane.showInputDialog("Digite o novo estado do endereço");

				pessoa.setNome(novoNome);
				pessoa.setIdade(novaIdade);
				pessoa.getEndereco().setRua(novaRua);
				pessoa.getEndereco().setCidade(novaCidade);
				pessoa.getEndereco().setEstado(novoEstado);
				
				JOptionPane.showMessageDialog(null, "Informações da pessoa atualizadas com sucesso!");
				return;
			}
		}

		JOptionPane.showMessageDialog(null, "Pessoa não encontrada na lista.");
	}
		

	private static void removerPessoa() {
		String pessoaremover = JOptionPane.showInputDialog("Digite o nome da pessoa que deseja remover");
		
		for (Pessoa pessoa : listaPessoas) {
			if (pessoa.getNome().equalsIgnoreCase(pessoaremover)) {
				listaPessoas.remove(pessoa);
				JOptionPane.showMessageDialog(null, "Pessoa removida");
				return;
			}
			
		}
		JOptionPane.showMessageDialog(null, "Pessoa não encontrada");	
	}

	private static void cadastrarPessoa() {
		String nome = JOptionPane.showInputDialog("Digite o nome da pessoa:");
		int idade = Integer.valueOf(JOptionPane.showInputDialog("Digite a idade da pessoa:"));
		String rua = JOptionPane.showInputDialog("Digite a rua do enreço:");
		String cidade = JOptionPane.showInputDialog("Digite a cidade do enreço:");
		String estado = JOptionPane.showInputDialog("Digite o estado do endereço:");
		Pessoa pessoa = new Pessoa(nome,idade, new Endereco(rua,cidade,estado));
		listaPessoas.add(pessoa);
		
	}

		
}






