// const mysql = require('mysql2')

const { Sequelize } = require("sequelize")

// // conexao com bd
// const conexao = mysql.createConnection({
//     host: 'localhost',
//     user: 'root',
//     password: 'toor',
//     database: 'todo_app'
// })

const conexao = new Sequelize('ADS', 'aula', 'aula', {
    host: 'localhost',
    dialect: 'postgres',
    schema: 'tasks'
})

module.exports = conexao
