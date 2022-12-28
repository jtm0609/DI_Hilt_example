package com.example.ditestapplication.interfaceImpl

import com.example.ditestapplication.Interface.Department
import javax.inject.Inject

/**
 * Module에서 Provides와 Binds를 이용하여 Hilt에게 원하는 Dependency를 생성하는 방법을 알려줄 수 있다.
 * Binds: 외부 라이브러이리에는 사용할 수 없다.(추상클래스이므로)
@Binds는 constructor를 가질 수 없는 인터페이스에 대한 종속성 삽입의 경우에 사용한다.
따로 구현이 필요 없을 경우 @Provides대신 사용한다.
함수 Return type : 인스턴스(Instance)로 제공되는 인터페이스
함수 매개변수(Parameter) : 실제 제공하는 클래스(구현)


 * Provides와 마찬가지로 @Module을 붙여주고 abstract class를 만든 다음 abstract 함수를 정의해주면 된다.
@Provides는 Room, Retrofit과 같은 외부 라이브러리에서 제공되는 클래스이므로 프로젝트 내에서 소유할 수 없는 경우 또는 Builder 패턴 등을 통해 인스턴스를 생성해야 하는 경우에 사용한다.

함수 Return type : 제공하는 인스턴스
함수 매개변수(Parameter) : 인스턴스의 종속 항목
함수 Body: 인스턴스를 제공하는 방법
 */


class LotteDepartment @Inject constructor(): Department {
    override fun doTest(): String {
        return "LotteDepartment is interface Injection"
    }
}