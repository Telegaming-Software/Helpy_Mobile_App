package com.helpy

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE = 1
    var games = ArrayList<Game>()
    var gameAdapter = GameAdapter(games)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadGames()
        initView()
    }

    private fun initView() {
        val rvGames = findViewById<RecyclerView>(R.id.rvGame)

        rvGames.adapter = gameAdapter
        rvGames.layoutManager = LinearLayoutManager(this)
    }

    private fun loadGames() {
        games.add(Game("PUBG"))
        games.add(Game("Fortnite"))
        games.add(Game("Overwatch"))
        games.add(Game("League of Legends"))
        games.add(Game("CS:GO"))
        games.add(Game("Dota 2"))


        /*val retrofit = Retrofit.Builder()
            .baseUrl("https://help-i.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val gameService: GameService
        gameService = retrofit.create(GameService::class.java)

        val request = gameService.getGame("json")

        request.enqueue(object: Callback<Game>{
            override fun onResponse(call: Call<Game>, response: Response<Game>) {
                if (response.isSuccessful) {
                    val name = response.body()!!.name
                    games.add(Game(name))
                }
            }

            override fun onFailure(call: Call<Game>, t: Throwable) {
            }

        })*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, GameActivity::class.java)
        //startActivity(intent)
        startActivityForResult(intent, REQUEST_CODE)
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val nameData = data!!.getStringExtra("keyName")
                val name = nameData.toString()
                val game = Game(name)
                games.add(game)
            }
        }
    }
}