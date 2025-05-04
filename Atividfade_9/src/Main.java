import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {


 /*Sorteie 20 números de 0 a 100 de forma aleatória e vá inserindo esses números na árvore (exatamente na ordem em que esses são sorteados).
1) Faça a impressão desses números na tela usando a sequência de pré-ordem.
2) Faça a impressão desses números na tela usando a sequência de in-ordem.
3) Faça a impressão desses números na tela usando a sequência de pós-ordem.
4) Faça a impressão desses números na tela usando a sequência em nível.
Retire 5 elementos da árvore e refaça as impressões solicitadas.*/

        Arvore arvore = new Arvore();
        Random random = new Random();

        // Sorteando 20 números aleatórios entre 0 e 100
        Set<Integer> numerosSorteados = new HashSet<>();

        while (numerosSorteados.size() < 20) {
            int numero = random.nextInt(100);
            if (!numerosSorteados.contains(numero)) {
                numerosSorteados.add(numero);
                arvore.inserir(numero);
            }
        }

        JOptionPane.showMessageDialog(null, "Números sorteados: " + numerosSorteados);

        arvore.imprimirPreOrdem();
        JOptionPane.showMessageDialog(null, "Impressão em Pré-Ordem: "+ arvore.getResultados());
        arvore.imprimirEmOrdem();
        JOptionPane.showMessageDialog(null, "Impressão em Ordem: "+ arvore.getResultados());
        arvore.imprimirPosOrdem();
        JOptionPane.showMessageDialog(null, "Impressão em Pós-Ordem: "+ arvore.getResultados());
        arvore.imprimirNivelOrdem();
        JOptionPane.showMessageDialog(null, "Impressão em Nível: "+ arvore.getResultados());

        // Removendo 5 elementos aleatórios

        List<Integer> listaNumeros = new ArrayList<>(numerosSorteados);
        Collections.shuffle(listaNumeros);
        for (int i = 0; i < 5; i++) {
            arvore.removerChave(listaNumeros.get(i));
        }

        JOptionPane.showMessageDialog(null, "Removemos 5 números da árvore e o resultado foi o seguinte: " + listaNumeros.subList(5, listaNumeros.size()));

        arvore.imprimirPreOrdem();
        JOptionPane.showMessageDialog(null, "Impressão em Pré-Ordem: "+ arvore.getResultados());
        arvore.imprimirEmOrdem();
        JOptionPane.showMessageDialog(null, "Impressão em Ordem: "+ arvore.getResultados());
        arvore.imprimirPosOrdem();
        JOptionPane.showMessageDialog(null, "Impressão em Pós-Ordem: "+ arvore.getResultados());
        arvore.imprimirNivelOrdem();
        JOptionPane.showMessageDialog(null, "Impressão em Nível: "+ arvore.getResultados());
        JOptionPane.showMessageDialog(null, "Programa Finalizado!");



    }
}
