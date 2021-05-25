package br.com.pix.conexaoERP

import br.com.pix.enum.TipoChave
import com.sun.istack.NotNull
import javax.persistence.*
import javax.validation.Valid

@Entity
class ChavePix(
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    val tipoChave: TipoChave,
    @NotNull
    @Column(nullable = false, unique = true)
    val valorChave: String,

    @Embedded
    @field:Valid
    val conta: Conta

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    override fun toString(): String {
        return "ChavePix(tipoChave=$tipoChave, valorChave='$valorChave', conta=$conta, id=$id)"
    }


}
