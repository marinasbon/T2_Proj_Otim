import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlgoritmoGuloso {

    public static List<Integer> escolherParadas(int L, int d, List<Integer> pontos) {

        Collections.sort(pontos);

        List<Integer> paradas = new ArrayList<>();
        int atual = 0;
        int indiceAtual = -1;

        while (atual + d < L) {
            int melhorIndice = -1;
            for (int i = indiceAtual + 1; i < pontos.size(); i++) {
                if (pontos.get(i) <= atual + d) {
                    melhorIndice = i;
                } else {
                    break;
                }
            }

            int pontoParada = pontos.get(melhorIndice);
            paradas.add(pontoParada);

            atual = pontoParada;
            indiceAtual = melhorIndice;
        }
        return paradas;
    }

    public static void main(String[] args) {

        int L = 950;
        int d = 200;

        List<Integer> pontos = new ArrayList<>();
        pontos.add(100);
        pontos.add(200);
        pontos.add(300);
        pontos.add(450);
        pontos.add(600);
        pontos.add(700);
        pontos.add(850);

        long inicio = System.nanoTime();
        List<Integer> paradasEscolhidas = escolherParadas(L, d, pontos);
        long fim = System.nanoTime();

        System.out.println("Pontos de parada escolhidos:");
        for (int p : paradasEscolhidas) {
            System.out.println(p + "Km");
        }
        System.out.printf("Tempo de execução: " + (fim - inicio) / 1e6);
    }
}
