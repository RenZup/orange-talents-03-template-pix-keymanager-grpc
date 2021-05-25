package br.com.pix.exception

class ContaNaoEncontradaException(
    message: String = "Conta nao encontrada no ErpClient Itau"
): RuntimeException(message){}