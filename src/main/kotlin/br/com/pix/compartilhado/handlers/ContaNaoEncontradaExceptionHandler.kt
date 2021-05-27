package br.com.pix.compartilhado.handlers

import br.com.pix.exception.ObjetoNaoEncontradoException
import io.grpc.Status

class ContaNaoEncontradaExceptionHandler  : ExceptionHandler<ObjetoNaoEncontradoException> {
    override fun handle(e: ObjetoNaoEncontradoException): ExceptionHandler.StatusWithDetails {
        return ExceptionHandler.StatusWithDetails(
            Status.NOT_FOUND
                .withDescription(e.message)
                .withCause(e)
        )
    }

    override fun supports(e: Exception): Boolean {
        return e is ObjetoNaoEncontradoException
    }
}