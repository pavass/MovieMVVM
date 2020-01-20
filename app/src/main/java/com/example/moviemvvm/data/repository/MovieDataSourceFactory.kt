package com.example.moviemvvm.data.repository

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import com.example.moviemvvm.data.api.TheMovieDBInterface
import com.example.moviemvvm.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable
import androidx.paging.DataSource

class MovieDataSourceFactory (private val apiService : TheMovieDBInterface, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService,compositeDisposable)

        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }

}