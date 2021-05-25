package br.com.pix.exception

import java.lang.RuntimeException

class ChaveDuplicadaException(
    message: String = "Chave já está cadastrada no banco"
): RuntimeException(message) {
}