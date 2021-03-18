//     *Desafio
//        Blogs são muito populares hoje em dia, e há inclusive ferramentas que te permitem manter o seu blog sem que
//        você pague nada por isso. Rafael resolveu então criar um blog, onde irá arquivar todas as suas experiências
//        diárias de sua vida agitada.
//
//        Por mais que estas ferramentas sejam gratuitas, há porém um limite de caracteres que se pode escrever por dia,
//        e Rafael está preocupado que essa limitação o irá impedir de contar suas melhores experiências. Decidiu então
//        usar um sistema de abreviação de palavras em seus posts.
//
//        O sistema de abreviações funciona da seguinte maneira: para cada letra, é possível escolher uma palavra que
//        inicia com tal letra e que aparece no post. Uma vez escolhida a palavra, sempre que ela aparecer no post, ela
//        será substituída por sua letra inicial e um ponto, diminuindo assim o número de caracteres impressos na tela.
//
//        Por exemplo, na frase: “hoje eu visitei meus pais”, podemos escolher a palavra “visitei” para representar a
//        letra 'v', e a frase ficará assim: “hoje eu v. meus pais”, economizando assim cinco caracteres. Uma mesma
//        palavra pode aparecer mais de uma vez no texto, e será abreviada todas as vezes. Note que, se após uma
//        abreviação o número de caracteres não diminuir, ela não deve ser usada, tal como no caso da palavra “eu” acima.
//
//        Rafael precisa que seu post tenha o menor número de caracteres possíveis, e por isso pediu a sua ajuda.
//        Para cada letra escolha uma palavra, de modo que ao serem aplicadas todas as abreviações, o texto contenha o
//        menor número de caracteres possíveis.
//
//     *Entrada
//        Haverá diversos casos de teste. Cada caso de teste é composto de uma linha, contendo uma frase de até 10⁴
//        caracteres. A frase é composta de palavras e espaços em branco, e cada palavra é composta de letras minúsculas
//        ('a'-'z'), e contém entre 1 e 30 caracteres cada.
//
//        O último caso de teste é indicado quando a linha dada conter apenas um “.”, o qual não deverá ser processado.
//
//     *Saída
//        Para cada caso de teste, imprima uma linha contendo a frase já com as abreviações escolhidas e aplicadas.
//
//        Em seguida, imprima um inteiro N, indicando o número de palavras em que foram escolhidas uma letra para a
//        abreviação no texto. Nas próximas N linhas, imprima o seguinte padrão “C. = P”, onde C é a letra inicial e P
//        é a palavra escolhida para tal letra. As linhas devem ser impressas em ordem crescente da letra inicial.

package abreviando2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class abreviando2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> listaPalavras;
        String frase;
        Frase palavras;

        while (true) {
            frase = br.readLine();

            if(frase.contains(".")) {
                break;
            }

            listaPalavras = Arrays.asList(frase.split(" "));
            palavras = new Frase(listaPalavras);
            palavras.definePalavrasAbreviadas();
        }
    }

    public static class Frase {
        final private ConcurrentHashMap<String, Integer> mapaPalavrasIguais = new ConcurrentHashMap<>();
        final private HashMap<Character, HashSet<String>> mapaLetrasIguais = new HashMap<>();
        final private HashMap<Character, String> mapaCaracter = new HashMap<>();
        final private HashMap<Character, Integer> mapaSoma = new HashMap<>();
        final private HashMap<String, Integer> palavras = new HashMap<>();
        final private List<String> fraseAbreviada = new ArrayList<>();
        final private TreeMap<String, String> armz = new TreeMap<>();
        final private List<String> frase;
        private int count = 0;

        public Frase(List<String> frase) {
            this.frase = frase;
        }


        public void definePalavrasAbreviadas() {
            for (String a : frase) {
                mapaPalavrasIguais.put(a, 0);
                if (!mapaLetrasIguais.containsKey(a.charAt(0))) {
                    HashSet<String> x = new HashSet<>();
                    mapaLetrasIguais.put(a.charAt(0), x);
                }
                mapaLetrasIguais.get(a.charAt(0)).add(a);

                if (!mapaCaracter.containsKey(a.charAt(0))) {
                    mapaCaracter.put(a.charAt(0), a);
                } else if (mapaCaracter.containsKey(a.charAt(0))) {
                    if (a.length() > mapaCaracter.get(a.charAt(0)).length()) {
                        mapaCaracter.put(a.charAt(0), a);
                    }
                }

                /*Inicializa*/
                mapaSoma.put(a.charAt(0), 0);
                if (palavras.containsKey(a)) {
                    palavras.put(a, palavras.get(a) + a.length());
                } else {
                    palavras.put(a, a.length());
                }
            }

            /*Otimiza*/
            for (Map.Entry<String, Integer> z : mapaPalavrasIguais.entrySet()) {
                if (z.getKey().length() == z.getValue()) {
                    mapaPalavrasIguais.remove(z.getKey());
                }
            }

            /*defineMelhorValorParaAbreviar*/

            int somaCaracter = 0;

            for (Map.Entry<String, Integer> m : mapaPalavrasIguais.entrySet()) {
                for (String n : mapaLetrasIguais.get(m.getKey().charAt(0))) {
                    somaCaracter += (palavras.get(n) / n.length() * 2);

                    for (String z : mapaLetrasIguais.get(m.getKey().charAt(0))) {
                        if (!z.equals(n)) {
                            somaCaracter += palavras.get(z);
                        }
                    }

                    if (somaCaracter < mapaSoma.get(n.charAt(0)) || mapaSoma.get(n.charAt(0)) == 0) {
                        mapaCaracter.put(n.charAt(0), n);
                        mapaSoma.put(n.charAt(0), somaCaracter);
                    }
                    somaCaracter = 0;
                }
            }

            /*Abrevia*/
            for (String palavra : frase) {
                if (palavra.equals(mapaCaracter.get(palavra.charAt(0))) && palavra.length() > 2) {
                    fraseAbreviada.add(palavra.charAt(0) + ".");
                    armz.put(palavra.charAt(0) + ".", palavra);
                } else {
                    fraseAbreviada.add(palavra);
                }
            }

            /*Obtem frase abreviada*/
            for (int i = 0; i < fraseAbreviada.size(); i++) {
                if (i < fraseAbreviada.size() - 1) {
                    System.out.print(fraseAbreviada.get(i) + " ");
                } else {
                    System.out.print(fraseAbreviada.get(i));
                }

            }

            System.out.println();

            /*Obtem numero de substituições*/
            for (int i = 0; i < armz.size(); i++) {
                count++;
            }
            System.out.println(count);

            /*Legenda*/
            for (Map.Entry<String, String> n : armz.entrySet()) {
                System.out.println(n.getKey() + " = " + n.getValue());
            }
        }
    }
}