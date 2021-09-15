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

function alteraAluno($id_aluno, $nome, $email, $img_perfil){
    $connection = criaConexao();
    $sql = "UPDATE aluno SET nome_aluno = '". $nome ."', email_aluno = '". $email ."', img_perfil = '".$img_perfil."' WHERE id_aluno = ".$id_aluno;

    $result = mysqli_query($connection, $sql);

    mysqli_close($connection);

    if ($result) {
        return true;
    }

    return false;
}

function adicionaAluno($nome, $email, $img_perfil) {
    $connection = criaConexao();
    $sql = "INSERT INTO aluno (nome_aluno, email_aluno, curso, img_perfil) VALUES ('". $nome ."', '". $email ."', 'Análise e Desenvolvimento de Sistemas', '".$img_perfil."')";

    $result = mysqli_query($connection, $sql);

    mysqli_close($connection);

    if ($result) {
        return true;
    }

    return false;
}
