package Hotel
import kotlin.system.exitProcess

val hotel = "Hotel Overlook"
val senha = 2678
var nome = " "

fun main (){

    login()
    inicio()

}

fun login() {
    println()
    println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★Bem-Vindo(a) ao $hotel★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆")
    println()

    println("Poderia digitar o seu nome?")
    nome = readln()
    println("Digite sua senha $nome:")
    var sen = readln().toInt()
    println()

    while (sen != senha){
        println("SENHA INCORRETA!")
        println("Digite a senha novamente (Dica 2678):")
        sen = readln().toInt()
        println()
    }
    if (sen == senha) {
        println("SENHA CORRETA!")
        inicio()
    }
}

fun inicio (){
    println()
    println("Bem vindo ao Hotel $hotel, $nome. É um imenso prazer ter você por aqui!")
    println()
    println("====================MENU PRINCIPAL====================")
    println("1 = Cadastro de Quartos")
    println("2 = Cadastro de Hóspedes")
    println("3 = Cadastro de Eventos")
    println("4 = Abastecimento de Veículos")
    println("5 = Manutenção do Ar")
    println("6 = Sair")
    println("======================================================")
    println()
    println("Escolha uma das opções acima:")
    val opcao = readln().toInt()
    println()

    when (opcao){
        1 -> cadastroQuartos()
        2 -> cadastroHospedes()
        3 -> cadastroEventos()
        4 -> abastecimento()
        5 -> manutencao()
        6 -> sair()
        else -> error()
    }
}

fun sair(){

    println()
    println("Você deseja sair do Hotel? (S/N)")
    var escolher = readln()
    println()

    when (escolher.uppercase()){

        "S" -> {
            println("Muito obrigado e até logo, $nome!")
            println("'Eu acho que muitas coisas aconteceram bem aqui neste hotel ao longo dos anos.'")
            exitProcess(0) //encerra o programa
        }
        "N" ->{
            inicio()
        }
        else -> {
            println("Desculpe, mas não compreendi.")
            sair()
        }
    }
}

fun error(){
    println()
    println("Essa operação é inexistente")
    println("Digite uma operação válida de 1 a 6.")
    println()
    inicio()
}


