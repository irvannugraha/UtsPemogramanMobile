package com.UtsMobile.irvan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Movie(
     var imageMovie: Int,
     var titleMovie: String,
     var descMovie: String
     ) : Parcelable