<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <link rel="stylesheet" href="./css/master.css">

    <title>Acadêmico</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-success mb-4">
        <div class="container">
            <a class="navbar-brand" href="/home.php">Acadêmico</a>

            <div class="">
                <div class="collapse navbar-collapse mr-auto" id="navbarNav">
                    <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link active disabled" href="/home.php">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/telaNovoAluno.php"> Adicionar Aluno </a>
                    </li>
                </div>  
            </div>
        </div>
    </nav>
    <div class="container">
        <h5 class="my-4">Lista de Alunos</h5>
        <div class="fill">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Email</th>
                        <th scope="col" colspan="2">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    include_once "./dao/alunoDao.php";

                    $alunos = buscaAlunos();

                    foreach ($alunos as $aluno) : ?>
                        <tr>
                            <td> <?php echo $aluno['nome_aluno'] ?> </td>
                            <td> <?php echo $aluno['email_aluno'] ?> </td>
                            <td>
                                <a href="excluirAluno.php?id=<?php echo $aluno['id_aluno'];?>"> Excluir</a>
                            </td>
                            <td>
                                <a href="telaEdicaoAluno.php?id=<?php echo $aluno['id_aluno'];?>"> Alterar</a>
                            </td>
                        </tr>
                    <?php endforeach ?>
                </tbody>
            </table>
        </div>
        <div class="d-flex flex-row-reverse align-items-center" style="padding: 1vh;">
            <button type="button" class="btn btn-outline-dark btn-novo-aluno">Novo Aluno</button>
        </div>

        <footer class="d-flex flex-column align-items-center">
            <div>
                <p>Exemplo PHP + BD - ADS IFRS Campus Farroupilha</p>
            </div>
            <div class="ref">
                <p>Dados aleatórios gerados pela ferramenta Mokaroo -
                    <a href="https://www.mockaroo.com/">https://www.mockaroo.com/</a>
                </p>
            </div>

        </footer>
    </div>

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    -->

    <script src="./js/master.js"></script>
</body>

</html>