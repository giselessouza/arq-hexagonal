package org.example.core.ports

import org.example.core.model.EnderecoCore
import org.example.entrypoint.rest.dto.EnderecoResponse

interface EntryPointPort {
    fun getEndereco( enderecoId: String): EnderecoCore

}