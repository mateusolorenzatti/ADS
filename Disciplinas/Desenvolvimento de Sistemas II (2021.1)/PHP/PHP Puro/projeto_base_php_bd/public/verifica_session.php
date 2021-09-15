<?php
session_start();

function verifica_session() {
    if (!$_SESSION['login']) {

        unset($_SESSION['identificacao']);
        unset($_SESSION['nome']);

        session_destroy();

        return false;
    } else {
        return true;
    }
}

?>
