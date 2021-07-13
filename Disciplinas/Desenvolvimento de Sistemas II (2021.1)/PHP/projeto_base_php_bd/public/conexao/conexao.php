<?php


function criaConexao()
{
    // echo "Conectando";

    // $host = "localhost";
    // $host = "127.0.0.1:3306";
    // $username = "root";
    // $password = "123456";
    // $database = "academico";

    define('DB_HOST', 'db');
    define('DB_NAME', 'academico');
    define('DB_USER', 'root');
    define('DB_PASSWORD', '123456');
    
    $connection = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME, 3306) or die('Failed to connect to the database, died with error:');
    return $connection;
    
}