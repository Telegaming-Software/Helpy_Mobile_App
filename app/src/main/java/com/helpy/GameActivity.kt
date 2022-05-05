package com.helpy

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.game_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        saveGame()
        return super.onOptionsItemSelected(item)
    }

    private fun saveGame() {
        val name_xml = findViewById<EditText>(R.id.etNameInput)
        val name = name_xml.text.toString()

        val intent = Intent()
        intent.putExtra("keyName", name)

        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}