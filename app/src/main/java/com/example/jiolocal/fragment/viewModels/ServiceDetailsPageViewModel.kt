package com.example.jiolocal.fragment.viewModels

import androidx.lifecycle.ViewModel

class ServiceDetailsPageViewModel : ViewModel() {

    fun getImageLists(): List<String> {
        val imagesUrls = ArrayList<String>()
        imagesUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLQB6EzkBjTCEEjIwA5XmJWyANhjMyBm8juw&usqp=CAU")
        imagesUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQRdyoB8nGPfMG47er98AaK4mSEKXgfStmIA&usqp=CAU")
        imagesUrls.add("data:image/jpeg;base64,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")

        return imagesUrls
    }

    fun getOurServicesData() : List<Any> {
        val categoryList = ArrayList<String>()
        categoryList.add("3 summer offers")
        categoryList.add("Monthly essentials")
        categoryList.add("Facials and spa")

        return categoryList
    }
}