package br.com.pix.enum

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
    PHONE {
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
    RANDOM {
        override fun valid(chave: String?): Boolean {
          return chave.isNullOrBlank()

        }
    },
    CNPJ{
        override fun valid(chave: String?): Boolean {
            if(chave.isNullOrBlank()) return false

            return chave.matches("/^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}\$/\n".toRegex())
        }

    }
    ;


    abstract fun  valid(chave: String ?): Boolean
}

