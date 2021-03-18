# Abreviações
Blogs são muito populares hoje em dia, e há inclusive ferramentas que te permitem manter o seu blog sem que você pague nada por isso. Rafael resolveu então criar um blog, onde irá arquivar todas as suas experiências diárias de sua vida agitada.

Por mais que estas ferramentas sejam gratuitas, há porém um limite de caracteres que se pode escrever por dia, e Rafael está preocupado que essa limitação o irá impedir de contar suas melhores experiências. Decidiu então usar um sistema de abreviação de palavras em seus posts.

O sistema de abreviações funciona da seguinte maneira: para cada letra, é possível escolher uma palavra que inicia com tal letra e que aparece no post. Uma vez escolhida a palavra, sempre que ela aparecer no post, ela será substituída por sua letra inicial e um ponto, diminuindo assim o número de caracteres impressos na tela.

Por exemplo, na frase: “hoje eu visitei meus pais”, podemos escolher a palavra “visitei” para representar a letra 'v', e a frase ficará assim: “hoje eu v. meus pais”, economizando assim cinco caracteres. Uma mesma palavra pode aparecer mais de uma vez no texto, e será abreviada todas as vezes. Note que, se após uma abreviação o número de caracteres não diminuir, ela não deve ser usada, tal como no caso da palavra “eu” acima.

Rafael precisa que seu post tenha o menor número de caracteres possíveis, e por isso pediu a sua ajuda. Para cada letra escolha uma palavra, de modo que ao serem aplicadas todas as abreviações, o texto contenha o menor número de caracteres possíveis.

# Entrada
Haverá diversos casos de teste. Cada caso de teste é composto de uma linha, contendo uma frase de até 10⁴ caracteres. A frase é composta de palavras e espaços em branco, e cada palavra é composta de letras minúsculas ('a'-'z'), e contém entre 1 e 30 caracteres cada.

O último caso de teste é indicado quando a linha dada conter apenas um “.”, o qual não deverá ser processado.

# Saída
Para cada caso de teste, imprima uma linha contendo a frase já com as abreviações escolhidas e aplicadas.

Em seguida, imprima um inteiro N, indicando o número de palavras em que foram escolhidas uma letra para a abreviação no texto. Nas próximas N linhas, imprima o seguinte padrão “C. = P”, onde C é a letra inicial e P é a palavra escolhida para tal letra. As linhas devem ser impressas em ordem crescente da letra inicial.
