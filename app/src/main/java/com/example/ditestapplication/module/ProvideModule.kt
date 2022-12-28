package com.example.ditestapplication.module

import android.content.Context
import com.example.ditestapplication.Interface.Store
import com.example.ditestapplication.interfaceImpl.BookStore
import com.example.ditestapplication.interfaceImpl.ClothingStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Qualifier


/**Construcotr Injection 예외
 * 1. interface
 * 2. 외브라이브러리 클래스 객체 inject(Retrofit 같은 라이브러리 객체를 Constructor Injection 불가), 자신이 만든 클래스가 아닌 곳에 @Inject를 추가할 수 없기 떄문
 * interface나 interface를 implement하는 객체를 constructor injection을 사용하면 compile 오류 발생 (생성자가 없음)
 * ->Hilt가 interface나 implement된 타입의 객체를 어떻게 생성해야할지 알 수가 없다
 **/
/**
 * Constructor Injection 예외 두가지 케이스를 해결하기 위해 Hit 모듈 사용
 * Module을 이용해서 Hilt에게 원하는 Dependency를 생성하는 방법을 알려줌
 * 특히 interface나 외부 라이브러리의 객체처럼 Hilt가 어떻게 객체를 생성할지 모르는 경우 꼭 필요한 방법
 * Module 사용방법엔 Provices와 Binds가 있다.
 */
@Module
@InstallIn(ActivityComponent::class)
class ProvideModule {
    //외부 라이브러리 모듈의 inject를 하기위한 Provides
    @Provides
    @ActivityScoped
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @ActivityScoped
    fun ProvidesOkHttpClient(
        @ApplicationContext context: Context,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder().apply {
            interceptors().add(httpLoggingInterceptor)
        }.build()
}

