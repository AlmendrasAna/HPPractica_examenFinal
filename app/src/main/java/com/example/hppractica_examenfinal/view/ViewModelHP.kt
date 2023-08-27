package com.example.hppractica_examenfinal.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.hppractica_examenfinal.data.Repository
import com.example.hppractica_examenfinal.data.local.DBHarryPotter
import com.example.hppractica_examenfinal.data.remoto.RetrofitClientHP
import kotlinx.coroutines.launch

class ViewModelHP(application: Application) : AndroidViewModel(application) {

    private val repository: Repository

    fun charactersLiveData() = repository.showCharacterEntityList()

    init {
        val api = RetrofitClientHP.getRetrofitHP()
        val dBHarryPotter = DBHarryPotter.getDatabase(application).getDaoHP()
        repository = Repository(api, dBHarryPotter)
    }

    fun getAllProducts() = viewModelScope.launch {
        repository.loadAllCharacter()
    }

}