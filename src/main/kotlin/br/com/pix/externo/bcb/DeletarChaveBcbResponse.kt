package br.com.pix.externo.bcb

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime
import java.util.*

data class DeletarChaveBcbResponse(
     val key: String,
     val participant: String,
     val deletedAt: LocalDateTime,
)

