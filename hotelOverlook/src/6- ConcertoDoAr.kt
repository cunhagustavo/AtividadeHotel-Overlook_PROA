package Hotel

import java.text.DecimalFormat

fun manutencao(){
    var orcamentos = mutableListOf<Pair<String, Double>>()
    var df = DecimalFormat("#.##")

    println("'Fica Frio aí!'")
    do {
        println("Qual o nome da empresa?")
        var nomeEmpresa = readln().trim()

        println("Qual é o valor por aparelho?")
        var valAparelho = readln().toDouble()

        println("Qual é a quantidade de aparelhos?")
        var qntdAparelho = readln().toInt()

        var desconto: Double
        while (true){
        println("Tem aquele desconto? Qual é o porcentagem de desconto? (0 a 100)")
        desconto = readln().toDouble()

            if (desconto in 0.0..100.0){
                break
            }else{
                println("Valor inválido! Por favor, digite um valor de 0 a 100")
            }

        }

        println("Qual é a quantidade miníma de aparelhos para conseguir o desconto? ")
        var aparelhosDescnt = readln().toInt()

        var totalServ = calcTotal(valAparelho, qntdAparelho, desconto, aparelhosDescnt)
        val totalFormatado = df.format(totalServ)

        println("O serviço da empresa $nomeEmpresa custará R$${"2%f".format(totalServ)}")

        orcamentos.add(Pair(nomeEmpresa, totalServ))

        println("Deseja adicionar novos dados? (S/N)\n")

    }while (readln().uppercase() == "S")

        println("====================Orçamentos====================")
    orcamentos.forEach{(empresa, valor) ->
        println(" Empresa: $empresa             Valor : R$${df.format(valor)}")
    }
    println("==================================================")
println()

    if (orcamentos.isNotEmpty()){
        val (empresaMenor, valorMenor) = orcamentos.minByOrNull { it.second }!!
        println("O orçamento de menor valor é o da $empresaMenor  por R$${df.format(valorMenor)}")
    }else{
        println("Nenhum orçamento registrado.")
    }
println()
    println("Você deseja realizar outra comparação de concerto no ar? (S/N)")
    println("('S' para realizar outra comparação de concerto no ar, e 'N' para voltar ao menu do $hotel)")
    var escolher = readln()
    println()

    when (escolher.uppercase()){
        "S" -> {
            println("VAMOS NESSA!")
            manutencao()
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


fun calcTotal (valAparelho: Double, qntdAparelho: Int, desconto: Double, aparelhosDescnt: Int): Double{
    val valTotal = valAparelho * qntdAparelho

    return if (qntdAparelho >= aparelhosDescnt){
        valTotal - (valTotal * desconto / 100)
    }else{
        valTotal
    }
}