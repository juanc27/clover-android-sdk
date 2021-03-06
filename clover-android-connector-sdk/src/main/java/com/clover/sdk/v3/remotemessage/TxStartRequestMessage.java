/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */


/*
 * Copyright (C) 2016 Clover Network, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.clover.sdk.v3.remotemessage;

import com.clover.sdk.GenericClient;

/**
 * This is an auto-generated Clover data object.
 * <p>
 * <h3>Fields</h3>
 * <ul>
 * <li>{@link #getSuppressOnScreenTips suppressOnScreenTips}</li>
 * <li>{@link #getOrder order}</li>
 * <li>{@link #getPayIntent payIntent}</li>
 * </ul>
 */
@SuppressWarnings("all")
public class TxStartRequestMessage extends com.clover.sdk.v3.remotemessage.Message {

  /**
   * If true, then tips on the screen should not be displayed.
   */
  public java.lang.Boolean getSuppressOnScreenTips() {
    return genClient.cacheGet(CacheKey.suppressOnScreenTips);
  }

  /**
   * The order
   */
  public com.clover.sdk.v3.order.Order getOrder() {
    return genClient.cacheGet(CacheKey.order);
  }

  /**
   * The payIntent
   */
  public com.clover.sdk.v3.remotemessage.PayIntent getPayIntent() {
    return genClient.cacheGet(CacheKey.payIntent);
  }

  /**
   * The list of message types
   */
  @Override
  public com.clover.sdk.v3.remotemessage.Method getMethod() {
    return genClient.cacheGet(CacheKey.method);
  }

  /**
   * The version of this message
   */
  @Override
  public java.lang.Integer getVersion() {
    return genClient.cacheGet(CacheKey.version);
  }




  private enum CacheKey implements com.clover.sdk.ValueExtractorEnum<TxStartRequestMessage> {
    suppressOnScreenTips {
      @Override
      public Object extractValue(TxStartRequestMessage instance) {
        return instance.genClient.extractOther("suppressOnScreenTips", java.lang.Boolean.class);
      }
    },
    order {
      @Override
      public Object extractValue(TxStartRequestMessage instance) {
        return instance.genClient.extractRecord("order", com.clover.sdk.v3.order.Order.JSON_CREATOR);
      }
    },
    payIntent {
      @Override
      public Object extractValue(TxStartRequestMessage instance) {
        return instance.genClient.extractRecord("payIntent", com.clover.sdk.v3.remotemessage.PayIntent.JSON_CREATOR);
      }
    },
    method {
      @Override
      public Object extractValue(TxStartRequestMessage instance) {
        return instance.genClient.extractEnum("method", com.clover.sdk.v3.remotemessage.Method.class);
      }
    },
    version {
      @Override
      public Object extractValue(TxStartRequestMessage instance) {
        return instance.genClient.extractOther("version", java.lang.Integer.class);
      }
    },
      ;
  }

  private GenericClient<TxStartRequestMessage> genClient;

  /**
  * Constructs a new empty instance.
  */
  public TxStartRequestMessage() {
    super(false);
    genClient = new GenericClient<TxStartRequestMessage>(this);
    this.setMethod(com.clover.sdk.v3.remotemessage.Method.TX_START);
  }

  @Override
  protected GenericClient getGenericClient() {
    return genClient;
  }

  /**
  * Constructs a new empty instance.
  */
  protected TxStartRequestMessage(boolean noInit) {
    super(false);
    genClient = null;
  }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public TxStartRequestMessage(String json) throws IllegalArgumentException {
    this();
    try {
      genClient.setJsonObject(new org.json.JSONObject(json));
    } catch (org.json.JSONException e) {
      throw new IllegalArgumentException("invalid json", e);
    }
  }

