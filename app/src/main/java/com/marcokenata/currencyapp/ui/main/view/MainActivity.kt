package com.marcokenata.currencyapp.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcokenata.currencyapp.R
import com.marcokenata.currencyapp.data.model.User
import com.marcokenata.currencyapp.ui.main.adapter.MainAdapter
import com.marcokenata.currencyapp.ui.main.viewmodel.MainViewModel
import com.marcokenata.currencyapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        rv_main.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        rv_main.addItemDecoration(
            DividerItemDecoration(
                rv_main.context,
                (rv_main.layoutManager as LinearLayoutManager).orientation
            )
        )
        rv_main.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.users.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    rv_main.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    rv_main.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }


}