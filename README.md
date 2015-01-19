PROBLEMA
========
Dado o seguinte log de um jogo de tiro em primeira pessoa:

23/04/2013 15:34:22 - New match 11348965 has started  
23/04/2013 15:36:04 - Roman killed Nick using M16  
23/04/2013 15:36:33 - &lt;WORLD&gt; killed Nick by DROWN  
23/04/2013 15:39:22 - Match 11348965 has ended  

Resultado esperado
------------------
* A partir de um input de um arquivo de log do formato acima, montar o ranking de cada partida, com a quantidade assassinatos e a quantidade de mortes de cada jogador;

Observações
------------
* Assassinatos realizados pelo &lt;WORLD&gt; devem ser desconsiderados, no entanto, as mortes causadas pelo &lt;WORLD&gt; devem ser consideradas para o jogador que foi morto.


Bônus
-----
Não obrigatório. Faça apenas caso se identifique com o problema ou se achar que há algo interessante a ser mostrado na solução
* Descobrir a arma preferida (a que mais matou) do vencedor;
* Identificar a maior sequência de assassinatos efetuadas por um jogador (streak) sem morrer, dentro da partida;
* Jogadores que vencerem uma partida sem morrerem devem ganhar um "award";
* Jogadores que matarem 5 vezes em 1 minuto devem ganhar um "award".


SOLUÇÃO
=======
* Seja criativo;
* Explore ao máximo a orientação a objetos;
* Crie testes unitários e tente usar TDD;
* Não é necessário utilizar nenhum framework, mas fica ao seu critério;
* Caso você tenha baixado o arquivo zip, o projeto já contém um repositório git inicializado. Se você nunca usou git desconsidere isso. 

ENTREGA
=======
* Faça um fork do nosso repositório, nos envie a url do seu repositório com a solução;
* Utilize o arquivo SUAS-INSTRUÇÕES.txt para adicionar algum comentário/observação que achar importante.
