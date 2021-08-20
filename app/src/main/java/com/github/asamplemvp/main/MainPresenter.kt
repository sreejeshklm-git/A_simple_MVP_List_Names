package com.github.asamplemvp.main

import com.github.asamplemvp.model.Employee
import org.json.JSONArray
import org.json.JSONObject

class MainPresenter(v: MainActivity) {
   var  view= v

   //considering this data from local data base
   val localData="{\"employee\":[{ \"id\":101,\"name\":\"name1\",\"email\":\"name1@test.com\"}," +
           "{ \"id\":102,\"name\":\"name2\",\"email\":\"\name2@test.com\"}," +
           "{ \"id\":104,\"name\":\"name4\",\"email\":\"name4@test.com\"}," +
           "{ \"id\":106,\"name\":\"name6\",\"email\":\"name6@test.com\"}," +
           "{ \"id\":108,\"name\":\"name8\",\"email\":\"name8@test.com\"}]}"


   //considering this data from remote
    val remoteData="{\"employee\":[{ \"id\":101,\"name\":\"name1\",\"email\":\"name1@test.com\"}," +
            "{ \"id\":102,\"name\":\"name2\",\"email\":\"name2@test.com\"}," +
            "{ \"id\":103,\"name\":\"name3\",\"email\":\"name3@test.com\"}," +
            "{ \"id\":104,\"name\":\"name4\",\"email\":\"name4@test.com\"}," +
            "{ \"id\":105,\"name\":\"name5\",\"email\":\"name5@test.com\"}," +
            "{ \"id\":106,\"name\":\"name6\",\"email\":\"name6@test.com\"}," +
            "{ \"id\":107,\"name\":\"name7\",\"email\":\"name7@test.com\"}," +
            "{ \"id\":108,\"name\":\"name8\",\"email\":\"name8@test.com\"}]}"


  fun getEmpDetails() {

     var empList= ArrayList<Employee>()
      var sortedEmpList= ArrayList<Employee>()
     //Adding local data to array list
     val localJObject = JSONObject(localData)
      val localEmp: JSONArray = localJObject.getJSONArray("employee")
      for (i in 0 until localEmp.length()) {
          val localEmpDtl = localEmp.getJSONObject(i)
          var emp=Employee(localEmpDtl.getInt("id"),localEmpDtl.getString("name"),localEmpDtl.getString("email"))
          empList.add(emp)
      }

      //Adding remote  data to array list
      val remoteJObject = JSONObject(remoteData)
      val remoteEmp: JSONArray = remoteJObject.getJSONArray("employee")
      for (i in 0 until remoteEmp.length()) {
          val remoteEmpDtl = remoteEmp.getJSONObject(i)
          var emp=Employee(remoteEmpDtl.getInt("id"),remoteEmpDtl.getString("name"),remoteEmpDtl.getString("email"))
          //checking employee already in the list (local)
          if(!empList.contains(emp)) {
              empList.add(emp)
          }
      }

      //call view method
      view.listEmpDtls(empList)

    }
}