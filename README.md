## Lista de tarefas (API) (Em Desenvolvimento)

    Uma api utilizando a linguagem de programação java

### Tecnologias utilizadas

    - VS code
    - JDK 21
    - Mysql
    - Spring boot

### Recursos

    [ ] Cadastro de tarefas (Nome, Descrição, data de criação, data de atualização)
    [ ] Atualização de tarefas (Iniciada, Finalizada, Cancelada, Pausada)
    [ ] Exclusão de tarefas
    [ ] Anotações das tarefas

### Como utilizadar a api

    Primeiramente tenha o JDK 21 instalado na máquina, clone o repositório e abra com sua IDE favorita java. Por fim rode o TodolistApplication.java.

### Rotas da api

    - /tarefas 
        Lista todas as tarefas

    - /tarefas/criar
        Cria uma tarefa mandando uma requisição com metodo POST e um JSON
        '''json
        {
            nome: Fazer a api,
            sobre: Uma api que será utilizada em .....
        }
        '''

    - /tarefas/atualizar
        Atualiza uma tarefa mandando uma requisição com metodo POST e um JSON
        '''json
        {
            id: 1,
            status: Finalizada
        }
        '''

    - /tarefas/excluir
        Exclui uma tarefa mandando uma requisição com metodo DELETE e um JSON
            '''json
            {
                id: 1
            }
            '''