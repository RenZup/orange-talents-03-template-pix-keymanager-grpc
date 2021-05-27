package br.com.pix.exception

class ObjetoNaoEncontradoException(
    message: String = "Objeto nao encontrado"
): RuntimeException(message){}