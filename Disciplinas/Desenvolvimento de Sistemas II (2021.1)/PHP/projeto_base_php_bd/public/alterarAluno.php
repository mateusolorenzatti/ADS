<?php

include_once "./dao/alunoDao.php";

// print_r($_POST);

$id_aluno = $_POST["id_aluno"];
$nome = $_POST["username"];
$email = $_POST["email"];

if ($_FILES["img_perfil"]["tmp_name"] != ''){

    $file = $_FILES["img_perfil"];
    $newfilename = $_FILES["img_perfil"]["tmp_name"] . "_" . rand(1000, 9999) . ".png";
    $newfilename = str_replace("/tmp/php", "", $newfilename);

    $img_perfil =  "./media/img_perfil/" . $newfilename;

    move_uploaded_file($_FILES["img_perfil"]["tmp_name"], $img_perfil);

}else{
    $img_perfil = $_POST["img_perfil_old"];
}


alteraAluno($id_aluno, $nome, $email, $img_perfil);

header("Location: /home.php");