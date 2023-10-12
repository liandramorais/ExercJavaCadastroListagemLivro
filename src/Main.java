import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Livro> listaLivro = new ArrayList<>();
        Livro metodoLivro = new Livro();
        System.out.println("Bem vindo ao Sistema de Listagem de livros!!");

        Scanner leitor = new Scanner(System.in);

        int opcaoLivro;

        do {
            System.out.println("Escolha uma opção: 1 - Entrar no sistema / 0 - Sair");
            opcaoLivro = leitor.nextInt();

            switch (opcaoLivro) {

                case 1:
                    int cadLivro;
                    do {
                        System.out.println("Escolha uma opção: 1 - Cadastrar livro / 2 - Listar livro / 0 - Voltar ao menu anterior");
                        cadLivro = leitor.nextInt();

                        switch (cadLivro) {
                            case 1:

                                Livro novoLivro = new Livro();

                                Autor novoAutor = new Autor();

                                System.out.println("Digite o nome do autor: ");
                                novoAutor.nome = leitor.next();

                                System.out.println("Digite o local de Nascimento do autor: ");
                                novoAutor.localNasc = leitor.next();

                                System.out.println("Digite o título do livro: ");
                                novoLivro.titulo = leitor.next();

                                System.out.println("Digite o valor do livro: ");
                                novoLivro.preco = leitor.next();

                                System.out.println("Digite a data de Lançamento (dd/MM/aaaa): ");
                                LocalDate date = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                                Period periodo = Period.between(date, LocalDate.now());

                                novoLivro.dataLancamento = date;

                                if (periodo.getYears() < 5) {
                                    System.out.println("O livro tem menos de 5 anos. ");

                                } else {
                                    System.out.println("O livro tem mais de 5 anos. Retornando ao Menu");
                                    break;
                                }

                                novoLivro.autor = novoAutor;
                                listaLivro.add(novoLivro);

                                System.out.println("Cadastro realizado com sucesso!! ");

                                break;

                            case 2:

                                if (listaLivro.size() > 0) {

                                    for (Livro cadaLivro : listaLivro) {
                                        System.out.println();
                                        System.out.println("Nome do autor: " + cadaLivro.autor.nome);
                                        System.out.println("Local de Nascimento: " + cadaLivro.autor.localNasc);
                                        System.out.println("Título do livro: " + cadaLivro.titulo);
                                        System.out.println("Valor do livro: " + cadaLivro.preco);
                                        System.out.println("Data de Lançamento: " + cadaLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("...");
                                    }
                                    System.out.println("Escolha uma opção: 1 - Cadastrar novo livro / 0 - Voltar ao menu anterior");

                                    cadLivro = leitor.nextInt();

                                } else {
                                    System.out.println("Lista vazia! ");
                                }
                                break;

                            case 0:
                                System.out.println("Voltando ao menu anterior!!");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    } while (cadLivro != 0);
                    break;
                case 0:
                    System.out.println("Obrigado(a) por utilizar o nosso sistema! Forte abraço! ");
                    break;
                default:
                    System.out.println("Opção inválida, por favor digite uma opção válida!");
                    break;

            }
        } while (opcaoLivro != 0);
    }
}