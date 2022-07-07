package id.ac.polbeng.farid.mfaridamirul_6304191190.services

import id.ac.polbeng.farid.mfaridamirul_6304191190.models.DataCovid
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DataCovidService {
    @GET("data_covid/{key}")
    fun data_covid(
        @Path("key")data_covid:String
    ): Call<DataCovid>
}