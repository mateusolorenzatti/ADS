
const Task = require('../models/task')
const { Op } = require("sequelize");

module.exports = app => {


    app.get('/tasks', async (req, res) => {

        try {
            const result = await Task.findAll()
            res.status(200).json(result)

        } catch (error) {
            console.error(error);
        }


        // conexao.query("select * from tasks", (err, result) => {
        //     if (err) {
        //         res.status(400).json(err)
        //     } else {
        //         res.status(200).json(result)
        //     }
        // })
    })

    app.get('/tasks/:id', async (req, res) => {

        taskId = req.params.id

        const result = await Task.findAll({
            where: {
                id: {
                    [Op.eq]: taskId
                }
            }
        });

        res.status(200).json(result)
    })

    app.post('/tasks', (req, res) => {
        // atribuindo o conteúdo da requisição
        const task = req.body

        console.table(task)

        Task.create(task)

        res.status(201).json({ code: '201', msg: 'Task criada' })
    })

    app.delete('/tasks/:id', async (req, res) => {
        taskId = req.params.id

        const result = await Task.destroy({
            where: {
                id: {
                    [Op.eq]: taskId
                }
            }
        })

        res.status(200).json({ code: '200', msg: 'Task excluída com sucesso.' })
    })

    app.put('/tasks/:id', async (req, res) => {

        taskId = req.params.id

        let result = await Task.update(
            req.body,
            {
                where: {
                    id: taskId
                }
            });

        res.status(200).json({ code: '200', msg: 'Task alterada com sucesso.' })
    })
}