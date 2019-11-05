package br.s.forceorientation

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var names = arrayListOf<String>()
    private var adapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this, android.R.layout.simple_selectable_list_item, names)
        listview.adapter = adapter
        btn.setOnClickListener {
            btn.isEnabled = false
            add_new_name(editext_name.text.toString())
        }
    }

    private fun add_new_name(name: String){
        if(name == "" || name.length <= 2){
            Toast.makeText(this, getString(R.string.main_alert_name_blank_or_invalid_caracter), Toast.LENGTH_SHORT).show()
            btn.isEnabled = true
            return
        }
        names.add(name)
        editext_name.text.clear()
        adapter?.notifyDataSetChanged()
        btn.isEnabled = true
    }



}
