package com.kotlinprc.exception

class CustomException(val errorCode: ErrorCode) : RuntimeException(errorCode.detail)
