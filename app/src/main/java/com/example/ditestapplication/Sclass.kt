package com.example.ditestapplication

import javax.inject.Inject

class Sclass @Inject constructor(){
    fun doTest(): String{
        return "filed Injection is Complete"
    }
}


