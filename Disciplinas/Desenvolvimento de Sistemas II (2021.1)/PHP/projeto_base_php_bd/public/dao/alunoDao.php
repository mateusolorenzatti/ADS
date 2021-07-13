<?php

include_once "./conexao/conexao.php";

function buscaAlunos()
{
    $connection = criaConexao();

    $sql = "select * from aluno";

    $result = mysqli_query($connection, $sql);

    $alunos = array();

    while ($itemAluno = mysqli_fetch_assoc($result)) {

        array_push($alunos, $itemAluno);
    }

    mysqli_close($connection);

    return $alunos;
}

function buscaAlunoPorID($id_aluno)
{
    $connection = criaConexao();

    $sql = "select * from aluno where id_aluno = $id_aluno";

    $result = mysqli_query($connection, $sql);

    $alunos = array();

    while ($itemAluno = mysqli_fetch_assoc($result)) {

        array_push($alunos, $itemAluno);
    }

    mysqli_close($connection);

    return $alunos[0];
}

function excluiAluno($id_aluno)
{
    $connection = criaConexao();
    $sql = "delete from aluno where id_aluno = $id_aluno";

    $result = mysqli_query($connection, $sql);

    mysqli_close($connection);

    if ($result) {
        return true;
    }

    return false;
}

function alteraAluno($id_aluno){
    // TODO
}

function adicionaAluno($nome, $email) {

    $connection = criaConexao();
    $sql = "INSERT INTO aluno VALUES ('". $nome ."', '". $email ."', 'Análise e Desenvolvimento de Sistemas')";

    $result = mysqli_query($connection, $sql);

    mysqli_close($connection);

    if ($result) {
        return true;
    }

    return false;
}
