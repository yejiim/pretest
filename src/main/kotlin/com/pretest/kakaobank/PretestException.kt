package com.pretest.kakaobank

class PretestException(private val errorCode: PretestErrorCode) :Exception(errorCode.msg)