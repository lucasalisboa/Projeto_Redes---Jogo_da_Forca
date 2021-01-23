# Projeto_Redes---Jogo_da_Forca
Projeto para a disciplina de Redes de Computadores, ministrada pelo professor Leandro Sales, implementado pela equipe composta por Lucas Albuquerque Lisboa (18110495) e José Rubens da Silva Brito (18110471).

#### Tecnologias Utilizadas
* JDK 11;
* Visual Code Studio 1.52.1;

#### Descrição do Projeto
Implementação de um jogo com temática da disciplina de Redes de Computadores, em que o usuário possui até 3 possibilidades de erro para tentar acertar a palavra correspondente. Esta implementação consistiu na utilização de threads, de tal forma que possibilitou a ocorrência simultânea de várias partidas.

O usuário deve fornecer como entrada apenas uma letra (sem acento). Caso seja submetido mais de uma letra, entrada vazia ou letra acentuada, o sistema retorna a mensagem “Entrada invalida”. Nos casos de entradas corretas, o sistema verifica se a letra faz parte da palavra. Caso não pertença, o sistema contabiliza um erro e retorna a mensagem “Letra incorreta”. Caso pertença, o sistema retorna a mensagem “Letra correta”.
   
Ao final de cada rodada, o sistema verifica se o jogo encerrou. Se houver 3 erros, o sistema retorna a palavra que deveria ter sido adivinhada, junto da mensagem “Que pena! Voce perdeu!”. Caso todas as letras já tenham sido acertadas, o sistema retorna a mensagem "Parabens! Voce ganhou!". Em ambas as situações, a aplicação do lado do cliente é encerrada.


#### Protocolos
Descrição | Cliente | Servidor
----------| --------| --------
Iniciar Conexão |`Socket socketNewClient = new Socket("localhost", 1234);`|`Socket connectionSocket = socketServer.accept();`
Enviar Letra | ```sentence =inFromUser.readLine();  outputServer.writeBytes(sentence + '\n'); ``` | ```readCliente = inFromGame.readLine();  readCliente = readCliente.toLowerCase();```
Retornar Estado Atual da Palavra | `System.out.println(inFromServer.readLine());` | ```for (int i = 0 ; i <gameSentence.length();i++){  outToGame.writeUTF(letters.get(i) + " ");}  outToGame.writeByte('\n');```
Retornar Resultado | ```msg =inFromServer.readLine(); System.out.println(msg); if(msg.equals("Parabens! Voce ganhou!") \|\| msg.equals("Que pena! Voce perdeu!")){ break;}``` | ```String msg; if(count_lifes < 3) { msg = "Parabens! Voce ganhou!"; } else{ outToGame.writeBytes("Palavra era:"+gameSentence+'\n'); msg = "Que pena! Voce perdeu!";}  outToGame.writeBytes(msg + '\n');```
Encerrar Conexão | ```inFromServer.close(); outputServer.close(); inFromUser.close(); socketNewClient.close(); ``` | ```inFromGame.close(); outToGame.close();```

#### Setup
1. Possuir o pacote JDK 11 instalado na Máquina;
2. Realizar o download da aplicação (`git clone https://github.com/lucasalisboa/Projeto_Redes---Jogo_da_Forca.git`)
3. Após realizar o download, rodar primeiro a classe Server.java e logo em seguida rodar a classe Cliente.java, pode executar mais de uma vez simultaneamente a classe Ciente.java;
4. Iniciar o jogo.

#### Implementações Futuras
* Interface Gráfica;
* Ampliar banco de palavras selecionadas, de forma inteligente.

#### Dificuldades na Implementação
* Organizar dentro de um laço o envio de informações, a ponto de ficar equivalente ao lado do receptor da mensagem (que deverá ter um leitor equivalente para recebê-la).
