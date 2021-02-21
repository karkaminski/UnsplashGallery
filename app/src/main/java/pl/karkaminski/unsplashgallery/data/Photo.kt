package pl.karkaminski.unsplashgallery.data

data class Photo(
    val id: String,
    val description: String,
    val urls: Urls,
//    val user: User
) {
    data class Urls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    )

}