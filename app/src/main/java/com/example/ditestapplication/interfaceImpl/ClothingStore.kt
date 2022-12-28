package com.example.ditestapplication.interfaceImpl

import com.example.ditestapplication.Interface.Store
import javax.inject.Inject

class ClothingStore @Inject constructor(): Store {
    override fun doTest(): String {
        return "ClothingStore is interface Injection"
    }
}


