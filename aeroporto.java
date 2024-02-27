import java.util.Scanner;

public class aeroporto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a quantidade de passageiros: ");
        int N = scanner.nextInt();
        scanner.nextLine(); 
        
        for(int i = 0; i < N; i++) {
            System.out.println("\nPassageiro " + (i+1));
            System.out.print("RG (Digite 'RG' ou 'Nao possui'): ");
            String rg = scanner.nextLine();
            if(rg.equals("Nao possui")) {
                System.out.println("A saída é nessa direção.");
                continue;
            }
            
            System.out.print("Data de nascimento no RG (DD/MM/AAAA): ");
            String dataRG = scanner.nextLine();
            
            System.out.print("Passagem (Digite 'Passagem' ou 'Nao possui'): ");
            String passagem = scanner.nextLine();
            if(passagem.equals("Nao possui")) {
                System.out.println("A recepção é nessa direção.");
                continue;
            }
            
            System.out.print("Data de nascimento na Passagem (DD/MM/AAAA): ");
            String dataPassagem = scanner.nextLine();
            
            if(!dataRG.equals(dataPassagem)) {
                System.out.println("190");
                continue;
            }
            
            System.out.print("Assento (Formato A12): ");
            String assento = scanner.nextLine();
            
            System.out.println("O seu assento é " + assento + ". Tenha um ótimo dia.");
        }
        
        scanner.close();
    }
}
