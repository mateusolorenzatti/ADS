
criaSaudacao = () => {
    const dataAtual = new Date()
    const hora = dataAtual.getHours()

    const saudacao = hora < 19 ? "Olá Usuário" : "Boa Noite"

    const elementoSaudacao = document.querySelector(".saudacao")
    elementoSaudacao.innerHTML = saudacao

    elementoSaudacao.style.fontWeight = "bold"
    elementoSaudacao.style.color = hora < 19 ? "red" : "blue"
}

excluirTodasAnotacoes = () => {
    let anotacoes = document.querySelectorAll(".item")

    anotacoes.forEach(e => e.remove())
}

excluirAnotacao = (event) => {
    console.log(event);
    let elemento = event.target.parentNode
    elemento = elemento.parentNode
    elemento.remove()
}

finalizaAnotacao = (event) => {
    let elemento = event.target.parentNode
    elemento = elemento.parentNode

    //Realiza um toggle na classe, que muda o estilo baseado no CSS
    elemento.classList.contains("anotacao-finalizada") 
        ? elemento.classList.remove("anotacao-finalizada") 
        : elemento.classList.add("anotacao-finalizada") 
}

criaAnotacao = (descricao) => {
    // console.log(descricao); 
    
    //cria div para cada anotacao
    const novaAnotacao = document.createElement("div")
    novaAnotacao.classList.add("item", "d-flex", "flex-row")

    const novaAnotacaoDesc = document.createElement("p")
    novaAnotacaoDesc.innerHTML = descricao
    novaAnotacaoDesc.classList.add("flex-grow-1")

    novaAnotacao.appendChild(novaAnotacaoDesc)

    //cria opcoes
    const opcoes = document.createElement("div")
    opcoes.classList.add("opcoes")

    novaAnotacao.appendChild(opcoes)

    // cria opcao excluir
    const opcaoExcluir = document.createElement("i")
    opcaoExcluir.classList.add("bi", "bi-trash")
    // evento disparado ao clicar no ícone lixeira
    opcaoExcluir.onclick = excluirAnotacao
    // opcaoExcluir.addEventListener("click", excluirAnotacao)

    //  cria opcao finalizar
    const opcaoFinalizar = document.createElement("i")
    opcaoFinalizar.classList.add("bi", "bi-check")
    opcaoFinalizar.onclick = finalizaAnotacao

    // insrindo as opçoes na div
    opcoes.appendChild(opcaoFinalizar)
    opcoes.appendChild(opcaoExcluir)

    // adicionando o item na lista
    const listaAnotacoes = document.querySelector("section")
    listaAnotacoes.appendChild(novaAnotacao)
}

document.getElementById("entrada").onkeypress = (event) => {
    // console.log(event);
    if (event.key == 'Enter') {
        criaAnotacao(event.target.value)    
    }
}

document.getElementById("excluir-todas-anotacoes").onclick = excluirTodasAnotacoes

criaSaudacao()
