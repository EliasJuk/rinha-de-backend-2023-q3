# rinha-de-backend-2023-q3

#build
- Compile o projeto antes de construir a imagem Docker

``` bash
# Constroi a imagem Docker
$ docker build -t rinha-backend:latest .

$ docker run -p 8080:8080 rinha-backend:latest
```

# ABOUT API
- **RequestHandler:**         Implementa uma interface para que uma classe possa tratar requisições.
- **SimpleRestServer:**       Responsável pela criação e gerenciamento do servidor HTTP e das rotas.
- **PessoaHandlerdetermina:** Determina como a requisição será tratada.