<?php

    include_once('verifica_session.php');
  
    if (!verifica_session()) {
        header('location:index.html');
    }

?>

<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <title>Inserir Aluno</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-success mb-4">
        <div class="container">
            <a class="navbar-brand" href="/home.php">Acadêmico</a>

            <div class="">
                <div class="collapse navbar-collapse mr-auto" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="/home.php">Home </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active disabled" href="/telaNovoAluno.php"> Adicionar Aluno </a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link active disabled" href=""> | &nbsp; <?php echo $_SESSION['nome'] . " - " . $_SESSION['identificacao'] ?> </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/logout.php"> | &nbsp; Sair </a>
                        </li>
                    </ul>
                </div>  
            </div>
        </div>
    </nav>
    <div class="container">
        
        <div class="card">
            <div class="card-body">
                <a class="btn btn-primary btn-sm" href="/home.php"> Voltar </a>
            </div> 
        </div> <br/>

        <div class="row col-12">  
            <div class="col-3"> </div>
            <div class="col-9">
                <form action="adicionarAluno.php" method="POST" enctype="multipart/form-data">
                    <h5> Adicionar Aluno </h5> <br/>
                    <div class="mb-3">
                        <label for="inputEmail1" class="form-label">Email</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" name="email" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="inputName" class="form-label">Nome</label>
                        <input type="text" class="form-control" id="inputName" name="username" required>
                    </div>

                    <div class="mb-3">
                        <label for="img_perfil" class="form-label"> Imagem de Perfil </label> <br/>
                        <input type="file" name="img_perfil" id="img_perfil">    
                        <input type="hidden" name="MAX_FILE_SIZE" value="30000">    
                    </div>

                    <hr>

                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            </div>
        </div>

    </div>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    -->
</body>

</html>