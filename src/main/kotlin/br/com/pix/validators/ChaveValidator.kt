package br.com.pix.validators

import br.com.pix.dto.CadastrarChaveRequestDto
import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import javax.inject.Singleton
import javax.validation.Constraint
import kotlin.reflect.KClass

@Singleton
class ChaveValidator: ConstraintValidator<ChavePix, CadastrarChaveRequestDto> {

    override fun isValid(
        value: CadastrarChaveRequestDto?,
        annotationMetadata: AnnotationValue<ChavePix>,
        context: io.micronaut.validation.validator.constraints.ConstraintValidatorContext
    ): Boolean {
       return value?.tipoChave?.valid(value.valorChave)?: false
    }


}

@MustBeDocumented
@Target(AnnotationTarget.CLASS,AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [ChaveValidator::class])
annotation class ChavePix(
    val message: String = "chave PIX inválida para o tipo informado",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Any>> = [],
    )