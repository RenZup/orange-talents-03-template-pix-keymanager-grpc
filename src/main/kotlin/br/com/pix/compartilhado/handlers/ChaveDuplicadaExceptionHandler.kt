package br.com.pix.compartilhado.handlers

import br.com.pix.exception.ChaveDuplicadaException
import io.grpc.Status
import javax.inject.Singleton

@Singleton
class ChaveDuplicadaExceptionHandler : ExceptionHandler<ChaveDuplicadaException> {
    override fun handle(e: ChaveDuplicadaException): ExceptionHandler.StatusWithDetails {
        return ExceptionHandler.StatusWithDetails(
            Status.ALREADY_EXISTS
                .withDescription(e.message)
                .withCause(e)
        )
    }

    override fun supports(e: Exception): Boolean {
        return e is ChaveDuplicadaException
    }
}