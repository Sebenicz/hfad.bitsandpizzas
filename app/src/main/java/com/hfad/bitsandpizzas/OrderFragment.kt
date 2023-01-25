package com.hfad.bitsandpizzas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            val pizzaGroup = view.findViewById<RadioGroup>(R.id.pizza_group)
            val pizzaType = pizzaGroup.checkedRadioButtonId
            if(pizzaType == -1){
                Toast.makeText(activity, "No pizza selected xD", Toast.LENGTH_SHORT).show()
            }else{
                var text = (when (pizzaType) {
                    R.id.radio_diavolo -> "Diavolo pizza"
                    else -> "Funghi pizza"
                })
                val pineapple = view.findViewById<Chip>(R.id.pineapple)
                text += if(pineapple.isChecked) ", extra pineapple" else ""
                val pear = view.findViewById<Chip>(R.id.pear)
                text += if(pear.isChecked) ", extra pear" else ""
                Snackbar.make(fab, text, Snackbar.LENGTH_LONG).show()
            }
        }
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        return view
    }
}