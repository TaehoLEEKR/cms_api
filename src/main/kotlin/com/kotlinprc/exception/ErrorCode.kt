package com.kotlinprc.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val httpStatus: HttpStatus,
    val detail: String
) {
    ALREADY_REGISTER_USER(HttpStatus.BAD_REQUEST, "이미 가입된 회원입니다."),
    NOT_FOUND_USER(HttpStatus.BAD_REQUEST,"일치 하는 회원이 없습니다."),
    ALREADY_VERIFY(HttpStatus.BAD_REQUEST,"이미 인증 되었습니다."),
    WRONG_VERIFICATION(HttpStatus.BAD_REQUEST,"잘못된 인증 코드 입니다."),
    EXPIRE_CODE(HttpStatus.BAD_REQUEST,"인증 만료 입니다..")
    ;
}
