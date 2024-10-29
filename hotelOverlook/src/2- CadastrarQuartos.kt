package Hotel

var quartosHotel = mutableListOf<Int>()
var nomeHospede = ""


fun obterValorDiaria():Double{
    while (true){
        println("Qual é o valor da diária?")
        val valorDia = readln().toDoubleOrNull()

        if (valorDia != null && valorDia > 0){
            return valorDia
        }else{
            println("Valor inválido. Tente novamente")
        }
    }
}

fun obterQndtDias(): Int {
    while (true){
        println("Quantos dias o Sr/Sra $nomeHospede irá se hospedar?")
        val diasDiaria = readln().toIntOrNull()

        if (diasDiaria != null && diasDiaria in 1..30){
            return diasDiaria
        }else{
            println("Não aceitamos essa quantidade de dias!")
            println("Aceitamos diária de 1 até 30 dias.")
            println()
        }
    }
}

fun escolherQuarto(): Int? {
    while (true){
        println("Qual quarto o Sr/Sra $nomeHospede deseja?")
        val numQuarto = readln().toIntOrNull()

        if (numQuarto in 1..20){
            if (quartosHotel.contains(numQuarto)){
                println("Este quarto, já está ocupado.")
                println("Deseja escolher outro quarto? (S/N)")
                val escolha = readln().toUpperCase()
                if (escolha != "S"){
                    return null
                }
            }else{
                return numQuarto
            }
        }else{
            println("Desculpa, não temos essa quantidade de quartos.")
            println("temos quarto de 1 ao 20.")
        }
    }
}

fun cadastroQuartos() {

    val valorDia = obterValorDiaria()
    val diasDiaria = obterQndtDias()

    while (true) {
        println("Por favor, informe o nome do Hóspede:")
        nomeHospede = readln().trim().lowercase().replaceFirstChar { it.titlecase() }

        if (nomeHospede.isEmpty()) {
            println("Por favor, digite o nome do hóspede. Não pode estar vazio")
        } else {
            break
        }
    }
    val numQuarto = escolherQuarto()

    if (numQuarto != null) {
        quartosHotel.add(numQuarto)
        val valorHospedagem = diasDiaria * valorDia
        println()
        println("Reserva realizada para $nomeHospede: $diasDiaria dia(s) no quarto $numQuarto por R$$valorHospedagem")
        confirmarReserva(nomeHospede, diasDiaria, numQuarto, valorHospedagem)
    } else {
        println("Reserva não realizada. Quarto ocupado.")
        println()
        println("Você deseja voltar ao menu do hotel? (S/N)")
        println("('S' para escolher outro quarto, e 'N' para voltar ao menu do $hotel)")
        var escolher = readln()
        println()

        when (escolher.uppercase()) {
            "S" -> {
                println("Voltando ao menu do $hotel")
                inicio()
            }
            "N" -> {
                println("Tudo bem! Vamos escolher outro quarto!")
                escolherQuarto()
            }
            else -> {
                println("Desculpe, mas não compreendi.")
                sair()
            }
        }
    }
}

fun confirmarReserva(nomeHospede: String, diasDiaria: Int, numQuarto: Int, valorHospedagem: Double){
    println("Sr/Sra $nomeHospede, você confirma a hospedagem por $diasDiaria dia(s) para o quarto $numQuarto por R$$valorHospedagem? (S/N)")
    var reservar = readln()

    when(reservar.uppercase()){
        "S" -> {
            println("Reserva confirmada!")
            listaHospedes.add(nomeHospede)
            proximaAcao()
        }
        "N" -> {
            println("Reserva não finalizada :(")
            proximaAcao()
        } 
        else -> {
            println("Desculpe, mas não compreendi.")
            confirmarReserva(nomeHospede, diasDiaria, numQuarto, valorHospedagem)
        }
    }
}
fun proximaAcao(){
    println("Deseja realizar outro cadastro ou voltar ao menu do $hotel?")
    println("('S' para realizar outro cadastro, e 'N' para voltar ao menu do $hotel)")
    var novoCadastroQuartos = readln()

    when (novoCadastroQuartos.uppercase()){
        "S" -> {
            println("Legal!! Vamos cadastrar!")
            cadastroQuartos()
        }
        "N" -> {
            println("Tudo bem! Voltando ao menu do $hotel")
            inicio()
        }
        else ->{
            println("Desculpe, mas não compreendi.")
            proximaAcao()
        }
    }
}
