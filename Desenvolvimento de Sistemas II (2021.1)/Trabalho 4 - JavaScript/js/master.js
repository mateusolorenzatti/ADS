var count = 0;
var tarefasList = [];

$(() => {
    // console.log("Iniciando...");
    defineSaudacao();

    $("#inputTarefa").keypress( (event) => event.key === 'Enter' ? adicionarTarefa(event) : null);
    $("#criarTarefa").click( (event) => adicionarTarefa(event));
});

defineSaudacao = () => {
    var today = new Date();
    var time = today.getHours();

    if( time >= 0 && time < 12 ){
        saudacao = "Bom dia!";
        icone = "wb_sunny";
        
    }else if ( time >= 12 && time < 18 ){
        saudacao = "Boa tarde!";
        icone = "wb_sunny";
        
    } else{
        saudacao = "Boa noite!";
        icone = "brightness_2";
    }

    // console.log(saudacao);
    // console.log(icone);

    $('#texto-saudacao').text(saudacao);
    $('#icone-saudacao').text(icone);
}

excluirTarefa = (e) => {
    let tarefa = $(e.target).parent().parent().parent().parent();
    // console.log(tarefa);
    // console.log(tarefasList);

    tarefa.hide();
    tarefasList.pop();

    if(tarefasList.length == 0){
        $('#texto-nenhuma-tarefa').show();
    }

    $("#numero-tarefas").text(tarefasList.length);
}

adicionarTarefa = (event) => {
    event.preventDefault();
    // console.log("Cheguei");
    
    let conteudo = $("#inputTarefa").val();
    // console.log(conteudo);
    $("#inputTarefa").val("");

    if(conteudo.trim()){
        $(` <div id="tarefa${count}" class="cardTarefa card m-2 p-2 px-3">
                <div class="row col-12"> 
                    <div class="form-check col-11">
                        <input class="form-check-input mx-3 mt-2" type="checkbox" value="" id="check${count}">
                        <label class="form-check-label mt-1" for="check${count}">
                            ${conteudo}
                        </label>
                    </div>
                    <div class="col-1 text-right">
                        <a class="text-danger p-0" id="btn-excluir-tarefa${count}"> 
                            <i class="material-icons mt-1">delete</i>
                        </a>
                    </div>
                </div>
            </div> `
        ).appendTo($("#listaTarefas"));
    
        $('#btn-excluir-tarefa' + count).click(excluirTarefa);
        tarefasList.push(count);

        count++;

        $("#numero-tarefas").text(tarefasList.length);
        $('#texto-nenhuma-tarefa').hide();
    }
}