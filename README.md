# rinha-de-backend-2023-q3

# Build
- Compile o projeto antes de construir a imagem Docker

``` bash
# Constroi a imagem Docker
$ docker build -t rinha-backend:latest .

# Iniciar container a partir de uma imagem
$ docker run -p 8080:8080 rinha-backend:latest
```
---
<br/>

# ABOUT API

- **RequestHandler:**         Implementa uma interface para que uma classe possa tratar requisições.
- **SimpleRestServer:**       Responsável pela criação e gerenciamento do servidor HTTP e das rotas.
- **PessoaHandlerdetermina:** Determina como a requisição será tratada.
---
<br/>

## CASO TENHA PROBLEMAS COM PORTAS

<p>Finalize o processo que esta rodando na porta ou altere as portas da aplicação</p>

``` bash
# Mostra qual processo está utilizando a porta 8080
$ netstat -ano | findstr :8080

# Finalizar esse processo
$ taskkill /PID <PID> /F

# Exemplo
# TCP    0.0.0.0:8080    0.0.0.0:0    LISTENING    1234
$ taskkill /PID 1234 /F
```

``` bash
# Alterando as portas CONTAINER:HOST
$ docker run -p 8081:8080 rinha-backend:latest
```