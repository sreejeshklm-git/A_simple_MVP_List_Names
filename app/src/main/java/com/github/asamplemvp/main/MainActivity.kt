package com.github.asamplemvp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.asamplemvp.R
import com.github.asamplemvp.model.Employee

class MainActivity : AppCompatActivity(),MainContract.View {
    lateinit var mainPresenter: MainPresenter
    var empRView: RecyclerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        empRView=findViewById(R.id.recyclerView)
        var mainPresenter= MainPresenter(this)
        mainPresenter.getEmpDetails()
    }

    override fun listEmpDtls(empList: ArrayList<Employee>) {
        var adapter = MainAdapter(this, empList.toMutableList())
        empRView!!.setLayoutManager(LinearLayoutManager(this))
        empRView!!.setAdapter(adapter)
    }
}