  /**
   * Construct a new instance backed by the given JSONObject, the parameter is not copied so changes to it will be
   * reflected in this instance and vice-versa.
   */
  public TxStartRequestMessage(org.json.JSONObject jsonObject) {
    this();
    genClient.setJsonObject(jsonObject);
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public TxStartRequestMessage(TxStartRequestMessage src) {
    this();
    if (src.genClient.getJsonObject() != null) {
      genClient.setJsonObject(com.clover.sdk.v3.JsonHelper.deepCopy(src.genClient.getJSONObject()));
    }
  }

  /**
   * Returns the internal JSONObject backing this instance, the return value is not a copy so changes to it will be
   * reflected in this instance and vice-versa.
   */
  public org.json.JSONObject getJSONObject() {
    return genClient.getJSONObject();
  }

  @Override
  public void validate() {
  }

  /** Checks whether the 'suppressOnScreenTips' field is set and is not null */
  public boolean isNotNullSuppressOnScreenTips() {
    return genClient.cacheValueIsNotNull(CacheKey.suppressOnScreenTips);
  }

  /** Checks whether the 'order' field is set and is not null */
  public boolean isNotNullOrder() {
    return genClient.cacheValueIsNotNull(CacheKey.order);
  }

  /** Checks whether the 'payIntent' field is set and is not null */
  public boolean isNotNullPayIntent() {
    return genClient.cacheValueIsNotNull(CacheKey.payIntent);
  }

  /** Checks whether the 'method' field is set and is not null */
  @Override
  public boolean isNotNullMethod() {
    return genClient.cacheValueIsNotNull(CacheKey.method);
  }

  /** Checks whether the 'version' field is set and is not null */
  @Override
  public boolean isNotNullVersion() {
    return genClient.cacheValueIsNotNull(CacheKey.version);
  }



  /** Checks whether the 'suppressOnScreenTips' field has been set, however the value could be null */
  public boolean hasSuppressOnScreenTips() {
    return genClient.cacheHasKey(CacheKey.suppressOnScreenTips);
  }

  /** Checks whether the 'order' field has been set, however the value could be null */
  public boolean hasOrder() {
    return genClient.cacheHasKey(CacheKey.order);
  }

  /** Checks whether the 'payIntent' field has been set, however the value could be null */
  public boolean hasPayIntent() {
    return genClient.cacheHasKey(CacheKey.payIntent);
  }

  /** Checks whether the 'method' field has been set, however the value could be null */
  @Override
  public boolean hasMethod() {
    return genClient.cacheHasKey(CacheKey.method);
  }

  /** Checks whether the 'version' field has been set, however the value could be null */
  @Override
  public boolean hasVersion() {
    return genClient.cacheHasKey(CacheKey.version);
  }


  /**
   * Sets the field 'suppressOnScreenTips'.
   */
  public TxStartRequestMessage setSuppressOnScreenTips(java.lang.Boolean suppressOnScreenTips) {
    return genClient.setOther(suppressOnScreenTips, CacheKey.suppressOnScreenTips);
  }

  /**
   * Sets the field 'order'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public TxStartRequestMessage setOrder(com.clover.sdk.v3.order.Order order) {
    return genClient.setRecord(order, CacheKey.order);
  }

  /**
   * Sets the field 'payIntent'.
   *
   * The parameter is not copied so changes to it will be reflected in this instance and vice-versa.
   */
  public TxStartRequestMessage setPayIntent(com.clover.sdk.v3.remotemessage.PayIntent payIntent) {
    return genClient.setRecord(payIntent, CacheKey.payIntent);
  }

  /**
   * Sets the field 'method'.
   */
  @Override
  public Message setMethod(com.clover.sdk.v3.remotemessage.Method method) {
    return genClient.setOther(method, CacheKey.method);
  }

  /**
   * Sets the field 'version'.
   */
  @Override
  public Message setVersion(java.lang.Integer version) {
    return genClient.setOther(version, CacheKey.version);
  }


  /** Clears the 'suppressOnScreenTips' field, the 'has' method for this field will now return false */
  public void clearSuppressOnScreenTips() {
    genClient.clear(CacheKey.suppressOnScreenTips);
  }
  /** Clears the 'order' field, the 'has' method for this field will now return false */
  public void clearOrder() {
    genClient.clear(CacheKey.order);
  }
  /** Clears the 'payIntent' field, the 'has' method for this field will now return false */
  public void clearPayIntent() {
    genClient.clear(CacheKey.payIntent);
  }
  /** Clears the 'method' field, the 'has' method for this field will now return false */
  @Override
  public void clearMethod() {
    genClient.clear(CacheKey.method);
  }
  /** Clears the 'version' field, the 'has' method for this field will now return false */
  @Override
  public void clearVersion() {
    genClient.clear(CacheKey.version);
  }


  /**
   * Returns true if this instance has any changes.
   */
  public boolean containsChanges() {
    return genClient.containsChanges();
  }

  /**
   * Reset the log of changes made to this instance, calling copyChanges() after this would return an empty instance.
   */
  public void resetChangeLog() {
    genClient.resetChangeLog();
  }

  /**
   * Create a copy of this instance that contains only fields that were set after the constructor was called.
   */
  public TxStartRequestMessage copyChanges() {
    TxStartRequestMessage copy = new TxStartRequestMessage();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(TxStartRequestMessage src) {
    if (src.genClient.getChangeLog() != null) {
      genClient.mergeChanges(new TxStartRequestMessage(src).getJSONObject(), src.genClient);
    }
  }

  public static final android.os.Parcelable.Creator<TxStartRequestMessage> CREATOR = new android.os.Parcelable.Creator<TxStartRequestMessage>() {
    @Override
    public TxStartRequestMessage createFromParcel(android.os.Parcel in) {
      TxStartRequestMessage instance = new TxStartRequestMessage(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.genClient.setBundle(in.readBundle(getClass().getClassLoader()));
      instance.genClient.setChangeLog(in.readBundle());
      return instance;
    }

    @Override
    public TxStartRequestMessage[] newArray(int size) {
      return new TxStartRequestMessage[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<TxStartRequestMessage> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<TxStartRequestMessage>() {
    @Override
    public TxStartRequestMessage create(org.json.JSONObject jsonObject) {
      return new TxStartRequestMessage(jsonObject);
    }
  };

  public interface Constraints {

    public static final boolean SUPPRESSONSCREENTIPS_IS_REQUIRED = false;
    public static final boolean ORDER_IS_REQUIRED = false;
    public static final boolean PAYINTENT_IS_REQUIRED = false;
    public static final boolean METHOD_IS_REQUIRED = false;
    public static final boolean VERSION_IS_REQUIRED = false;

  }

}
