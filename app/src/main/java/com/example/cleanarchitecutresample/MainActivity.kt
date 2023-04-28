package com.example.cleanarchitecutresample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitecutresample.coordinator.UserCoordinator
import com.example.cleanarchitecutresample.datastore.request.UserRequestFactory
import com.example.cleanarchitecutresample.presenter.UserPresenter
import com.example.cleanarchitecutresample.repository.UserRepository
import com.example.cleanarchitecutresample.usecase.UserUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var coordinator: UserCoordinator
    private lateinit var presenter: UserPresenter

    fun inject(presenter: UserPresenter) {
        this.presenter = presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coordinator.inject(this)

        setupData()
    }

    private fun setupData() {
        presenter.getUser()
    }
}