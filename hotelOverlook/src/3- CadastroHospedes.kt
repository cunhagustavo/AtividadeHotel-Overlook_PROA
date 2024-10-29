package Hotel

// Lista global para armazenar hóspedes
var listaHospedes = mutableListOf<String>()

fun cadastroHospedes() {

    var padraoDia = 100.0
    val maxHospedes = 15

    println("Informe o valor padrão da diária:")
    padraoDia = readln().toDoubleOrNull()?: 100.0
    println()

    while (true) {
        println("""Cadastro de Hóspedes
            Selecione uma opção:
            1. Cadastrar
            2. Pesquisar
            3. Lista dos hóspedes
            4. Sair""")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarHospede(maxHospedes, padraoDia)
            2 -> pesquisarHospede()
            3 -> listar()
            4 -> sairCadastro()
            else -> erroCadastro()
        }
    }
}

fun cadastrarHospede(maxHospedes: Int, padraoDia: Double) {

    if (listaHospedes.size >= maxHospedes){
        println("Máximo de cadastros atingido!")
        return
    }
    println()
    println("Cadastro de Hóspedes. " +
            " Por favor, informe o nome da Hóspede:")
    val novoHospede = readln().trim().lowercase().replaceFirstChar{ it.titlecase()}

    if (novoHospede.isEmpty()){
        println("Nome do hóspede, não pode estar em vazio!")
        return
    }
    listaHospedes.add(novoHospede)

    println("Qual é a sua idade, $novoHospede?")
    var idade = readln().toIntOrNull()
    println()

    if (idade == null){
        println("Idade inválida. Cadastro não realizado.")
        listaHospedes.remove(novoHospede)
        return
    }

    when{
        idade <6 -> println("$novoHospede, possui gratuidade!")
        idade >= 60 -> {
            println("$novoHospede, paga meia! Valor da diária a pagar: R$${padraoDia/2}")
        }
        else ->{
            println("$novoHospede, foi realizado seu cadastro! Valor da diária: R$$padraoDia")
        }
    }
}

fun pesquisarHospede() {
    println("Pesquisa de Hóspedes." +
            " Por favor, informe o nome do Hóspede:")
    val nomeHospede = readln().trim().lowercase().replaceFirstChar{ it.titlecase()}

    if (listaHospedes.contains(nomeHospede)) {
        println("Hóspede $nomeHospede foi encontrado(a)!")
        println()
    } else {
        println("Não encontramos nenhuma hóspede com esse nome.")
        println()
    }
}

fun listar(){
    println("Lista de Hóspedes:")
    listaHospedes.forEach { println(it)}
    println()
}

fun sairCadastro() {
    println("Você deseja voltar ao menu do hotel? (S/N)")
    var escolher = readln()
    println()

    when (escolher.uppercase()) {
        "S" -> {
            println("Voltando ao menu do $hotel")
            inicio()
        }

        "N" -> {
            println("Tudo bem! Voltaremos ao Cadastro de Hóspedes")
            cadastroHospedes()
        }

        else -> {
            println("Desculpe, mas não compreendi.")
            sair()
        }
    }
}

fun erroCadastro() {
    println("Por favor, informe um número entre 1 e 3.")
}

