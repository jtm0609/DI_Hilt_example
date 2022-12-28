package com.example.ditestapplication.interfaceImpl

import com.example.ditestapplication.Interface.Store
import javax.inject.Inject

class BookStore @Inject constructor(): Store {
    override fun doTest(): String {
        return "BookStore is interface Injection"
    }
}


