package br.com.pix.conexaoERP

import javax.persistence.*
import javax.validation.Valid

@Entity
class ChavePix(

    @Embedded
    @field:Valid
    val conta: Conta

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null



}
