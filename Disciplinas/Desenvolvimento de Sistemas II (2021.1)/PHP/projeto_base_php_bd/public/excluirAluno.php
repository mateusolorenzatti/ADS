<?php

include_once('verifica_session.php');
  
if (!verifica_session()) {
    header('location:index.html');
}

include_once("./dao/alunoDao.php");

$aluno = excluiAluno($_GET['id']);

header("Location: home.php");