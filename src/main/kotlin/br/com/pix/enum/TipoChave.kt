package br.com.pix.enum

import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import io.micronaut.validation.validator.constraints.EmailValidator

enum class TipoChave {

    CHAVE_DESCONHECIDA {
        override fun valid(chave: String?): Boolean {
            return false
        }
    },
    CPF{
         override fun valid(chave: String?): Boolean {

            if(chave.isNullOrBlank()){
                return false
            }
            return chave.matches("^[0-9]{11}$".toRegex())


        }
    },
    CELULAR {
        override fun valid(chave: String?): Boolean {

            if(chave.isNullOrBlank()){
                return false
            }
            return chave.matches("^[1-9][0-9]{1,14}$".toRegex())
        }
    },
    EMAIL {
        override fun valid(chave: String?): Boolean {
            if(chave.isNullOrBlank()){
                return false
            }
            return EmailValidator().run {
                initialize(null)
                isValid(chave,null)
            }
        }
    },
    CHAVE_ALEATORIA {
        override fun valid(chave: String?): Boolean {
            return chave.isNullOrBlank()
        }
    };


    abstract fun  valid(chave: String ?): Boolean
}

