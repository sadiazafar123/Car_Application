package com.example.carapplication.datamodel.user

import android.os.Parcel
import android.os.Parcelable


data class VahicleInfo(
    val carName:String,
    val carType:String,
    val carColor:String
    //@PrimaryKey(autoGenerate = false) val id:Int?=null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(carName)
        parcel.writeString(carType)
        parcel.writeString(carColor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VahicleInfo> {
        override fun createFromParcel(parcel: Parcel): VahicleInfo {
            return VahicleInfo(parcel)
        }

        override fun newArray(size: Int): Array<VahicleInfo?> {
            return arrayOfNulls(size)
        }
    }
}
