package br.com.pix.compartilhado.handlers

import br.com.pix.exception.ContaNaoEncontradaException
import io.grpc.Status

class ContaNaoEncontradaExceptionHandler  : ExceptionHandler<ContaNaoEncontradaException> {
    override fun handle(e: ContaNaoEncontradaException): ExceptionHandler.StatusWithDetails {
        return ExceptionHandler.StatusWithDetails(
            Status.NOT_FOUND
                .withDescription(e.message)
                .withCause(e)
        )
    }

    override fun supports(e: Exception): Boolean {
        return e is ContaNaoEncontradaException
    }
}