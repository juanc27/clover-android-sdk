/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */


/*
 * Copyright (C) 2013 Clover Network, Inc.
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

package com.clover.sdk.v3.payments;

@SuppressWarnings("all")
public final class CardTransaction implements android.os.Parcelable, com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

  public com.clover.sdk.v3.payments.CardType getCardType() {
    return cacheGet(CacheKey.cardType);
  }
  public com.clover.sdk.v3.payments.CardEntryType getEntryType() {
    return cacheGet(CacheKey.entryType);
  }
 /**
   * The last four digits of the credit card number
  */
  public java.lang.String getLast4() {
    return cacheGet(CacheKey.last4);
  }
  public com.clover.sdk.v3.payments.CardTransactionType getType() {
    return cacheGet(CacheKey.type);
  }
 /**
   * Authorization code (if successful)
  */
  public java.lang.String getAuthCode() {
    return cacheGet(CacheKey.authCode);
  }
  public java.lang.String getReferenceId() {
    return cacheGet(CacheKey.referenceId);
  }
  public com.clover.sdk.v3.payments.CardTransactionState getState() {
    return cacheGet(CacheKey.state);
  }
 /**
   * Extra info to be stored as part of gateway/card transaction
  */
  public java.util.Map<java.lang.String,java.lang.String> getExtra() {
    return cacheGet(CacheKey.extra);
  }


  private enum CacheKey {
    cardType {
      @Override
      public Object extractValue(CardTransaction instance) {
        return instance.extractCardType();
      }
    },
    entryType {
      @Override
      public Object extractValue(CardTransaction instance) {
        return instance.extractEntryType();
      }
    },
    last4 {
      @Override
      public Object extractValue(CardTransaction instance) {
        return instance.extractLast4();
      }
    },
    type {
      @Override
      public Object extractValue(CardTransaction instance) {
        return instance.extractType();
      }
    },
    authCode {
      @Override
      public Object extractValue(CardTransaction instance) {
        return instance.extractAuthCode();
      }
    },
    referenceId {
      @Override
      public Object extractValue(CardTransaction instance) {
        return instance.extractReferenceId();
      }
    },
    state {
      @Override
      public Object extractValue(CardTransaction instance) {
        return instance.extractState();
      }
    },
    extra {
      @Override
      public Object extractValue(CardTransaction instance) {
        return instance.extractExtra();
      }
    },
    ;

    public abstract Object extractValue(CardTransaction instance);
  }

  private org.json.JSONObject jsonObject = null;
  private android.os.Bundle bundle = null;
  private android.os.Bundle changeLog = null;
  private Object[] cache = null;
  private byte[] cacheState = null;

  private static final byte STATE_NOT_CACHED = 0;
  private static final byte STATE_CACHED_NO_VALUE = 1;
  private static final byte STATE_CACHED_VALUE = 2;

  /**
   * Constructs a new empty instance.
   */
  public CardTransaction() { }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public CardTransaction(String json) throws java.lang.IllegalArgumentException {
    try {
      this.jsonObject = new org.json.JSONObject(json);
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException("invalid json", e);
    }
  }

  /**
   * Construct a new instance backed by the given JSONObject, the parameter is not copied so changes to it will be
   * reflected in this instance and vice-versa.
   */
  public CardTransaction(org.json.JSONObject jsonObject) {
    this.jsonObject = jsonObject;
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public CardTransaction(CardTransaction src) {
    if (src.jsonObject != null) {
      this.jsonObject = com.clover.sdk.v3.JsonHelper.deepCopy(src.getJSONObject());
    }
  }

  private <T> T cacheGet(CacheKey key) {
    int index = key.ordinal();
    populateCache(index);
    return (T) cache[index];
  }

  private boolean cacheValueIsNotNull(CacheKey key) {
    int index = key.ordinal();
    populateCache(index);
    return cache[index] != null;
  }

  private boolean cacheHasKey(CacheKey key) {
    int index = key.ordinal();
    populateCache(index);
    return cacheState[index] == STATE_CACHED_VALUE;
  }

  private void cacheRemoveValue(CacheKey key) {
    int index = key.ordinal();
    populateCache(index);
    cache[index] = null;
    cacheState[index] = STATE_CACHED_NO_VALUE;
  }

  private void cacheMarkDirty(CacheKey key) {
    if (cache != null) {
      int index = key.ordinal();
      cache[index] = null;
      cacheState[index] = STATE_NOT_CACHED;
    }
  }

  private void populateCache(int index) {
    if (cache == null) {
      int size = CacheKey.values().length;
      cache = new Object[size];
      cacheState = new byte[size];
    }

    if (cacheState[index] == STATE_NOT_CACHED) {
      CacheKey key = CacheKey.values()[index];

      if (getJSONObject().has(key.name())) {
        cache[index] = key.extractValue(this);
        cacheState[index] = STATE_CACHED_VALUE;
      } else {
        cacheState[index] = STATE_CACHED_NO_VALUE;
      }
    }
  }

  /**
   * Returns the internal JSONObject backing this instance, the return value is not a copy so changes to it will be
   * reflected in this instance and vice-versa.
   */
  public org.json.JSONObject getJSONObject() {
    if (jsonObject == null) {
      jsonObject = new org.json.JSONObject();
    }
    return jsonObject;
  }


  @Override
  public void validate() {

    java.lang.String authCode = getAuthCode();
    if (authCode != null && authCode.length() > 255) { throw new IllegalArgumentException("Maximum string length exceeded for 'authCode'");}

    java.lang.String referenceId = getReferenceId();
    if (referenceId != null && referenceId.length() > 32) { throw new IllegalArgumentException("Maximum string length exceeded for 'referenceId'");}
  }



  private com.clover.sdk.v3.payments.CardType extractCardType() {
    if (!getJSONObject().isNull("cardType")) {
      try {
        return com.clover.sdk.v3.payments.CardType.valueOf(getJSONObject().optString("cardType"));
      } catch(Exception e) {
        e.printStackTrace();
      }
    }

    return null;
  }


  private com.clover.sdk.v3.payments.CardEntryType extractEntryType() {
    if (!getJSONObject().isNull("entryType")) {
      try {
        return com.clover.sdk.v3.payments.CardEntryType.valueOf(getJSONObject().optString("entryType"));
      } catch(Exception e) {
        e.printStackTrace();
      }
    }

    return null;
  }


  private java.lang.String extractLast4() {
    return getJSONObject().isNull("last4") ? null :
      getJSONObject().optString("last4");
  }


  private com.clover.sdk.v3.payments.CardTransactionType extractType() {
    if (!getJSONObject().isNull("type")) {
      try {
        return com.clover.sdk.v3.payments.CardTransactionType.valueOf(getJSONObject().optString("type"));
      } catch(Exception e) {
        e.printStackTrace();
      }
    }

    return null;
  }


  private java.lang.String extractAuthCode() {
    return getJSONObject().isNull("authCode") ? null :
      getJSONObject().optString("authCode");
  }


  private java.lang.String extractReferenceId() {
    return getJSONObject().isNull("referenceId") ? null :
      getJSONObject().optString("referenceId");
  }


  private com.clover.sdk.v3.payments.CardTransactionState extractState() {
    if (!getJSONObject().isNull("state")) {
      try {
        return com.clover.sdk.v3.payments.CardTransactionState.valueOf(getJSONObject().optString("state"));
      } catch(Exception e) {
        e.printStackTrace();
      }
    }

    return null;
  }


  private java.util.Map<java.lang.String,java.lang.String> extractExtra() {
    if (getJSONObject().isNull("extra")) return null;
    org.json.JSONObject object = getJSONObject().optJSONObject("extra");
    return com.clover.sdk.v3.JsonHelper.toMap(object);
  }


  /** Checks whether the 'cardType' field is set and is not null */
  public boolean isNotNullCardType() {
    return cacheValueIsNotNull(CacheKey.cardType);
  }

  /** Checks whether the 'entryType' field is set and is not null */
  public boolean isNotNullEntryType() {
    return cacheValueIsNotNull(CacheKey.entryType);
  }

  /** Checks whether the 'last4' field is set and is not null */
  public boolean isNotNullLast4() {
    return cacheValueIsNotNull(CacheKey.last4);
  }

  /** Checks whether the 'type' field is set and is not null */
  public boolean isNotNullType() {
    return cacheValueIsNotNull(CacheKey.type);
  }

  /** Checks whether the 'authCode' field is set and is not null */
  public boolean isNotNullAuthCode() {
    return cacheValueIsNotNull(CacheKey.authCode);
  }

  /** Checks whether the 'referenceId' field is set and is not null */
  public boolean isNotNullReferenceId() {
    return cacheValueIsNotNull(CacheKey.referenceId);
  }

  /** Checks whether the 'state' field is set and is not null */
  public boolean isNotNullState() {
    return cacheValueIsNotNull(CacheKey.state);
  }

  /** Checks whether the 'extra' field is set and is not null */
  public boolean isNotNullExtra() {
    return cacheValueIsNotNull(CacheKey.extra);
  }

  /** Checks whether the 'extra' field is set and is not null and is not empty */
  public boolean isNotEmptyExtra() {
    return isNotNullExtra() && !getExtra().isEmpty();
  }


  /** Checks whether the 'cardType' field has been set, however the value could be null */
  public boolean hasCardType() {
    return cacheHasKey(CacheKey.cardType);
  }

  /** Checks whether the 'entryType' field has been set, however the value could be null */
  public boolean hasEntryType() {
    return cacheHasKey(CacheKey.entryType);
  }

  /** Checks whether the 'last4' field has been set, however the value could be null */
  public boolean hasLast4() {
    return cacheHasKey(CacheKey.last4);
  }

  /** Checks whether the 'type' field has been set, however the value could be null */
  public boolean hasType() {
    return cacheHasKey(CacheKey.type);
  }

  /** Checks whether the 'authCode' field has been set, however the value could be null */
  public boolean hasAuthCode() {
    return cacheHasKey(CacheKey.authCode);
  }

  /** Checks whether the 'referenceId' field has been set, however the value could be null */
  public boolean hasReferenceId() {
    return cacheHasKey(CacheKey.referenceId);
  }

  /** Checks whether the 'state' field has been set, however the value could be null */
  public boolean hasState() {
    return cacheHasKey(CacheKey.state);
  }

  /** Checks whether the 'extra' field has been set, however the value could be null */
  public boolean hasExtra() {
    return cacheHasKey(CacheKey.extra);
  }


  /**
   * Sets the field 'cardType'.
   */
  public CardTransaction setCardType(com.clover.sdk.v3.payments.CardType cardType) {
    logChange("cardType");

    try {
      getJSONObject().put("cardType", cardType == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(cardType));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.cardType);
    return this;
  }

  /**
   * Sets the field 'entryType'.
   */
  public CardTransaction setEntryType(com.clover.sdk.v3.payments.CardEntryType entryType) {
    logChange("entryType");

    try {
      getJSONObject().put("entryType", entryType == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(entryType));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.entryType);
    return this;
  }

  /**
   * Sets the field 'last4'.
   */
  public CardTransaction setLast4(java.lang.String last4) {
    logChange("last4");

    try {
      getJSONObject().put("last4", last4 == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(last4));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.last4);
    return this;
  }

  /**
   * Sets the field 'type'.
   */
  public CardTransaction setType(com.clover.sdk.v3.payments.CardTransactionType type) {
    logChange("type");

    try {
      getJSONObject().put("type", type == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(type));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.type);
    return this;
  }

  /**
   * Sets the field 'authCode'.
   */
  public CardTransaction setAuthCode(java.lang.String authCode) {
    logChange("authCode");

    try {
      getJSONObject().put("authCode", authCode == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(authCode));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.authCode);
    return this;
  }

  /**
   * Sets the field 'referenceId'.
   */
  public CardTransaction setReferenceId(java.lang.String referenceId) {
    logChange("referenceId");

    try {
      getJSONObject().put("referenceId", referenceId == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(referenceId));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.referenceId);
    return this;
  }

  /**
   * Sets the field 'state'.
   */
  public CardTransaction setState(com.clover.sdk.v3.payments.CardTransactionState state) {
    logChange("state");

    try {
      getJSONObject().put("state", state == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(state));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.state);
    return this;
  }

  /**
   * Sets the field 'extra'.
   */
  public CardTransaction setExtra(java.util.Map<java.lang.String,java.lang.String> extra) {
    logChange("extra");

    try {
      getJSONObject().put("extra", extra == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(extra));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.extra);
    return this;
  }


  /** Clears the 'cardType' field, the 'has' method for this field will now return false */
  public void clearCardType() {
    unlogChange("cardType");
    getJSONObject().remove("cardType");
    cacheRemoveValue(CacheKey.cardType);
  }

  /** Clears the 'entryType' field, the 'has' method for this field will now return false */
  public void clearEntryType() {
    unlogChange("entryType");
    getJSONObject().remove("entryType");
    cacheRemoveValue(CacheKey.entryType);
  }

  /** Clears the 'last4' field, the 'has' method for this field will now return false */
  public void clearLast4() {
    unlogChange("last4");
    getJSONObject().remove("last4");
    cacheRemoveValue(CacheKey.last4);
  }

  /** Clears the 'type' field, the 'has' method for this field will now return false */
  public void clearType() {
    unlogChange("type");
    getJSONObject().remove("type");
    cacheRemoveValue(CacheKey.type);
  }

  /** Clears the 'authCode' field, the 'has' method for this field will now return false */
  public void clearAuthCode() {
    unlogChange("authCode");
    getJSONObject().remove("authCode");
    cacheRemoveValue(CacheKey.authCode);
  }

  /** Clears the 'referenceId' field, the 'has' method for this field will now return false */
  public void clearReferenceId() {
    unlogChange("referenceId");
    getJSONObject().remove("referenceId");
    cacheRemoveValue(CacheKey.referenceId);
  }

  /** Clears the 'state' field, the 'has' method for this field will now return false */
  public void clearState() {
    unlogChange("state");
    getJSONObject().remove("state");
    cacheRemoveValue(CacheKey.state);
  }

  /** Clears the 'extra' field, the 'has' method for this field will now return false */
  public void clearExtra() {
    unlogChange("extra");
    getJSONObject().remove("extra");
    cacheRemoveValue(CacheKey.extra);
  }


  private void logChange(java.lang.String field) {
    if (changeLog == null) {
      changeLog = new android.os.Bundle();
    }
    changeLog.putString(field, null);
  }

  private void unlogChange(java.lang.String field) {
    if (changeLog != null) {
      changeLog.remove(field);
    }
  }

  /**
   * Returns true if this instance has any changes.
   */
  public boolean containsChanges() {
    return changeLog != null;
  }

  /**
   * Reset the log of changes made to this instance, calling copyChanges() after this would return an empty instance.
   */
  public void resetChangeLog() {
    changeLog = null;
  }

  /**
   * Create a copy of this instance that contains only fields that were set after the constructor was called.
   */
  public CardTransaction copyChanges() {
    CardTransaction copy = new CardTransaction();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(CardTransaction src) {
    if (src.changeLog != null) {
      try {
        // Make a copy of the source so the destination fields are copies
        org.json.JSONObject srcObj = new CardTransaction(src).getJSONObject();
        org.json.JSONObject dstObj = getJSONObject();
        for (java.lang.String field : src.changeLog.keySet()) {
          dstObj.put(field, srcObj.get(field));
          logChange(field);
        }
      } catch (org.json.JSONException e) {
        throw new java.lang.IllegalArgumentException(e);
      }
    }
  }


  /**
   * Gets a Bundle which can be used to get and set data attached to this instance. The attached Bundle will be
   * parcelled but not jsonified.
   */
  public android.os.Bundle getBundle() {
    if (bundle == null) {
      bundle = new android.os.Bundle();
    }
    return bundle;
  }

  @Override
  public String toString() {
    String json = getJSONObject().toString();

    if (bundle != null) {
      bundle.isEmpty(); // Triggers unparcel
    }

    if (changeLog != null) {
      changeLog.isEmpty(); // Triggers unparcel
    }

    return "CardTransaction{" +
        "json='" + json + "'" +
        ", bundle=" + bundle +
        ", changeLog=" + changeLog +
        '}';
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(android.os.Parcel dest, int flags) {
	  com.clover.sdk.v3.JsonParcelHelper.wrap(getJSONObject()).writeToParcel(dest, 0);
    dest.writeBundle(bundle);
    dest.writeBundle(changeLog);
  }

  public static final android.os.Parcelable.Creator<CardTransaction> CREATOR = new android.os.Parcelable.Creator<CardTransaction>() {
    @Override
    public CardTransaction createFromParcel(android.os.Parcel in) {
      CardTransaction instance = new CardTransaction(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.bundle = in.readBundle(getClass().getClassLoader());
      instance.changeLog = in.readBundle();
      return instance;
    }

    @Override
    public CardTransaction[] newArray(int size) {
      return new CardTransaction[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<CardTransaction> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<CardTransaction>() {
    @Override
    public CardTransaction create(org.json.JSONObject jsonObject) {
      return new CardTransaction(jsonObject);
    }
  };


  public interface Constraints {

    public static final boolean CARDTYPE_IS_REQUIRED = false;

    public static final boolean ENTRYTYPE_IS_REQUIRED = false;

    public static final boolean LAST4_IS_REQUIRED = false;

    public static final boolean TYPE_IS_REQUIRED = false;

    public static final boolean AUTHCODE_IS_REQUIRED = false;
    public static final long AUTHCODE_MAX_LEN = 255;

    public static final boolean REFERENCEID_IS_REQUIRED = false;
    public static final long REFERENCEID_MAX_LEN = 32;

    public static final boolean STATE_IS_REQUIRED = false;

    public static final boolean EXTRA_IS_REQUIRED = false;

  }

}
