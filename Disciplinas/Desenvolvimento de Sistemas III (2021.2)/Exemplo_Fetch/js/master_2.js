
const URL = 'http://www.mocky.io/v2/5d6ed7ab320000c0c1a8aabd';

async function fecthData() {

    try {
        const response = await fetch(URL);

        console.log(response.status);
        console.log(response.statusText);

        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error("Requisição falhou", error);
    }
}

fecthData();