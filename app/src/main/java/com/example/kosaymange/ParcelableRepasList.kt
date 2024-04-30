package com.example.kosaymange

import android.os.Parcel
import android.os.Parcelable

class ParcelableRepasList(val list: ArrayList<Repas>) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(Repas.CREATOR)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(list)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ParcelableRepasList> {
        override fun createFromParcel(parcel: Parcel): ParcelableRepasList {
            return ParcelableRepasList(parcel)
        }

        override fun newArray(size: Int): Array<ParcelableRepasList?> {
            return arrayOfNulls(size)
        }
    }
}
