package com.example.ditestapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ditestapplication.Interface.Store
import com.example.ditestapplication.interfaceImpl.LotteDepartment
import com.example.ditestapplication.module.BindModule
import com.example.ditestapplication.module.ProvideModule
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.*
import java.io.IOException
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Qualifier

/**
 * @AndroidEntryPoint annotation을 붙여주면
 * Hilt가 해당 클래스에 Dependency를 제공해 줄 수 있는 Componet를 생성해 준다.
 * ->의존성을 받아 보고자 하는 안드로이드 컴포넌트에 작성해 준다.
 *
 * Android lifecycle을 따르는 dependency container를 생성하는 어노테이션
 * Application 클래스에 Hlit를 설정하고 application-level-component를 사용할 수 있게 되면 Hilt는
 * @AndroidEntryPoint 주석이 있는 다른 Android 클래스에 dependency를 제공할 수 있다.
 * Hilt가 지원하는 Android 클래스: Activity, Fragment, View, Service, BroadcastReceiver
 * **/

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "taek"

    @Inject
    lateinit var sClass: Sclass //1. 필드 의존성 주입
    @Inject
    lateinit var aClass: Aclass //2. 생성자 의존성 주입

    @BindModule.BookStoreQualifer
    @Inject
    lateinit var bookStoreImpl: Store //3-1. 인터페이스 의존성 주입

    @BindModule.ClothingStoreQualifer
    @Inject
    lateinit var clothingStoreImpl: Store //3-2. 인터페이스 의존성 주입


    @Inject
    lateinit var httpClient: OkHttpClient //4. 외부라이브러리 의존성 주입

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"필드 의존성 주입: ${sClass.doTest()}")
        Log.d(TAG,"생성자 의존성 주입: ${aClass.doTest()}")
        Log.d(TAG,"인터페이스 의존성 주입1: ${bookStoreImpl.doTest()}")
        Log.d(TAG,"인터페이스 의존성 주입2: ${clothingStoreImpl.doTest()}")

        val request = Request.Builder()
            .url("https://www.google.com")
            .header("User-Agent", "OkHttp Example")
            .build()
        httpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i(TAG, "Network call error - ${call}, err msg - ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.i(TAG, "Network call - ${response.body}")
            }
        })
    }
}


