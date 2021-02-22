package pl.karkaminski.unsplashgallery.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: String,
    val username: String,
    val name: String,
) : Parcelable