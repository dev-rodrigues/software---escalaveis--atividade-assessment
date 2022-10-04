# Atividade

Esta aplicação foi construida utilizando a linguagem Java na versão 17 e o framework Spring Boot na versão 2.5.4.

## Como executar
Dentro desse repositório existe um arquivo chamado script.sh, esse arquivo é responsável por executar a aplicação. Para executar o script basta executar o seguinte comando:

```bash
sudo ./script.sh
```

## Como testar
O script irá executar 3 aplicações.
- A primeira aplicação é o RabbitMQ, que é responsável por gerenciar as filas de mensagens.
- A segunda aplicação é o Producer, que é responsável por enviar as mensagens para a fila.
- A terceira aplicação é o Consumer/Producer, que é responsável por consumir as mensagens da fila.

A *aplicação atividade*  está sendo executada na porta 8080, para testar, basta abrir a seguinte URL no navegador:

```bash
http://localhost:8080/swagger-ui/index.html
```

A *segunda aplicação* está sendo executada na porta 3334, para testar, basta abrir a seguinte URL no navegador:
http://localhost:3334/swagger-ui/index.html
```bash

