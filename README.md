# votacao
Serviço de votação em pautas por associados.

#### Resumo dos Itens que serão analisados:
- Foi utilizado uma simple clean architecture na organização das classes proporcionando 
maior granularidade e também clean code no desenvolvimento, foi tomada a decisão de encapsular 
as regras de negocio as classes responsáveis por cada uma delas.

#### Tecnologias utilizadas:
- Projeto _Java 17_ utilizando o framework _SpringBoot_ e também o _Maven_ para gerenciamento do 
mesmo. 
- Utilização do _OpenFeing_ para a chamada externa de validação de aptidão de voto de associado **(Tarefa Bônus 1)**;
- Utilização do _Kafka_ como fila de mensageria para envio de resultado da votação também disponibilizando 
do _Zookeeper_ que é a ferramenta que gerencia o estado dos cluster **(Tarefa Bônus 2)**;
- Para o versionamento da API foi utilizado o modelo de versionamento _"path/URI"_ **(Tarefa Bônus 4)**;
- Conteinerização utilizando o _Docker_ do _Banco de dados PostgreeSQL, Kafka e Zookeeper_;
- Utilização do _TimerTask e Timer_ para o fechamento da sessão de pauta na data e horário estipulado ou por
padrão em 1 minuto;
- Foram criados testes unitários com: _JUnit_ disponibilizando do framework _Mockito_;
- Utilização de _Swagger_ e _OpenApi_ na documentação do projeto.
- Utilização do _Lombok_ para a abstração de métodos assessores deixando o código mais limpo.

#### Observações importantes:
- Na classe Main (VotacaoApplication.java) foi criado um Consumer onde é logada a mensagem recebida.
- O endpoint de criação de associado: https://user-info.herokuapp.com/users/{cpf} estava fora retornando
 um: _Heroku | Application Error_, por tanto todas as decisões e tratamentos da requisição 
externa no endpoint foram simuladas.

## Instruções para teste

###### Subir o container docker:
```
docker compose up -d
```
###### Rodar a classe main da aplicação:
```
VotacaoApplication.java
```
#### A aplicação rodará na porta localhost:8080

#### Endpoints:

###### Collection do Postman:
###### No Postman selecionar: import -> link -> colar a URL
https://api.postman.com/collections/11243426-bd87c100-923c-4cab-9200-b04ed34ec039?access_key=PMAT-01GQZJ9E7N7EGBYH157GA0H79N

#### OU

###### Criação de nova pauta:
```
POST - /v1/pauta/nova?nome={nome}
```
###### Abertura de sessão de uma pauta:
```
PUT - /v1/pauta/abre-sessao?id={pauta_id}&data_expiracao={dd/MM/aaaa hh:MM:ss}
```
###### Criação de novo associado:
```
POST - /v1/associado/novo?cpf={cpf}
```
###### Criação de novo voto:
```
POST - /v1/voto/novo?associado_id={associado_id}&voto={SIM/NAO}&pauta_id={pauta_id}
```
###### Documentação

###### OpenAPI:
```
GET - http://localhost:8080/v1/api-docs
```
###### Swagger:
```
WEB - http://localhost:8080/v1/swagger-ui.html
```