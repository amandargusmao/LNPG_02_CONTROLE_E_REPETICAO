import java.util.*;

class Participante implements Comparable<Participante> {
    String nome;
    int nota;

    Participante(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }

    @Override
    public int compareTo(Participante outro) {
        return this.nome.compareTo(outro.nome);
    }
}

public class vestibular {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> gabarito = new ArrayList<>();
        List<Participante> participantes = new ArrayList<>();

        System.out.println("Digite o gabarito da prova, consistindo em 10 inteiros (1-5), um por linha:");
        for (int i = 0; i < 10; i++) {
            gabarito.add(scanner.nextInt());
        }

        System.out.println("Digite o nome do participante seguido por suas 10 respostas (1-5), um por linha. Digite '*' para terminar a entrada:");
        while (scanner.hasNext()) {
            String nome = scanner.next();
            if (nome.equals("*")) break;

            int nota = 0;
            for (int i = 0; i < 10; i++) {
                int resposta = scanner.nextInt();
                if (resposta == gabarito.get(i)) nota++;
            }
            participantes.add(new Participante(nome, nota));
        }

        Collections.sort(participantes);
        
        System.out.println("\nParticipantes e suas notas em ordem alfabética:");
        participantes.forEach(p -> System.out.println(p.nome + " " + p.nota));

        int maiorNota = participantes.stream().max(Comparator.comparingInt(p -> p.nota)).get().nota;
        int menorNota = participantes.stream().min(Comparator.comparingInt(p -> p.nota)).get().nota;

        System.out.println("\nMaior pontuação: " + maiorNota);
        participantes.stream().filter(p -> p.nota == maiorNota).forEach(p -> System.out.println(p.nome));

        System.out.println("\nMenor pontuação: " + menorNota);
        participantes.stream().filter(p -> p.nota == menorNota).forEach(p -> System.out.println(p.nome));

        long acimaDaMetade = participantes.stream().filter(p -> p.nota > 5).count();
        double percentualAcimaDaMetade = 100.0 * acimaDaMetade / participantes.size();
        System.out.printf("\nPercentual com mais da metade das questões certas: %.1f%%\n", percentualAcimaDaMetade);
    }
}
