<?php

include_once("./dao/alunoDao.php");

$aluno = excluiAluno($_GET['id']);

header("Location: home.php");