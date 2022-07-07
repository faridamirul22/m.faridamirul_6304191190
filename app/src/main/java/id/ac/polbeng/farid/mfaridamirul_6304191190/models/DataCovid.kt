package id.ac.polbeng.farid.mfaridamirul_6304191190.models

data class DataCovid(
	val penambahan: Penambahan? = null,
	val docCount: Double? = null,
	val lokasi: Lokasi? = null,
	val jumlahMeninggal: Int? = null,
	val kelompokUmur: List<KelompokUmurItem?>? = null,
	val jumlahKasus: Int? = null,
	val jumlahSembuh: Int? = null,
	val jenisKelamin: List<JenisKelaminItem?>? = null,
	val lastDate: String? = null,
	val key: String? = null,
	val jumlahDirawat: Int? = null
)

data class Usia(
	val value: Double? = null
)

data class JenisKelaminItem(
	val docCount: Int? = null,
	val key: String? = null
)

data class Lokasi(
	val lon: Double? = null,
	val lat: Double? = null
)

data class KelompokUmurItem(
	val usia: Usia? = null,
	val docCount: Int? = null,
	val key: String? = null
)

data class Penambahan(
	val meninggal: Int? = null,
	val positif: Int? = null,
	val sembuh: Int? = null
)

