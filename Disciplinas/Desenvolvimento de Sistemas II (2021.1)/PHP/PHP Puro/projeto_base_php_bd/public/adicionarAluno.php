<?php
include_once('verifica_session.php');
  
if (!verifica_session()) {
    header('location:index.html');
}

// print_r($_POST);
include_once "./dao/alunoDao.php";

$nome = $_POST["username"];
$email = $_POST["email"];

if ($_FILES["img_perfil"]["tmp_name"] != ''){

    $file = $_FILES["img_perfil"];
    $newfilename = $_FILES["img_perfil"]["tmp_name"] . "_" . rand(1000, 9999) . ".png";
    $newfilename = str_replace("/tmp/php", "", $newfilename);

    $img_perfil =  "./media/img_perfil/" . $newfilename;

    move_uploaded_file($_FILES["img_perfil"]["tmp_name"], $img_perfil);

}else{
    $img_perfil = "./media/default/img_perfil.png";
}

// echo $img_perfil; die();

adicionaAluno($nome, $email, $img_perfil);

header("Location: /home.php");