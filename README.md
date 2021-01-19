# Projeto_Redes---Jogo_da_Forca
Projeto para a disciplina de Redes de Computadores, ministrada pelo professor Leandro Sales, implementado pela equipe composta por Lucas Albuquerque Lisboa (18110495) e José Rubens da Silva Brito (18110471).

#### Tecnologias Utilizadas
* JDK 11;
* Visual Code Studio 1.52.1;

#### Descrição do Projeto
Implementação de um jogo com temática da disciplina de Redes de Computadores, em que o usuário possui até 3 possibilidades de erro para tentar acertar a palavra correspondente. Esta implementação consistiu na utilização de threads, de tal forma que possibilitou a ocorrência simultânea de várias partidas.

#### Protocolos
Descrição | Cliente | Servidor
----------| --------| --------
Iniciar Conexão |`Socket socketNewClient = new Socket("localhost", 1234);`|`Socket connectionSocket = socketServer.accept();`
Enviar Letra | ```sentence =inFromUser.readLine();outputServer.writeBytes(sentence + '\n'); ``` | ```readCliente = inFromGame.readLine(); readCliente = readCliente.toLowerCase();```
