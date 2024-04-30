package com.example.kosaymange

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class fragment_week : Fragment() {
    companion object {
        private const val ARG_REPAS_LIST = "repasList"

        fun newInstance(repasList: ParcelableRepasList): fragment_week {
            val fragment = fragment_week()
            val args = Bundle()
            args.putParcelable(ARG_REPAS_LIST, repasList)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var repasArrayList: ArrayList<Repas>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_2_fragment_week, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Récupérez la liste de repas passée en argument
        val repasList: ArrayList<Repas>? = arguments?.getParcelableArrayList(ARG_REPAS_LIST)

        // Vérifiez si la liste de repas n'est pas nulle
        if (repasList != null) {
            repasArrayList = repasList

            // Initialisez et configurez le RecyclerView avec la liste de repas
            recyclerView = view.findViewById(R.id.weekRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setHasFixedSize(true)

            // Utilisez WeekAdapter au lieu de RepasAdapter
            recyclerView.adapter = WeekAdapter(repasArrayList)
        }
    }
}