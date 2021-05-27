package br.com.pix.exception

class ChaveDuplicadaException(
    message: String = "Chave já está cadastrada no banco"
): RuntimeException(message) {
}