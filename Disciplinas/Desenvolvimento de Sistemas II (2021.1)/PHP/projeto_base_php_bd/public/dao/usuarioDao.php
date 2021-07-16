<?php

include_once "./conexao/conexao.php";

function getUserName($email){

    $connection = criaConexao();

    $sql = "SELECT * FROM usuario WHERE email_usuario = '". $email ."'";

    $result = mysqli_query($connection, $sql);

    $usuarios = array();

    while ($itemAluno = mysqli_fetch_assoc($result)) {

        array_push($usuarios, $itemAluno);
    }

    mysqli_close($connection);

    return $usuarios[0]['nome_usuario'];
}