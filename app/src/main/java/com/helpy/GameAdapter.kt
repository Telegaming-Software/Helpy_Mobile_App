package com.helpy

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(var games: ArrayList<Game>): RecyclerView.Adapter<GamePrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamePrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_game, parent, false)

        return GamePrototype(view)
    }

    override fun onBindViewHolder(holder: GamePrototype, position: Int) {
        holder.bind(games.get(position))
    }

    override fun getItemCount(): Int {
        return games.size
    }

}

class GamePrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.findViewById<TextView>(R.id.tvName)
    //val ivLogo = itemView.findViewById<TextView>(R.id.ivLogo)

    fun bind(game: Game) {
        tvName.text = game.name
        //ivLogo.text = game.backgroundImageUrl
    }
}