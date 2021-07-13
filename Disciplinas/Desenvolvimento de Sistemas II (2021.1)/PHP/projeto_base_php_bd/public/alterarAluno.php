<?php
// print_r($_POST);
include_once "./dao/alunoDao.php";

$nome = $_POST["username"];
$email = $_POST["email"];

adicionaAluno($nome, $email);