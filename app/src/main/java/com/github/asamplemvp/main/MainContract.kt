package com.github.asamplemvp.main

import com.github.asamplemvp.model.Employee

class MainContract {
    interface View {
        fun listEmpDtls(empList: ArrayList<Employee>)
    }

}