<?php

include_once "./auth/auth.php";
// include_once "./dao/usuarioDao.php";

// print_r($_POST);
$login = $_POST['userName'];
$senha = $_POST['userPassword'];

$loginValido = autentica($login, $senha);

// echo $loginValido; die();

// Suponha que foi feito uma autenticação na base de dados e retornou algumas infos do usuário
// $nome = getUserName($login);

// echo $loginValido; die();

if ($loginValido) {
    
    session_start();

    $_SESSION['identificacao'] = $login;
    $_SESSION['nome'] = $loginValido;
    $_SESSION['login'] = TRUE;

    header('location:home.php');
} else {
    
    header('location:index.html');
}
