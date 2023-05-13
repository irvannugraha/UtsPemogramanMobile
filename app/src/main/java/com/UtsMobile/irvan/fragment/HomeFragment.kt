package com.UtsMobile.irvan.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UtsMobile.irvan.DetailMovieActivity
import com.UtsMobile.irvan.Movie
import com.UtsMobile.irvan.MovieAdapter
import com.UtsMobile.irvan.R


class ExploreFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList: ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MovieAdapter(movieArrayList){
            val intent = Intent(context,DetailMovieActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.miku1,
            R.drawable.keqing,
            R.drawable.kurumi,
            R.drawable.asuna,
            R.drawable.kaoricicak,
            R.drawable.megumin,
            R.drawable.mitsuha,
            R.drawable.rika,
            R.drawable.tsukasa,
            R.drawable.nero,


            )
        title = arrayOf(
            getString(R.string.miku),
            getString(R.string.keqing),
            getString(R.string.kurumi),
            getString(R.string.asuna),
            getString(R.string.kaoricicak),
            getString(R.string.megumin),
            getString(R.string.mitsuha),
            getString(R.string.rika),
            getString(R.string.tsukasa),
            getString(R.string.nero),

        )
        descriptions = arrayOf(
            getString(R.string.miku),
            getString(R.string.keqing),
            getString(R.string.kurumi),
            getString(R.string.asuna),
            getString(R.string.kaoricicak),
            getString(R.string.megumin),
            getString(R.string.mitsuha),
            getString(R.string.rika),
            getString(R.string.tsukasa),
            getString(R.string.nero),

        )
        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }
    }
}