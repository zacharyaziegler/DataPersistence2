package edu.farmingdale.alrajab.bcs421.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.farmingdale.alrajab.bcs421.R

class MainActivity2 : AppCompatActivity() {

    private lateinit var dbHelper:NameRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        dbHelper= NameRepository.getInstance(this)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        var dt= dbHelper.getAll() as ArrayList<User>
        dbHelper.getAll().forEach { Log.d("Data","Waww"+it.firstName+" , "+ it.lastName) }
        var adapter  = DBAdapter(dt)



        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }


    class DBAdapter(private val nameReading: ArrayList<User>) :
        RecyclerView.Adapter<DBAdapter.ViewHolder>() {
        //Implementation of the ViewHolder Class
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val fnameTextView: TextView
            val lnameTextView: TextView
            init {
                fnameTextView = view.findViewById(R.id.firstname)
                lnameTextView = view.findViewById(R.id.lastname)
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // create new view with UI of weather item
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.singleitemlayout, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //set element from weather data [using position] to TextView
            holder.fnameTextView.text = nameReading[position].firstName
            holder.lnameTextView.text = nameReading[position].lastName

        }
        override fun getItemCount()= nameReading.size

    }

}