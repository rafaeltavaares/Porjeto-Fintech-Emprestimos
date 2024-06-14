# Projeto - API para Simulação de Empréstimos Financeiros

## Descrição do Projeto

Este projeto foi desenvolvido como parte de um desafio de código proposto pela CréditoExpress. O objetivo do desafio é criar uma API para simular empréstimos financeiros. O projeto foi totalmente construído em Java utilizando o framework Spring Boot, juntamente com diversas bibliotecas que auxiliaram no desenvolvimento.

## Tecnologias Utilizadas

### Linguagem de Programação
- **Java**

### Framework
- **Spring Boot**

### Bibliotecas
- **Lombok**: Utilizada para reduzir o código boilerplate, gerando automaticamente getters, setters, construtores, entre outros, durante o runtime. Isso torna o código mais limpo e de fácil entendimento.
- **H2 Database**: Utilizada para configurar um banco de dados em memória, facilitando o desenvolvimento e testes do projeto.
- **Spring Web**: Fundamental para a criação e implementação da API REST do projeto.
- **Hibernate Validation**: Necessária para a implementação de validações no código, garantindo a integridade dos dados.

### Ferramenta de Gestão de Dependências
- **Gradle**

## Funcionalidades

- Simulação de empréstimos
- Cálculo de juros e parcelas
- Consulta de simulações realizadas
- Validação de dados de entrada

## Como Executar o Projeto

1. **Clone o repositório:**
    ```bash
    git clone https://github.com/seu-usuario/seu-repositorio.git
    ```
2. **Navegue até o diretório do projeto:**
    ```bash
    cd seu-repositorio
    ```
3. **Execute o projeto utilizando Gradle:**
    ```bash
    ./gradlew bootRun
    ```

O projeto estará disponível em `http://localhost:8080`.

## Endpoints


### Criar usuário

### Consulta de usuarios
- **GET** `/api/cliente`
    - **Descrição:** Consulta todas as simulações de empréstimos realizadas.
    - **Parâmetros:** Nenhum.


- **POST** `/api/cliente`
    - **Descrição:** Realiza a criação de um usuário no banco de dados.
    - **Parâmetros:**
        ```json
        {
        "nome" : "nome",
        "documento" : "cpf",
        "celular" : 9999999,
        "score" : 0-1000,
        "negativado" : false/true
        }
        ```

### Simulação de Empréstimo
** A parcelas e taxas são limitadas a: {"6": 0.04, "12": 0.045, "18": 0.05, "24": 0.053, "36": 0.055} **

- **POST** `/api/simulacao`
    - **Descrição:** Realiza uma simulação de empréstimo.
    - **Parâmetros:**
        ```json
        {
    	"documento" : "cpf",
    	"numeroParcela": 6,
    	"valor" : valor em double,
    	"TaxaJuros" : 0.04
        }
        ```

### Consulta de Simulações
- **GET** `/api/simulacao`
    - **Descrição:** Consulta todas as simulações de empréstimos realizadas.
    - **Parâmetros:** Nenhum.


