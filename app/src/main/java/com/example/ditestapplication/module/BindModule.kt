package com.example.ditestapplication.module

import com.example.ditestapplication.Interface.Department
import com.example.ditestapplication.Interface.Store
import com.example.ditestapplication.interfaceImpl.BookStore
import com.example.ditestapplication.interfaceImpl.ClothingStore
import com.example.ditestapplication.interfaceImpl.LotteDepartment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier


/**
 * Module: 다양한 타입들을 어떻게 Hilt가 제공하는가 명세
 * -> 생성자 주입을 사용항수 없는 상황(ex. 인터페이스, 외부라이브러리의 클래스)
 * -> 인터페이스와 같이 생성자로 인스턴스를 생성할 수 없는 바인딩 유형을 Hilt 모듈에 추가한다.
 * 이 모듈은 의존성 인스턴스를 제공하는 방법을 Hilt에 알려주는 역할을 합니다.
 *
 * InstallIn: 어떤 컴포넌트에서 제공할 모듈인지 명세
 * Named(Qualifiers): 같은 타입의 다른 인스턴스를 제공하고 싶다면?
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class BindModule {
    @Qualifier
    annotation class BookStoreQualifer

    @Qualifier
    annotation class ClothingStoreQualifer

    @BookStoreQualifer
    @Binds
    abstract fun bookStoreImplBind(impl: BookStore): Store

    @ClothingStoreQualifer
    @Binds
    abstract fun clothingStoreImpl(impl: ClothingStore): Store

    @Binds
    @ActivityScoped
    abstract fun lotteDepartmentImplBind(impl: LotteDepartment): Department
}