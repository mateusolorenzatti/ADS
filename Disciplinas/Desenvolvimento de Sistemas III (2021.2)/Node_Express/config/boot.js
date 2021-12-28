const express = require('express')
const consign = require('consign')

module.exports = () => {
    // criando a aplicação - instância do express
    const app = express()

    // configurando a app
    app.use(express.json())
    app.set("json spaces", 4)

    consign().include('controllers').into(app)

    return app
}

