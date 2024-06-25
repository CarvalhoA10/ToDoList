# Lista de tarefas (API) (Em Desenvolvimento)

Uma api para controle de funcionários e suas tarefas utilizando a linguagem de programação java e framework spring boot em sua construção.

## Tecnologias utilizadas

- VS code
- JDK 21
- Mysql
- Spring boot

## Recursos

- [ ] Cadastro de funcionarios(nome, cargo, email, data de cadastro, data de atualizacao)
- [ ] Atualizacao de funcionario
- [ ] Exclusão de funcionario
- [ ] Cadastro de tarefas (Nome, Descrição, data de criação, data de atualização)
- [ ] Atualização de tarefas (Iniciada, Finalizada, Cancelada, Pausada)
- [ ] Exclusão de tarefas
- [ ] Anotações das tarefas
- [ ] Anotações das tarefas

## Como utilizadar a api

Primeiramente tenha o JDK 21 instalado na máquina, clone o repositório e abra com sua IDE favorita java. Por fim rode o TodolistApplication.java.

O arquivo application.properties deverá ser alterado para o seu banco de dados como url, username e senha.

## Rotas da api

* localhost:8080/funcionarios
        Lista todos os funcionários mandando uma requisição com metodo GET

* /funcionario/criar
    Cria um funcionário ao mandar uma requisição com metodo POST com o JSON:

    ```json
    {
        "nome": "Joao",
        "cargo": "gerente",
        "email": "email@email.com"
    }
    ```

* /funcionarios/atualizar
    Atualiza um funcionário ao mandar uma requisição com metodo PUT com o JSON:

    ```json
    {
        "id": 1,
        "nome": "Novo nome",
        "cargo": "Novo cargo",
        "email": "Novo email"
    }
    ```

* /funcionario/deletar/{idfuncionario} // exemplo o id 1 /funcionarios/deletar/1
    Exclui um funcionário ao mandar uma requisição com metodo DELETE 

* /tarefas 
    Lista todas as tarefas mandando uma requisição com metodo GET

* /tarefas/criar
    Cria uma tarefa mandando uma requisição com metodo POST e um JSON

    ```json
    {
        "nome": "Fazer a api",
        "funcionarioId" : 1,
        "sobre": "Uma api que será utilizada em ....."
    }
    ```

* /tarefas/atualizar
    Atualiza uma tarefa mandando uma requisição com metodo PUT e um JSON

    ```json
    {
        "id": 1,
        "status": "Finalizada"
    }
    ```

* /tarefas/deletar/{idtarefa} // Exemplo /tarefas/deletar/1
    Exclui uma tarefa mandando uma requisição com metodo DELETE.


### Outras rotas
    
* /funcionario/{idfuncionario}
    Mostra o funcionário com todas as suas tarefas

* /funcionario/{idfuncionario}/iniciada
    Mostra todas as tarefas iniciadas do funcionário

* /funcionario/{idfuncionario}/finalizada
    Mostra todas as tarefas finalizadas do funcionário

* /funcionario/{idfuncionario}/Cancelada
    Mostra todas as tarefas canceladas do funcionário

* /funcionario/{idfuncionario}/pausada
    Mostra todas as tarefas pausadas do funcionário

* /tarefas/iniciada
    Mostra todas as terafas iniciadas

* /tarefas/finalizada
    Mostra todas as terefas finalizadas
        
* /tarefas/cancelada
    Mostra todas as tarefas canceladas

* /tarefas/pausada
    Mostra todas as tarefas pausadas