package Hotel

import java.text.DecimalFormat

var numConvd = 0
var custoGar = 0.0
var custoTotalBuffet = 0.0
var aud = ""
var dataEvento = ""
var horaEvento = 0
var empresa = ""

fun cadastroEventos (){
    println()
    println("Qual será o número de convidados?")
    numConvd = readln().toInt()
    println()

    if (numConvd > 350 || numConvd <= 0){
        println("Não aceitamos essa quantidade de convidados!")
        cadastroEventos()
        return
    }

    when{
        numConvd <= 150 -> {
            aud = "Auditório Laranja"
            println("O melhor lugar para realizar seu evento, é no auditório laranja!")
            println("Vamos agendar o seu evento!")
            diaEhorario()
        }
        numConvd in 151..220 -> {
            val cadeiras = numConvd - 150
            aud = "Auditório Laranja"
            println("O melhor lugar para realizar seu evento, é no auditório laranja, vamos adicionar $cadeiras cadeiras em seu evento!")
            println("Vamos agendar o seu evento!")
            diaEhorario()
        }
        else -> {
            aud = "Auditório Colorado"
            println("O melhor lugar para realizar seu evento, é no auditório colorado!")
            println("Vamos agendar o seu evento!")
            diaEhorario()
        }
    }

}

fun diaEhorario(){
    println()
    println("Qual será o dia de seu envento?")
    dataEvento = readln().lowercase()

    println("Qual será o horário do evento?")
    horaEvento = readln().toInt()

    // Validação do horário
    val horarioLimite = if (dataEvento == "sabado" || dataEvento == "domingo") 15 else 23
    if ((dataEvento == "sabado" || dataEvento == "domingo" && (horaEvento < 7 || horaEvento > 15)) ||
        (dataEvento != "sabado" && dataEvento != "domingo" && (horaEvento < 7 || horaEvento > 23))
    ) {
        println("Não realizamos eventos neste horário.")
        println("Horários disponíveis: Sábados e Domingos 7hs às 15hs; Segunda a Sexta 7hs às 23hs!")
        diaEhorario() // Chamada recursiva para tentar novamente
        return
    }

    // Cálculo do horário final
    val horaFinal = if (dataEvento == "sabado" || dataEvento == "domingo") 15 else 23

    println("Qual seria o nome da sua empresa?")
    empresa = readln()

    // Mensagem de confirmação
    println()
    println("Seu evento foi agendado!")
    println("Evento da empresa $empresa, $dataEvento para o horário das $horaEvento:00 hs")
    println("(Lembrando que o horário máximo do nosso espaço é até às $horarioLimite:00 hs)")
    println()
    garçom(horaFinal)
}

fun garçom(horaFinal: Int){
    println("Qual será a duração do evento em horas?")
    println()
    var duracaoEventos = readln().toInt()

    //cálculo de garçons
    var contGarcom = (numConvd+11)/12 //Arredondando para cima
    var garcom = contGarcom + (duracaoEventos + 1) / 2 // Adiciona 1 garçom a cada 2 horas
    custoGar = garcom * duracaoEventos * 10.5

    println("Serão necessários $garcom garçons em seu evento.")
    println("O custo será de R$$custoGar")
    println("Agora vamos calcular o custo do buffet do hotel para o evento.")
    println()
    Buffet(horaFinal, duracaoEventos, garcom)
}

fun Buffet (horaFinal: Int, duracaoEventos: Int, garcom: Int){
    // Calcular a quantidade de café, água e salgados
    val quantidadeCafe = numConvd * 0.2
    val quantidadeAgua = numConvd * 0.5
    val quantidadeSalgados = numConvd * 7

    // Calcular o custo total
    val custoCafe = quantidadeCafe * 0.80
    val custoAgua = quantidadeAgua * 0.40
    val custoSalgados = (quantidadeSalgados / 100) * 34
    val df = DecimalFormat("#.00")

    custoTotalBuffet = custoCafe + custoAgua + custoSalgados

    // Exibir os resultados
    println("O evento precisará de ${df.format(quantidadeCafe)} litros de café;" +
            " ${df.format(quantidadeAgua)} litros água;" +
            " $quantidadeSalgados unidades de salgados!")
    println()
    println("Custo total com comida do evento: R$$custoTotalBuffet")
    println()
    verificarReserva(horaFinal, duracaoEventos, garcom)
}

fun verificarReserva(horaFinal: Int, duracaoEventos: Int, garcom: Int){

    val totalFinal = custoGar + custoTotalBuffet

    println("====================RESUMO DO EVENTO====================")
    println("Evento no $aud.")
    println("Nome da empresa: $empresa.")
    println("Data: $dataEvento, ${horaEvento}H às ${horaFinal}H.")
    println("Duração do evento: $duracaoEventos H.")
    println("Quantidade de garçons: $garcom")
    println("Quantidade de convidados: $numConvd.")
    println()
    println("Custo dos garçons: R$$custoGar.")
    println("Custo do buffet: R$$custoTotalBuffet")
    println()
    println("Valor total do evento: R$$totalFinal")
    println("========================================================")
    println()
    println("Gostaria de efetuar a reserva? (S/N)")
    val resposta = readln().uppercase()

    if(resposta == "S"){
        println("${empresa}, reserva efetuada com sucesso!")
        println()
        println("Você deseja realizar outra reserva? (S/N)")
        println("('S' para realizar outra reserva, e 'N' para voltar ao menu do $hotel)")
        var escolher = readln()
        println()

        when (escolher.uppercase()){
            "S" -> {
                println("VAMOS NESSA!")
                cadastroEventos()
                //exitProcess(0) //encerra o programa
            }
            "N" ->{
                println("Voltando ao menu do $hotel")
                inicio()
            }
            else -> {
                println("Desculpe, mas não compreendi.")
                sair()
            }
        }
    }else{
        println("Reserva não efetuada!")
        println("Você deseja realizar outra reserva? (S/N)")
        println("('S' para realizar outra reserva, e 'N' para voltar ao menu do $hotel)")
        var escolher = readln()
        println()

        when (escolher.uppercase()){
            "S" -> {
                println("VAMOS NESSA!")
                cadastroEventos()
                //exitProcess(0) //encerra o programa
            }
            "N" ->{
                println("Voltando ao menu do $hotel")
                inicio()
            }
            else -> {
                println("Desculpe, mas não compreendi.")
                sair()
            }
        }
    }
}


