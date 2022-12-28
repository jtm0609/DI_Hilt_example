package com.example.ditestapplication

import javax.inject.Inject

//생성자 injection
class Aclass @Inject constructor(private val bClass: Bclass){
    fun doTest(): String{
        return bClass.test()
    }

    class Bclass @Inject constructor() {
        fun test(): String{
            return "constructor injection is Complete"
        }
    }
}


