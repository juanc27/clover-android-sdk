/**
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
package com.clover.sdk.v1.printer.job;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.clover.sdk.v1.Intents;
import com.clover.sdk.v1.printer.Category;
import com.clover.sdk.v1.printer.Printer;
import com.clover.sdk.v1.printer.PrinterIntent;

/**
 * Base class for print jobs. Flags may be added to a PrintJob to alter the results. Subclasses may
 * automatically add some flags. Some flags are incompatible.
 */
public abstract class PrintJob implements Parcelable {
  private static final String SERVICE_HOST = "com.clover.engine";

  public static final int FLAG_NONE = 0;
  /** Indicate this is a reprint on the print out */
  public static final int FLAG_REPRINT = 1 << 0;
  /** Indicate this print out is a bill of sale, transaction such as payments will not print out */
  public static final int FLAG_BILL = 1 << 1;
  @Deprecated
  public static final int FLAG_SALE = 1 << 2;
  /** Indicate this print job is for a refund, additional refund information will be included on print out */
  public static final int FLAG_REFUND = 1 << 3;
  /** Do not show customer signature line on print out even if normally required */
  public static final int FLAG_NO_SIGNATURE = 1 << 4;
  /** Force customer signature line on print out even if normally not required */
  public static final int FLAG_FORCE_SIGNATURE = 1 << 5;
  /** Print receipt for the customer with appropriate verbiage and without signature line */
  public static final int FLAG_CUSTOMER = 1 << 6;
  /** Print receipt for the merchant with signature line if required*/
  public static final int FLAG_MERCHANT = 1 << 7;

  public abstract static class Builder {
    protected int flags = FLAG_NONE;
    protected boolean printToAny = false;

    public Builder printJob(PrintJob pj) {
      this.flags = pj.flags;
      this.printToAny = pj.printToAny;

      return this;
    }

    /**
     * DEPRECATED: override all flags with given value.
     */
    @Deprecated
    public Builder flags(int flags) {
      this.flags = flags;
      return this;
    }

    /**
     * Appends a flag to this PrintJob.
     */
    public Builder flag(int flag) {
      this.flags |= flag;
      return this;
    }

    /**
     * Indicate that this job should be printed to any available printer in case the default is
     * not available. Defaults to false.
     */
    public Builder printToAny(boolean printToAny) {
      this.printToAny = printToAny;
      return this;
    }

    public abstract PrintJob build();
  }

  private static final String BUNDLE_KEY_FLAGS = "f";
  private static final String BUNDLE_KEY_PRINT_TO_ANY = "pta";

  public final int flags;

  /**
   * Indicate that this job should be printed to any available printer in case the default is
   * not available. Defaults to false.
   */
  public final boolean printToAny;

  @Deprecated
  protected PrintJob(int flags) {
    this.flags = flags;
    this.printToAny = false;
  }

  protected PrintJob(Builder builder) {
    this.flags = builder.flags;
    this.printToAny = builder.printToAny;
  }

  public abstract Category getPrinterCategory();

  /**
   * Send this PrintJob to the default printer.
   */
  public void print(Context context, Account account) {
    print(context, account, null);
  }

  /**
   * Send this PrintJob to the specified printer.
   */
  public void print(Context context, Account account, Printer printer) {
    Intent intent = new Intent(PrinterIntent.ACTION_PRINT_SERVICE);
    intent.putExtra(PrinterIntent.EXTRA_PRINTJOB, this);
    intent.putExtra(Intents.EXTRA_ACCOUNT, account);
    intent.putExtra(PrinterIntent.EXTRA_PRINTER, printer);
    intent.setPackage(SERVICE_HOST);
    context.startService(intent);
  }

  public void cancel() {
  }

  protected PrintJob(Parcel in) {
    Bundle bundle = in.readBundle(((Object)this).getClass().getClassLoader());
    flags = bundle.getInt(BUNDLE_KEY_FLAGS);
    printToAny = bundle.getBoolean(BUNDLE_KEY_PRINT_TO_ANY);
    // Add more data here, but remember old apps might not provide it!
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int f) {
    Bundle bundle = new Bundle();
    bundle.putInt(BUNDLE_KEY_FLAGS, this.flags);
    bundle.putBoolean(BUNDLE_KEY_PRINT_TO_ANY, this.printToAny);
    // Add more stuff here

    dest.writeBundle(bundle);
  }

}
