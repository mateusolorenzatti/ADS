function teste(){
  alert("Teste");
}

function arred(d,casas) {
   var aux = Math.pow(10,casas)
   return Math.floor(d * aux)/aux
}

function textToFloat(text){
  var valor = text.replace("R$ ", "").replace(",",".");
  return parseFloat(valor);
}

function floatToText(float){
  var text = "R$ " + float;
  return text;
}

function calculaPrecoTotal(){

  var valorPresente = 5;

  // console.log("Aqui");

  var total = 0;

  var produtos = document.getElementsByClassName("produto");

  // console.log(produtos);

  for (var i = 0; i < produtos.length; i++) {

    var precoUnitario = produtos[i].getElementsByClassName('valor');
    precoUnitario = precoUnitario[0].textContent;

    precoUnitario = textToFloat(precoUnitario);

    // console.log(precoUnitario);

    var quantidadeItem = produtos[i].getElementsByClassName('qtdItemInput');
    quantidadeItem = quantidadeItem[0].value;
    // quantidadeItem = quantidadeItem[0].innerHTML;

    // console.log(quantidadeItem);

    var paraPresente = produtos[i].getElementsByClassName('paraPresente');

    total += ((precoUnitario*quantidadeItem) + (paraPresente[0].checked ? valorPresente : 0 ));

    total = arred(total, 2);

  }

  // console.log(total);

  return floatToText(total);

}

function escreveValorTotal() {
  var valorTotal = calculaPrecoTotal();
  // alert(valorTotal);
  document.getElementById("valor-total").innerHTML = valorTotal;
}

function removerProduto (event) {
  // console.log(event);

  let elemento = event.target.parentNode;
  elemento = elemento.parentNode.parentNode;
  elemento.remove();

  escreveValorTotal();
}