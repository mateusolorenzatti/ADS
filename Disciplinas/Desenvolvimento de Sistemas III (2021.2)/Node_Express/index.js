const boot = require('./config/boot')
const conexao = require('./config/database')

//definindo porta
const PORT = 3000

const start = async () => {
    try {
        await conexao.authenticate();
        const app = boot()
        // rodando a API
        app.listen(PORT, () => {
            console.info(`Rodando na porta ${PORT}`)
        })
    } catch (error) {
        console.error(error);
    }
}

start()


