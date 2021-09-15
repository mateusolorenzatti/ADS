<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>

<body>
    <div class="container">
        <h5 class="mt-4"> Dados </h5>
        <table class="table">
            <?php
            foreach ($_POST as $key => $value) {
                echo "<tr>";
                echo "<td><b> $key </b></td>";
                echo "<td> $value </td>";
                echo "</tr>";
            }
            ?>
        </table>
        
        <hr>

        <h5 class="mt-4"> Arquivos </h5>
        <table class="table">
            <?php
            foreach ($_FILES as $key => $value) {
                echo "<tr>";
                echo "<td><b> $key </b></td>";
                echo "<td> ". $value['name']. " </td>";
                echo "<td> ". $value['type']. " </td>";
                echo "<td> ". $value['size']. " </td>";
                echo "<td> ". $value['tmp_name']. " </td>";
                echo "<td> ". $value['error']. " </td>";
                echo "</tr>";
            }
            ?>
        </table>
    </div>
</body>

</html>