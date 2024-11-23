package com.example.assignment.presentation.uiState

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.dataLayer.repocitory.RemoteRepository
import com.example.assignment.domainLayer.food.FoodDetail
import com.example.assignment.domainLayer.home.HomeDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface HomeState{
    object Loading: HomeState
    data class Success(val homeDetail: HomeDetail): HomeState
    data class Error(val message: String): HomeState
}
sealed interface FoodState{
    object Loading: FoodState
    data class Success(val foodDetail: FoodDetail): FoodState
    data class Error(val message: String) : FoodState
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository
): ViewModel() {
    // mutable state flow not for display in ui
    private val  _homeState = MutableStateFlow<HomeState>(HomeState.Loading)
    private val _foodScreen  = MutableStateFlow<FoodState>(FoodState.Loading)

    // Un mutable state for display in ui
    val homeState = _homeState.onStart {
        getHomeDetailData()
    } .stateIn(viewModelScope , SharingStarted.WhileSubscribed(), HomeState.Loading)

    val foodState = _foodScreen.onStart {
        getFoodDetailData()
        }.stateIn(viewModelScope , SharingStarted.WhileSubscribed(2000), FoodState.Loading)

    fun getHomeDetailData(){
        viewModelScope.launch{
            try {
                _homeState.value =
                    HomeState.Success(remoteRepository.getHomeDetail())
            }catch (e: Exception){
                _homeState.value =
                    HomeState.Error(e.message.toString())
            }
        }
    }

    fun getFoodDetailData(){
        viewModelScope.launch{
            try {
                _foodScreen.value =
                    FoodState.Success(remoteRepository.getFoodDetail())
            }catch (e: Exception){
                _foodScreen.value=
                    FoodState.Error(e.message.toString())
            }
        }
    }

}