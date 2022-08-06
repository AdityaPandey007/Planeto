package com.thefounder.planeto

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class PlanetoAdapter(val planet : List<PlanetData>) : RecyclerView.Adapter<PlanetoAdapter.myViewHolder>() {

    class myViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var title = itemView.planetName
        var planet_img = itemView.planetImg
        var galaxy = itemView.galaxy
        var distance = itemView.distance
        var gravity = itemView.gravity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.view,parent, false)

        return myViewHolder(view)
    }


    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        var dummyImage:Int? = null
        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context , PlanetDetailActivity::class.java)
            intent.putExtra("planet", planet[position])
            intent.putExtra("planetImage" , dummyImage)

            holder.itemView.context.startActivity(intent)

        }

        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance + " =km"
        holder.gravity.text = planet[position].gravity + "m/ss"


        when(planet[position].title!!.toLowerCase()){

            "mars" -> {
                dummyImage = R.drawable.ic_mars
            }

            "neptune" -> {
                dummyImage = R.drawable.ic_neptune
            }

            "earth" -> {

                dummyImage = R.drawable.ic_earth
            }

            "jupiter" -> {

                dummyImage = R.drawable.ic_jupiter
            }

            "mercury" -> {

                dummyImage = R.drawable.ic_mercury
            }

            "moon" ->{

                dummyImage = R.drawable.ic_moon
            }

            "saturn" -> {

                dummyImage = R.drawable.ic_saturn
            }

            "sun" -> {

                dummyImage = R.drawable.ic_sun
            }

            "uranus" -> {

                dummyImage =R.drawable.ic_uranus
            }

            "venus" -> {

                dummyImage =R.drawable.ic_venus
            }
        }

        holder.planet_img.setImageResource(dummyImage!!)
    }


    override fun getItemCount(): Int {

       return planet.size
    }
}
