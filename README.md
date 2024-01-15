# Aplicação para agendar transferências financeiras

Um sistema de agendamento de transferências financeiras simplificado, implementado por meio de uma API REST utilizando Java com Spring Boot. Esse sistema é consumido no front-end por meio do Angular.

##### Back-end (Pasta schedule-backend)
##### Front-end (Pasta schedule-frontend)

## Decisões arquiteturais

Optei pela *Arquitetura em Camadas* no back-end, utilizando controller, domain, dto, repository e service. Essa escolha é familiar em projetos Spring e também nos meus projetos, proporcionando organização e facilidade na manutenção.

Para o banco de dados utilizei o banco em memória H2 Database.

No front-end, adotei a *Arquitetura baseada em componentes*, seguindo o padrão de projetos Angular. Essa abordagem simplifica o desenvolvimento, facilita a reutilização de código e proporciona uma organização eficiente dos elementos da interface.

## Tecnologias, linguagens & frameworks

 ### Navegadores:

- Google Chrome 120.0.6099.217;
- Opera GX 105.0.4970.76.

 ### Front-end:
 
- Angular 17.0.9;
- Node 20.11.0;
- Bootstrap 5.3.2;
- Npm 10.2.4.

 ### Back-end:
 
- Java 17;
- Spring boot 3.2.1;
- Maven 3.9.5;
- H2 Database.

 #### Dependências:

- Spring web: Para desenvolver a API REST;
- Spring Data JPA: Para a persistência dos dados;
- Spring tools: Para ajudar no desenvolvimento (restart, live reload);
- Lombok: Para gerar os códigos "boilerplate" (getters e setters);
- H2 Database: Banco de dados em memória.


## Ferramentas

- Para desenvolver o front-end foi utilizado o Visual Studio Code 1.85.1;
- Para gerar a estrutura inicial do back-end foi utilizado o Spring Initializr;
- Para desenvolver o back-end foi utilizado o IntelliJ IDEA Community Edition 2023.2.3;
- Para executar os testes de endpoints foi utilizado o Postman 10.22.1.

 ## Execução
 
 #### Back-End
 
 Abra a pasta "schedule-backend" através do IntelliJ IDEA Community Edition depois clique na classe "ScheduleBackendApplication" clique com o botão direito e selecione a opção "Run", dessa forma a API deverá inicializar.

 #### Banco de dados

 Após o back-end ser executado, acesse http://localhost:8080/h2-console, com usuário: admin e senha: admin.

 #### Front-End
 
 No CMD/Terminal navegue até a pasta "schedule-frontend" dentro dela execute o comando "*ng serve*", após o build a aplicação estará visível no endpoint http://localhost:4200/.

 #### Testes

 Para ter uma melhor experiência é necessário testar o back-end juntamente com o front-end, por conta das validações de campo, porém caso queira testar somente o back-end, segue um exemplo de URL + body:

 Cadastrar uma transferência:
 
 http://localhost:8080/financial-transfer

        {
        "originAccount": "123456",

        "destinationAccount": "654321",

        "transferAmount": 10000,

        "transferDate": "2024-03-14T15:30:00"

        }

Buscar todas as transferências:
    
http://localhost:8080/financial-transfer

## Melhorias futuras
 
- Testes unitários;
- Sistema de login;
- Criar usuários com contas bancárias;
- Checagem de saldo bancário;
- Swagger.



 
