package id.ac.polbeng.farid.mfaridamirul_6304191190.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.polbeng.farid.mfaridamirul_6304191190.helpers.Config
import id.ac.polbeng.farid.mfaridamirul_6304191190.models.DataCovid
import id.ac.polbeng.farid.mfaridamirul_6304191190.services.DataCovidService
import id.ac.polbeng.farid.mfaridamirul_6304191190.services.ServiceBuilder
import retrofit2.Call

class MainViewModel : ViewModel() {
    companion object {
        val TAG: String = MainViewModel::class.java.simpleName
    }
    private val _dataCovid = MutableLiveData<DataCovid>()
    val datacovid: LiveData<DataCovid> = _dataCovid
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    init {
        searchUser(Config.DEFAULT_NAMA_PROVINSI)
    }
    fun searchUser(query: String){
        _isLoading.value = true
        Log.d(TAG, "getDataUserProfileFromAPI: start...")
        val githubUserService: DataCovidService = ServiceBuilder.buildService(DataCovidService::class.java)
        val requestCall: Call<DataCovid> = githubUserService.data_covid(query)
        Log.d(TAG, "getDataUserFromAPI: ${requestCall.request().url}")
        requestCall.enqueue(object : retrofit2.Callback<DataCovid> {
            override fun onResponse(call: Call<DataCovid>, response: retrofit2.Response<DataCovid>) {
                _isLoading.value = false
                if(response.isSuccessful){
                    val result = response.body()
                    Log.d(TAG, result.toString())
                    _dataCovid.postValue(result)
                    Log.d(TAG, "getDataUserFromAPI: onResponse finish...")
                }else{
                    Log.d(TAG, "getDataUserFromAPI: onResponse failed...")
                }
            }
            override fun onFailure(call: Call<DataCovid>, t: Throwable) {
                _isLoading.value = false
                Log.d(TAG, "getDataUserFromAPI: onFailure ${t.message}...")
            }
        })
    }

}