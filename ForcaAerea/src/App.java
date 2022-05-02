import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private final static int TAMANHO_INICIAL_LISTAS = 3;
    private static Scanner scanner = new Scanner(System.in);
    private static Piloto[] _pilotos = new Piloto[TAMANHO_INICIAL_LISTAS];
    private static int _numeroPilotos = 0;

    public static void main(String[] args) throws Exception {
        boolean continuarExecutando = true;
        do {
            try {
                imprimirMenu();
                int opcao = lerOpcao();
                continuarExecutando = executarOpcao(opcao);
            } catch (Exception e) {
                System.out.println("Ocorreu um erro durante a operação. " + e.getMessage());
                continuarExecutando = true;
            }
        } while (continuarExecutando);
    }

    private static boolean executarOpcao(int opcao) throws Exception {
        switch (opcao) {
            case 1: {
                cadastrarPiloto();
                break;
            }
            case 2: {
                listarPilotos();
                break;
            }
            case 3: {
                buscarPiloto();
                break;
            }
            case 4:{
                aumentarArmazenamento();        
                break;        
            }
            case 5: {
                System.out.println("Saindo do sistema...");
                return false;
            }
            default: {
                System.out.println("Ainda não implementada!");
                break;
            }
        }
        return true;
    }

    private static void listarPilotos() {
        if(_numeroPilotos ==0){
           System.out.println("Não há pilotos cadastrados para exibir !!");
           System.out.println("");
        }   else{
            System.out.println("--------------------------------------");
             System.out.println("Lista de Pilotos cadastrados:");
            for (int i = 0; i < _numeroPilotos; i++) {
            System.out.println(_pilotos[i]);
        }  
      }
    }

    private static void adicionarPilotoNaLista(Piloto piloto) { 
        _pilotos[_numeroPilotos] = piloto;
        _numeroPilotos++;
    }

    private static void buscarPiloto() {
            System.out.println("Digite o CPF: ");
            String buscapiloto = scanner.next();
            for (Piloto piloto: _pilotos) {
                if (piloto != null && piloto.getCpf().equals(buscapiloto)) {
                    System.out.println(piloto);
                }
            }
        }

    private static void aumentarArmazenamento(){
            //Solicito o tamanho da nova lista.
            System.out.println("Informe o tamanho da nova lista: ");
            int tamanho = scanner.nextInt();
            Piloto[] novaLista = new Piloto[_pilotos.length * tamanho];
            System.out.println("Lista aumentada em "+tamanho+"x com sucesso!");
            System.out.println("Novo tamanho da lista: "+ _pilotos.length * tamanho);
            // Copio os elementos da lista antiga para a nova lista.
            for (int i = 0; i < _pilotos.length; i++) {
                novaLista[i] = _pilotos[i];
            }
              // Substituo a lista antiga pela nova.
            _pilotos = novaLista;  
    } 

    private static void cadastrarPiloto() throws InputMismatchException {

        if (_numeroPilotos >= _pilotos.length) {
            System.out.println("O Tamanho da lista excedeu. Aumentar o tamanho da lista para seguir!!");
            aumentarArmazenamento();
        }else{

            System.out.println("Cadastro de Pilotos");
            System.out.println("-------------------------------------------");
            System.out.print("Nome Completo do Piloto: ");
            String nome = scanner.nextLine();
            System.out.print("Nº Certificado de Habilitação Técnica (CHT): ");
            String cht = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.println("");
            System.out.println("Piloto cadastrado com Sucesso!! ");
            Piloto piloto = new Piloto(nome, cht, cpf);
            adicionarPilotoNaLista(piloto);
        }
    }

   private static void imprimirMenu() {
        System.out.println("");
        System.out.println("Selecione a opção desejada: ");
        System.out.println("-----------------MENU----------------");
        System.out.println("1) Cadastrar Piloto");
        System.out.println("2) Listar Piloto");
        System.out.println("3) Buscar Piloto");
        System.out.println("4) Aumentar o Armazenamento da Lista");
        System.out.println("5) Sair");
    }

    private static boolean validarOpcaoMenu(int opcao) {
        return (opcao >= 1 && opcao <= 5);
    }

    private static int lerOpcao() {
            int opcao = 0;
            do {
                System.out.println("");
                System.out.println("Digite a opção desejada: ");
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                    if (!validarOpcaoMenu(opcao)) {
                    System.out.println("Opção inválida!");
                    }
                } catch (Exception e) {
                    System.out.println("Opção inválida!");
                }
            } while (!validarOpcaoMenu(opcao));

            return opcao;
    }
        
}
