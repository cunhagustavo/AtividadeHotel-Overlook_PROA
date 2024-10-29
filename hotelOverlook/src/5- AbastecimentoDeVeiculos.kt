package Hotel

fun abastecimento() {

    val tanqueMax = 42

    var alcWayne = 0.0
    var gasWayne = 0.0
    var alcStark = 0.0
    var gasStark = 0.0



    println("Vamos abastecer!!")
    println()
    println("Qual o valor do álcool no posto Wayne Oil?")
    alcWayne = readln().toDouble()
    println("Qual o valor da gasolina no posto Wayne Oil?")
    gasWayne = readln().toDouble()
    println()
    println("Qual o valor do álcool no posto Stark Petrol?")
    alcStark = readln().toDouble()
    println("Qual o valor da gasolina no posto Stark Petrol?")
    gasStark = readln().toDouble()

    var totalAclWayne = alcWayne * tanqueMax
    var totalGasWayne = gasWayne * tanqueMax
    var totalAclStark = alcStark * tanqueMax
    var totalGasStark = gasStark * tanqueMax

    var mediaGasolina = (gasWayne + gasStark)/2
    var limiteAlc = mediaGasolina * 0.7

    val postoBarato: String
    val custoTotal: Double

    if (totalAclWayne < totalGasWayne && totalAclWayne < totalAclStark && totalAclWayne < totalGasStark){
        postoBarato = "Posto Wayne Oil"
        custoTotal = totalAclWayne
    }else if (totalAclStark < totalGasWayne && totalAclStark < totalGasStark ){
        postoBarato = "Posto Stark Petrol"
        custoTotal = totalAclStark
    }else if (totalGasWayne < totalGasStark){
        postoBarato = "Posto Wayne Oil"
        custoTotal = totalGasWayne
    }else{
        postoBarato = "Posto Stark Petrol"
        custoTotal = totalGasStark
    }

    val abastecerAlc = alcWayne <= limiteAlc || alcStark <= limiteAlc

    println()
    println("========================RESULTADO========================")
    println(" POSTOS        | Ácool R$(L)             | TOTAL         ")
    println("_______________|_________________________|_______________")
    println(" Wayne Oil     | R$${alcWayne}L                | R$${totalAclWayne}L")
    println(" Stark Petrol  | R$${alcStark}L                | R$${totalAclStark}L")
    println("_______________|_________________________|_______________")
    println(" POSTOS        | Gasolina R$(L)          | TOTAL         ")
    println(" Wayne Oil     | R$${gasWayne}L                 | R$${totalGasWayne}L")
    println(" Stark Petrol  | R$${gasStark}L                 | R$${totalGasStark}L")
    println("=========================================================")

    println()
    if (abastecerAlc){
        println("Abastecer com Ácool é mais barato em um dos postos.")
    }else{
        println("Abastecer com Gaolina é mais barato em um dos postos.")
    }

    println("${nome} o posto mais barato: $postoBarato com o custo total de R$$custoTotal")

    println()
    println("Você deseja voltar ao menu do $hotel ou continuar a compação dos postos? (S/N)")
    println("('S' para realizar outra comparação, e 'N' para voltar ao menu do $hotel)")
    var escolher = readln()
    println()

    when (escolher.uppercase()){

        "S" -> {
            println("Katchau! Vamos ver e abastecer")
            println("'Eu sou a velocidade!'")
            abastecimento()
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

