package com.example.retrofitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitproject.adapter.Adapter
import com.example.retrofitproject.model.HoroscopeModel
import com.example.retrofitproject.service.HoroscopeAPI
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(){

    private val BASE_URL="https://project2-9a271.firebaseio.com/"
    private var cryptoModels: ArrayList<HoroscopeModel>?=null
    private var recyclerViewAdapter:Adapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(HoroscopeAPI::class.java)
        val call = service.getData()

        call.enqueue(object : Callback<List<HoroscopeModel>> {
            override fun onResponse(call: Call<List<HoroscopeModel>>, response: Response<List<HoroscopeModel>>) {
                response.body()?.let { cryptoModels?.addAll(it)
                    recyclerViewAdapter = Adapter(it as ArrayList<HoroscopeModel>)
                    recyclerView.adapter = recyclerViewAdapter}
                recyclerView.adapter?.notifyDataSetChanged()
            }
            override fun onFailure(call: Call<List<HoroscopeModel>>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }

}