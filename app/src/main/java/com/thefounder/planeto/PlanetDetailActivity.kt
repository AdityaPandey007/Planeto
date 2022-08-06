package com.thefounder.planeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_planet_detail.*

class PlanetDetailActivity : AppCompatActivity() {

    private lateinit var obj : PlanetData
    private  var planetImg : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_detail)

        obj = intent.getParcelableExtra("planet")!!
        planetImg = intent.getIntExtra("planetImage",-1)
        setData(obj , planetImg!!)

        button_info.setOnClickListener {

            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, " Congratulations !!! Your Planet Ride has been booked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setData(obj : PlanetData , planetImg : Int) {

        title_info.text = obj.title
        distance_info.text = obj.distance + "m km"
        gravity_info.text = obj.gravity + "m/ss"

        overview_info.text = obj.overView
        galaxy_info.text = obj.galaxy
        planet_info_img.setImageResource(planetImg)
    }
}