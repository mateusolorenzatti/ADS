<?php
session_start();

unset($_SESSION['identificacao']);
unset($_SESSION['nome']);

session_destroy();

header('location:index.html');

?>