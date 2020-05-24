package com.example.in_boxua.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.in_boxua.R
import com.example.in_boxua.TestData
import com.example.in_boxua.data.Goods
import com.example.in_boxua.ui.result.ResultFragment
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_category, null)

        val btPants = view.findViewById<Button>(R.id.bt_pants)
        btPants.setOnClickListener {
            openList(TestData.getPants(),view)
        }

        val btShorts = view.findViewById<Button>(R.id.bt_shorts)
        btShorts.setOnClickListener {
            openList(TestData.getShorts(),view)
        }

        val btTshirts = view.findViewById<Button>(R.id.bt_tshirt)
        btTshirts.setOnClickListener {
            openList(TestData.getTShirts(),view)
        }

        val btShirts = view.findViewById<Button>(R.id.bt_shirts)
        btShirts.setOnClickListener {
            openList(TestData.getShirts(),view)
        }

        return view
    }

    private fun openList(list: List<Goods>, view: View){
        val manager = (view.context as AppCompatActivity).supportFragmentManager
        manager
            .beginTransaction()
            .replace(
                R.id.fl_fragment_container,
                ResultFragment(list)
            )
            .addToBackStack(CategoryFragment().tag)
            .commit()
    }
}