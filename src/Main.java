public class Main {
    static final int LIMITE_CACHE = 10;

    void main() {
        java.util.List<Pessoa> banco = new java.util.ArrayList<>();
        java.util.List<Pessoa> cache = new java.util.ArrayList<>();

        banco.add(new Pessoa(1, "Carlos", 25));
        banco.add(new Pessoa(2, "Pedro", 71));
        banco.add(new Pessoa(3, "Laraynny", 32));
        banco.add(new Pessoa(4, "Isabella", 19));
        banco.add(new Pessoa(5, "Nohana", 45));
        banco.add(new Pessoa(6, "Roberto" , 38));
        banco.add(new Pessoa(7, "Raiana", 35));
        banco.add(new Pessoa(8, "Beatriz" , 22));
        banco.add(new Pessoa(9, "Bruna", 21));
        banco.add(new Pessoa(10, "Adriano", 42));
        banco.add(new Pessoa(11, "Rafael", 39));
        banco.add(new Pessoa(12, "Gislene", 24));

        while (true) {
            int id = Integer.parseInt(IO.readln("Digite o ID da pessoa (0 para sair): "));

            if (id == 0) {
                break;
            }

            Pessoa pessoa = buscarPorId(cache, id);

            if (pessoa != null) {
                IO.println("Pessoa encontrada no cache: " + pessoa);
            } else {
                pessoa = buscarPorId(banco, id);

                if (pessoa != null) {
                    if (cache.size() == LIMITE_CACHE) {
                        cache.remove(0);
                    }
                    cache.add(pessoa);
                    IO.println("Pessoa buscada no banco e adicionada ao cache: " + pessoa);
                } else {
                    IO.println("Pessoa não encontrada.");
                }
            }
        }
    }

    static Pessoa buscarPorId(java.util.List<Pessoa> lista, int id) {
        for (Pessoa p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}