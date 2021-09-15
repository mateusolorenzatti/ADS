// Exemplo GET REQUEST com fetch

const URL = 'http://www.mocky.io/v2/5d6ed7ab320000c0c1a8aabd';

const atualizarDados = (data) => {
    
    /*
        city: "Lago da Pedra"
        country: "Brazil"
        credit_card: "mastercard" ou null
        department: "Home"
        email: "dmiddletond@blogs.com"
        first_name: "Dorelia"
        gender: "Female"
        id: 14
        last_name: "Middleton"
        money: "$3185.95"
    */

    let dados = {
        comprasMasculino: 0,
        comprasFeminino: 0,
        comprasCartao: 0,
        comprasSemCartao: 0,
        comprasBrasil: 0,
        comprasCanada: 0,
        comprasUSA: 0,
        comprasUK: 0,
    }

    data.forEach(element => {
        if ( element.gender == "Male") dados.comprasMasculino ++
        if ( element.gender == "Female") dados.comprasFeminino ++

        if ( element.credit_card ){
            dados.comprasCartao += +(element.money.replace('$', ''))
        }else {
            dados.comprasSemCartao ++
        }

        switch(element.country) {
            case "Brazil":
              dados.comprasBrasil ++
              break;

            case "Canada":
              dados.comprasCanada ++
              break;

            case "United States":
              dados.comprasUSA ++
              break;

            case "United Kingdom":
              dados.comprasUK ++
              break;
          } 
    })

    dados.comprasCartao = 'US$ ' + dados.comprasCartao

    Object.keys(dados).forEach( dado => {
        document.getElementById(dado).innerHTML = dados[dado];
    })
}

fetch(URL)
    .then(response => response.json())
    .then(data => atualizarDados(data))
    .catch(error => console.error("Requisição falhou", error))