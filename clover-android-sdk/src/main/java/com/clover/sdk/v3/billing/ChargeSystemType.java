/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */


package com.clover.sdk.v3.billing;

import android.os.Parcelable;
import android.os.Parcel;

@SuppressWarnings("all")
public enum ChargeSystemType implements Parcelable {
  BRAINTREE, INFOLEASE;

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(final Parcel dest, final int flags) {
    dest.writeString(name());
  }

  public static final Creator<ChargeSystemType> CREATOR = new Creator<ChargeSystemType>() {
    @Override
    public ChargeSystemType createFromParcel(final Parcel source) {
      return ChargeSystemType.valueOf(source.readString());
    }

    @Override
    public ChargeSystemType[] newArray(final int size) {
      return new ChargeSystemType[size];
    }
  };
}
