package com.github.mkdika.refactoringspringrestapi.handler

import org.springframework.http.HttpHeaders.CONTENT_TYPE
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun methodArgumentNotValid(e: MethodArgumentNotValidException, request: HttpServletRequest): ResponseEntity<ResponseError> {

        val errorMessages = e.bindingResult.fieldErrors.map { it.defaultMessage.orEmpty() }.toList()
        val responseError = ResponseError(messages = errorMessages)

        return status(BAD_REQUEST)
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .body(responseError)
    }

    data class ResponseError(
            val messages: List<String> = emptyList()
    )
}