# Projeto Final Bootcamp It Experts





# Project:

You must implement a simple bank account web API. Account have (Id, agency, bankAccount, verificationDigital, Cards). The Cards must also be managed by Bank Account. have (id, name, typeOfCard, flag, number, code, limitBalance, nameOwner).

\- *You must implement Create, Read and Delete. (Update is not necessary due to time constraints for this implementation)*

\- *Account:*

\- *id: (generated automatically. Integer and incremental)*

\- *nameOwner: chars field max size 50*

\- *agencyCode: chars field max size 4*

\- *accountCode: chars field max size 8*

\- *verificationDigital: chars field max size 1*

\- *Cards: from all Cards available in currency bank account.*

\- *Cards:*

\- *Id: (generated automatically, integer and incremental)*

\- *name: Must not be empty. All cards must have a name of Card. Max size 128 chars.*

\- *flag: (Mastercard, Visa, Elo) – you can create a Enum if you prefer.*

\- *typeCard: from Type entity available.*

\- *number: chars minimun size and max size 20 chars (9999.9999. 9999.9999)*

\- *digitCode: chars field max size 5*

\- *limitBalance: double value max size 20*

\- *Type:*

\- *Id: (generated automatically, integer and incremental)*

\- *name: kind of cards: (DEBIT_CARD, CREDIT_CARD, MEAL_CARD, GIFT_CARD ...)*

 

***- All fields are mandatory\*** *(You need validate them,*

Example: if data Account not send nameOwner in create Account, you need to return that

“nameOwner is mandatory” is the same for the others fields).

\- *The APP must list all Account and Cards related, we need to create new Bank Account together with Card, and delete Cards, not is possible delete Bank Account if have some Card associated with Bank Account.*

·        *Backend must be implemented in Java (version 11 or above).*

·        *Application must be built using Spring Boot*

·        *It is necessary to use Swagger API Documentation*

·        *Account and Card MUST be persisted on a MySQL database.*

·        *You must provide the script (SQL or any database versioning/migration script) that can create the database from scratch.*

.    You need to use Maven or Gradle to management dependencies in the project.

·        *Use GIT, commit every progress you made, and share your cond on a github public repository.*



# Super challenge:

\- Swagger Api Doc (Account, Card,Type),

\- Create Updates (Cards change into Account, Type into Card, just Type),

\- Exceptions Errors if you try to delete Type if have some Cards associated.

\- *Deploy your project on a cloud provider (AWS), use the service **AWS Code Pipeline** (CI/CD), and*

***send the URL of your web application, and the URL of your GIT repo.\***

\- *Our recommendation is to sign up on AWS for a free account and use:*

\- *One T2 micro EC2 instance (for backend) – FREE TIER*

\- *One RDS T2 micro instance (for database) – FREE TIER*

\- *In case the project could not be deployed, it must be ready to run and install on a Ubuntu 18 linux machine. The evaluation process would be:*

\- *Clone the repo. (create the local database based on the script given). Run back end locally.*

 

 

API Database Model:

<img src="Diagrama MySQL.png">

<h3>Tecnologias utilizadas:</h3>

- Java 11
- Spring DevTools
- Spring Web
- Spring Data JPA
- MySQL Connector Java
- Spring Validation
- Banco de Dados MySQL
- Swagger
- RDS rodando banco de dados MySQL - AWS
- Deploy - AWS Elastic Beanstalk
- CI / CD - AWS CodePipeline

- Endpoints
  - [POST] /api/v1/clientes
  - [GET] /api/v1/clientes
  - [GET] /api/v1/clientes/{id}
  - [POST] /api/v1/clientes/{cliente_id}/enderecos
  - [GET] /api/v1/clientes/{cliente_id}/enderecos
  - [GET] /api/v1/clientes/{cliente_id}/enderecos/{id}
  - [POST] /api/v1/clientes/{cliente_id}/documentos
  - [GET] /api/v1/clientes/{cliente_id}/documentos
  - [GET] /api/v1/clientes/{cliente_id}/documentos/{id}





Link para aplicação na AWS

http://projetofinalitexperts-env.eba-xpydwu74.us-east-1.elasticbeanstalk.com/swagger-ui.html#/
