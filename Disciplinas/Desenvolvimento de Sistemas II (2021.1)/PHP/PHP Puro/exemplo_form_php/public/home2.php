<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <?php
    $nome = htmlspecialchars($_POST['username']);

    $email = htmlspecialchars($_POST['email']);

    $dataNascimento = $_POST['birthdate'];
    ?>

    <p>
        Olá <?php echo $nome; ?>
    </p>

    <p>
        Seu email é <?php echo $email; ?>
    </p>

    <p>
        Seu data de nascimento é <?php echo $dataNascimento; ?>
    </p>

    <p>
        Lembrar ?
        <?php
        if (isset($_POST['remember'])) {
            echo "SIM";
        } else {
            echo "NÃO";
        }
        ?>
    </p>
</body>

</html>