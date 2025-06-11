package com.kotlinprc.client



data class SendMailForm(
    val form : String,
    val to : String,
    val subject : String,
    val text : String
) {

}