package com.example.changecolor

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    lateinit var tvCount : TextView
    lateinit var binding : ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
       
        binding.btnAlert.SetOnClickListener {
            
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Select Color")
            alertDialog.setMessage("Select aAlertDialo color that you want to set as fragment background")
            alertDialog.setPositiveButton("Blue") { _, _ ->
                replaceFragment(Fragment1())
            }
            alertDialog.setNegativeButton("Red") { _, _ ->
                replaceFragment(Fragment2())
            }
            alertDialog.setNeutralButton("Yellow") { _, _ ->
                replaceFragment(Fragment3())
            }
            alertDialog.show()

        }


    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()



    }
}

private fun Any.SetOnClickListener(function: () -> AlertDialog) {

}


