<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">


    <link rel="stylesheet" href="./css/master.css">

    <title>Acadêmico</title>
</head>

<body>
    <div class="container">
        <h2 class="my-4">Lista de Alunos</h2>
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

    <script src="./js/master.js"></script>
</body>

</html>