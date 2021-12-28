const { Sequelize, DataTypes } = require('sequelize');
const conexao = require('../config/database')

const Task = conexao.define("tasks", {
    title: {
        type: DataTypes.STRING,
        allowNull: false
    },
    description: {
        type: DataTypes.STRING,
        allowNull: false
    },
    createdAt: {
        type: DataTypes.DATE,
    },
    updatedAt: {
        type: DataTypes.DATE,
    }
}, { freezeTableName: true })

Task.schema("tasks")

module.exports = Task