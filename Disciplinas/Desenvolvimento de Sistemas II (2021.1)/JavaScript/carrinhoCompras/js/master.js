// Script Principal

escreveValorTotal();

Array.from(document.getElementsByClassName("qtdItemInput"))
    .forEach(element => element.onchange = escreveValorTotal);

Array.from(document.getElementsByClassName("paraPresente"))
    .forEach(element => element.onchange = escreveValorTotal);

Array.from(document.getElementsByClassName("removerItem"))
    .forEach(element => element.onclick = removerProduto);

