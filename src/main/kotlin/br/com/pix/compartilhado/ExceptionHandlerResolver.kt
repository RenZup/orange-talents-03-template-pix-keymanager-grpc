package br.com.pix.compartilhado

import br.com.pix.compartilhado.handlers.DefaultExceptionHandler
import br.com.pix.compartilhado.handlers.ExceptionHandler
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExceptionHandlerResolver(
    @Inject private val handlers: List<ExceptionHandler<Exception>>,
) {
    private var defaultHandler: ExceptionHandler<Exception> = DefaultExceptionHandler()

    constructor(handlers: List<ExceptionHandler<Exception>>, defaultHandler: ExceptionHandler<Exception>): this(handlers){
        this.defaultHandler = defaultHandler
    }

    fun resolve(e: Exception):
            ExceptionHandler<Exception> {
        val foundHandlers = handlers.filter { h -> h.supports(e)}
        if(foundHandlers.size > 1)
            throw IllegalStateException("Mais de um handler tratando a mesma exceção (${e.javaClass.name}): $foundHandlers")

        return foundHandlers.firstOrNull() ?: defaultHandler
    }
}

