
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Arvore {

    public No raiz;
    private List<Integer> resultados;

    Arvore() {
        raiz = null;
        resultados = new ArrayList<>();
    }

    public void inserir(int dado) {
        raiz = inserirRec(raiz, dado);
    }

    public No inserirRec(No raiz, int dado) {
        if (raiz == null) {
            raiz = new No(dado);
            return raiz;
        }

        if (dado < raiz.dado)
            raiz.esquerdo = inserirRec(raiz.esquerdo, dado);
        else if (dado > raiz.dado)
            raiz.direito = inserirRec(raiz.direito, dado);

        return raiz;
    }

    public void removerChave(int dado) {
        raiz = removerRec(raiz, dado);
    }

    public int valorMinimo(No raiz) {
        int minv = raiz.dado;
        while (raiz.esquerdo != null) {
            minv = raiz.esquerdo.dado;
            raiz = raiz.esquerdo;
        }
        return minv;
    }

    public No removerRec(No raiz, int dado) {
        if (raiz == null) return raiz;

        if (dado < raiz.dado)
            raiz.esquerdo = removerRec(raiz.esquerdo, dado);
        else if (dado > raiz.dado)
            raiz.direito = removerRec(raiz.direito, dado);
        else {
            if (raiz.esquerdo == null)
                return raiz.direito;
            else if (raiz.direito == null)
                return raiz.esquerdo;

            raiz.dado = valorMinimo(raiz.direito);
            raiz.direito = removerRec(raiz.direito, raiz.dado);
        }

        return raiz;
    }

    public List<Integer> getResultados() {
        return resultados;
    }

    public void limparResultados() {
        resultados.clear();
    }

    public void imprimirPreOrdem() {
        limparResultados();
        imprimirPreOrdemRec(raiz);
    }

    public void imprimirPreOrdemRec(No raiz) {
        if (raiz != null) {
            resultados.add(raiz.dado);
            imprimirPreOrdemRec(raiz.esquerdo);
            imprimirPreOrdemRec(raiz.direito);
        }

    }

    public void imprimirEmOrdem() {
        limparResultados();
        imprimirEmOrdemRec(raiz);
    }

    public void imprimirEmOrdemRec(No raiz) {
        if (raiz != null) {
            imprimirEmOrdemRec(raiz.esquerdo);
            resultados.add(raiz.dado);
            imprimirEmOrdemRec(raiz.direito);
        }
    }

    public void imprimirPosOrdem() {
        limparResultados();
        imprimirPosOrdemRec(raiz);
    }

    public void imprimirPosOrdemRec(No raiz) {
        if (raiz != null) {
            imprimirPosOrdemRec(raiz.esquerdo);
            imprimirPosOrdemRec(raiz.direito);
            resultados.add(raiz.dado);
        }
    }

    public void imprimirNivelOrdem() {
        limparResultados();
        if (raiz == null) return;

        Queue<No> queue = new LinkedList<>();
        queue.add(raiz);

        while (!queue.isEmpty()) {
            No temp = queue.poll();
            resultados.add(temp.dado);

            if (temp.esquerdo != null) queue.add(temp.esquerdo);
            if (temp.direito != null) queue.add(temp.direito);
        }
    }
}