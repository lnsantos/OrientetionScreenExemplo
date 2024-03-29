package br.s.forceorientation

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Search about onRetatinCustomNonConfigurationInstance
    // arrayListOf is at list mutable
    // listOf is at list imutable

    private var names = arrayListOf<String>()
    private var adapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            // if screen for destroyed, we go recover the value of list
            //            to not louse information of list
            names = savedInstanceState.getStringArrayList("names") as ArrayList<String>
        }

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putStringArrayList("names", names)
    }



}
