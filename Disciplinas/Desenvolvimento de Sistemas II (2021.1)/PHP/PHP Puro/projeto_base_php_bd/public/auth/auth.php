<?php

include_once "./conexao/conexao.php";

function autentica($login, $senha){
    $connection = criaConexao();

    $sql = "SELECT * FROM usuario WHERE email_usuario = '". $login ."' AND senha = '".$senha."'";

    $result = mysqli_query($connection, $sql);
    // print_r($result);

    mysqli_close($connection);
    // die();

    if ($result->num_rows > 0){

        $usuarios = array();

        while ($itemAluno = mysqli_fetch_assoc($result)) {

            array_push($usuarios, $itemAluno);
        }

        return $usuarios[0]['nome_usuario'];
    }

    return null;
}