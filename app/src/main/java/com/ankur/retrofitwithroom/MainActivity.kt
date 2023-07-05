package com.ankur.retrofitwithroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ankur.retrofitwithroom.databinding.ActivityMainBinding
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RecyclerView.layoutManager=LinearLayoutManager(this)
        dataFromApi()




    }

    private fun dataFromApi() {


       lifecycleScope.launch(Dispatchers.IO) {
           val result = ApiUtilities.getInstance().create(ApiInterface::class.java).getData()

           if (result.body() != null) {

               Log.d("AJJA","RESPONSE IS ${result.body()!!}")

               withContext(Dispatchers.Main)
               {
                   binding.RecyclerView.adapter = Adapter(this@MainActivity, result.body()!!)
               }
           }
       }





    }
}