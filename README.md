# API Rest da empresa fictícia Investix

Este projeto é uma API Rest desenvolvida em Java utilizando o Spring Boot. A API tem como objetivo gerenciar os dados de investidores, assessores financeiros e agendamentos de reuniões da empresa fictícia Investix. 

## Funcionalidades

- Cadastro de investidores e assessores.
- Agendar reuniões de potenciais investidores com assessores por especialidade do profissional.
- Cancelar ou remarcar reuniões entre investidores e assessores.
- Atualização de dados de investidores e assessores.
- Inativação ou exclusão de investidores e assessores.

## Regras de Negócio

- A reunião somente pode ser cancelada com antecedência mínima de 1 hora.
- A especialidade do assessor financeiro é obrigatória. Quando o assessor não for escolhido, selecionamos um disponível de forma aleatória naquela especialidade.
- A reunião deve ser agendada com antecedência mínima de 30 minutos.
- A reunião deve ser agendada apenas no horário de funcionamento do escritório (segunda a sábado, entre 8h e 18h).
- A reunião não pode ser agendada com um assessor financeiro inativo no sistema.
- A reunião não pode ser agendada no mesmo horário com o mesmo assessor.
- A reunião não pode ser agendada para um investidor excluído.

## Dependências

Este projeto utiliza as seguintes dependências:

- **Spring Boot Starter Web**: Para criação de endpoints RESTful.
- **Lombok**: Para reduzir o boilerplate de código, como getters, setters e construtores.
- **Spring Boot Starter Data JPA**: Para integração com o banco de dados utilizando JPA/Hibernate.
- **Spring Boot Starter Validation**: Para validação de dados de entrada.
- **Banco de dados H2**: Banco de dados em memória.

## Requisitos

- Java 17
- Maven 3.6+

## Configuração do Banco de Dados

Certifique-se de configurar o banco de dados H2 no arquivo `application-dev.properties` da seguinte forma:

src/main/resources/application-dev.properties

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```


## Executando a Aplicação

Para executar a aplicação, utilize o seguinte comando Maven:

```bash
mvn spring-boot:run
```

## Estrutura do Projeto

- `src/main/java`: Contém o código fonte da aplicação.
- `src/main/resources`: Contém os arquivos de configuração e scripts de migração do banco de dados.

## Endpoints

Abaixo estão os principais endpoints da API:

### Cadastrar Investidor

- **URL**: `/api/investidores`
- **Método**: `POST`
- **Corpo da Requisição**:

```json
{ 
    "nome": "Investidor Silva",
    "email": "investidorsilva01@example.com",
    "cpf": "12188883003",
    "telefone": "1198769961"
}
```


### Consultar Investidores

- **URL**: `/api/investidores`
- **Método**: `GET`

### Consultar Investidores por ID

- **URL**: `/api/investidores/{id}`
- **Método**: `GET`

### Atualizar Cadastro Investidor

- **URL**: `/api/investidores/{id}`
- **Método**: `PUT`
- **Corpo da Requisição**:
```json
{
    "nome": "Investidor Silva",
    "email": "investidorsilva01@example.com",
    "cpf": "12188883003",
    "telefone": "1198769961"
}
```

### Excluir Cadastro Investidor

- **URL**: `/api/investidores/{id}`
- **Método**: `DELETE`


### Cadastrar Assessores Financeiros

- **URL**: `/api/assessores`
- **Método**: `POST`
- **Corpo da Requisição**:
```json
{
    "nome": "Assessor Silva",
    "email": "assessor01@example.com",
    "telefone": "19999999999",
    "aaiRegister": "12345",
    "especialidade": "INSTITUCIONAL"
}
```

### Consultar Assessores Financeiros

- **URL**: `/api/assessores`
- **Método**: `GET`

### Consultar Assessores Financeiros por ID

- **URL**: `/api/assessores/{id}`
- **Método**: `GET`

### Atualizar Cadastro Assessor

- **URL**: `/api/assessores/{id}`
- **Método**: `PUT`
- **Corpo da Requisição**:
```json
{
    "nome": "Assessor Silva",
    "email": "assessor01@example.com",
    "telefone": "19999999999",
    "aaiRegister": "12345",
    "especialidade": "INSTITUCIONAL"
}
```

### Excluir Cadastro Assessor

- **URL**: `/api/assessores/{id}`
- **Método**: `DELETE`


### Agendar Reuniao entre as partes

- **URL**: `/api/reunioes`
- **Método**: `POST`
- **Corpo da Requisição**:
```json
{
	"idInvestidor": 1,
	"idAssessor": 1,
	"especialidade": "INSTITUCIONAL",
	"data": "2024-10-22T15:00"
}
```
### Cancelar Reuniao entre as partes

- **URL**: `/api/reunioes`
- **Método**: `PUT`
- **Corpo da Requisição**:
```json
{
	"id": 1,
	"motivo": "OUTROS"
}
```

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Desenvolvedor

- Marcus Ungarette

## Contato

Para mais informações, entre em contato com [marcusungarette@gmail.com](mailto:marcusungarette@gmail.com).



