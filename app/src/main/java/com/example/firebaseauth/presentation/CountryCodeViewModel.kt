package com.example.firebaseauth.presentation

import androidx.lifecycle.ViewModel
import com.example.firebaseauth.presentation.util.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CountryCodeViewModel @Inject constructor() : ViewModel() {
    private var _country = MutableStateFlow(Country.BY)
    val country = _country.asStateFlow()

    fun updateCountry(newCountry: Country){
        _country.update {
            newCountry
        }
    }

    fun getCountryCode() = country.value.code
}