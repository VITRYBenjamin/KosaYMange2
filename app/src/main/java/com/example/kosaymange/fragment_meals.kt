package com.example.kosaymange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class fragment_meals : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var repasArrayList: ArrayList<Repas>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_2_fragment_meals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.mealRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        // Set up your RepasModels here (repasArrayList)
        setUpRepasModels()

        // Set up adapter
        recyclerView.adapter = RepasAdapter(repasArrayList)
    }

    private fun setUpRepasModels() {
        repasArrayList = ArrayList()
        val repasNames = ArrayList(resources.getStringArray(R.array.repas_name_txt).toList())
        val repasImage = ArrayList(resources.getIntArray(R.array.repas_image_txt).toList())
        for (i in 0 until repasNames.size) {
            repasArrayList.add(Repas(repasNames[i], repasImage[i]))
        }
    }
}