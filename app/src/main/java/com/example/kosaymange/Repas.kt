package com.example.kosaymange

import android.os.Parcel
import android.os.Parcelable

class Repas(
    var repasName: String,
    var repasImage: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(repasName)
        parcel.writeInt(repasImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Repas> {
        override fun createFromParcel(parcel: Parcel): Repas {
            return Repas(parcel)
        }

        override fun newArray(size: Int): Array<Repas?> {
            return arrayOfNulls(size)
        }
    }
}
