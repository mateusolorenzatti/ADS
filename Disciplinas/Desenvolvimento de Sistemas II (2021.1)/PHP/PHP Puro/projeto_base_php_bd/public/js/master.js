btnNovoAluno = document.querySelector(".btn-novo-aluno")
console.log(btnNovoAluno);

btnNovoAluno.addEventListener("click", (event) => {
    window.location.href = "telaNovoAluno.php";
});