package com.example.jiolocal.fragment

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.jiolocal.Repositories.DataRepo

class LocalDashBoardViewModel() : ViewModel() {

lateinit var dataRepository : DataRepo

    fun getAllData() : List<Any> {
        dataRepository = DataRepo()
        val finalList = ArrayList<Any>()
        finalList.add(dataRepository.getOffers())
        finalList.add(dataRepository.getServicesList())
        finalList.add(dataRepository.getTheTopOffersLists())
        finalList.add(dataRepository.getPopularServices())
        finalList.add(dataRepository.getRecentlyViewed())
        return finalList
    }
}