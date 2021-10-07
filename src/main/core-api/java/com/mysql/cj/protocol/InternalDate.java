/*
 * Copyright (c) 2019, 2020, Oracle and/or its affiliates.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License, version 2.0, as published by the
 * Free Software Foundation.
 *
 * This program is also distributed with certain software (including but not
 * limited to OpenSSL) that is licensed under separate terms, as designated in a
 * particular file or component or in included license documentation. The
 * authors of MySQL hereby grant you an additional permission to link the
 * program and your derivative works with the separately licensed software that
 * they have included with MySQL.
 *
 * Without limiting anything contained in the foregoing, this file, which is
 * part of MySQL Connector/J, is also subject to the Universal FOSS Exception,
 * version 1.0, a copy of which can be found at
 * http://oss.oracle.com/licenses/universal-foss-exception.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License, version 2.0,
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110-1301  USA
 */

package com.mysql.cj.protocol;

import java.time.YearMonth;

public class InternalDate {

    protected int year = 0;
    protected int month = 0;
    protected int day = 0;

    /**
     * Constructs a zero date.
     */
    public InternalDate() {
    }

    public InternalDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isZero() {
        return this.year == 0 && this.month == 0 && this.day == 0;
    }

    public boolean isInvalid() {
        // Apparently 0 year is not allowed and will blow up further up the stack
        if (this.year <= 0 && !isZero()) {
            return true;
        }
        if (this.month == 0 || this.month > 12) {
            return true;
        }
        if (this.day == 0) {
            return true;
        }
        YearMonth ym = YearMonth.of(this.year, this.month);
        return !ym.isValidDay(day);
    }

    public InternalDate roundedDate() {
        int year = Math.max(this.year, 1);
        int month = this.month == 0 ? 1: this.month;
        int day = this.day = this.day == 0 ? 1 : this.day;
        YearMonth ym = YearMonth.of(year, month);
        if (!ym.isValidDay(day)) {
            day = ym.lengthOfMonth();
        }

        return new InternalDate(year, month, day);
    }

    @Override
    public String toString() {
        return "InternalDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
