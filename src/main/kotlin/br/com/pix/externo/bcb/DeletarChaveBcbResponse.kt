package br.com.pix.externo.bcb

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

data class DeletarChaveBcbResponse(
    private val key: String,
    private val participant: String,
    private val deletedAt: LocalDateTime,
)

