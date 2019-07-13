# Producer-Consumer
Trabalho 2 de Sistemas Operacionais

Pretende-se construir uma aplicação Java em que threads *Producers* enviam mensagens para threads
*Consumers*. As mensagens são colocadas em 4 filas, cada uma associada a um nível de prioridade
de 0 a 3, em que 0 é a mais prioritária (podíamos considerar mensagens com quatro níveis de
urgência). As filas de mensagens têm espaço para 3 mensagens cada.

Quando um *Producer* pretende escrever a mensagem e a respectiva fila está cheia, fica bloqueado.
Um processo *Consumer* retira sempre a mensagem da fila mais prioritária. Se não houver
nenhuma mensagem (em nenhuma das filas), ele fica bloqueado.

*Producers* produzem mensagens a cada *x* segundos (*x* é um valor aleatório entre 1 e 5). 
A prioridade da mensagem também é definida de forma aleatória.
*Consumers*, após consumirem uma mensagem, esperaram um tempo aleatório (entre 1 e 5 seg.)
para tentar consumir uma nova mensagem.

O programa imprime informações na saída padrão, sempre que:
  - uma mensagem for produzida ou consumida, identificando: a mensagem, sua prioridade e
  a thread que a produziu ou consumiu;
  - uma thread for bloqueada ou desbloqueada.
  
Qualquer mecanismo de sincronização foi implementado com base nos monitores Java.
