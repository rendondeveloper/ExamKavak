package com.example.kavakexam.dto.friends.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kavakexam.R
import com.example.kavakexam.dto.friends.pojo.FriendsItem
import com.squareup.picasso.Picasso

class AdapterFriends (private val list : List<FriendsItem>)
    : RecyclerView.Adapter<AdapterFriends.ViewHolder>() {;

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvName : TextView = view.findViewById(R.id.tvName)
        val tvAge : TextView = view.findViewById(R.id.tvAge)
        val tvProfessions : TextView = view.findViewById(R.id.tvProfessions)
        val ivFaceUser : ImageView = view.findViewById(R.id.ivFaceUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = this.list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : FriendsItem = this.list[position]

        holder.tvName.text = item.name
        holder.tvAge.text = item.age.toString()
        holder.tvProfessions.text = contactProfessions(item.professions)

        Picasso
        .get()
        .load(item.thumbnail)
        .error(R.drawable.ic_error)
        .into(holder.ivFaceUser);
    }

    fun contactProfessions(list : List<String>): String{
        var professions : String = ""

        var counter : Int = 0
        for (item in list){
            counter++;
            if(counter < 3) {
                professions += "$item, "
            }else {
                professions += "$item..."
                break;
            }
        }
        return professions;
    }
}