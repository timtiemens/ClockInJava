/*========================================================================
 * Clock.java
 * May 16, 2011 11:05:47 PM | ttiemens
 * Copyright (c) 2011 Tim Tiememsn
 *========================================================================
 * This file is part of ClockInJava.
 *
 *    ClockInJava is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    ClockInJava is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with ClockInJava.  If not, see <http://www.gnu.org/licenses/>.
 */
package tiemens.clock.complex.clockrunner;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ClockRunnerConfig
{
    private boolean counterMode = false;
    private String counterTimeTarget = null;
    private String counterInputPattern = null;
    private boolean useLocalTime;
    private Integer timezoneHours = 0;
    private Integer timezoneMinutes = 0;
    private String  displayPattern = "yyyy-MM-dd HH:mm:ss";

    // dependent
    private TimeZone tz;
    private DateFormat formatter;

    //
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int SECONDS_IN_HOUR = SECONDS_IN_MINUTE * MINUTES_IN_HOUR;
    private static final int MILLISECONDS_PER_SECOND = 1000;
    private static final int HOURS_IN_DAY = 24;
    private static final int DAYS_IN_MONTH = 31; // yeah, this is wrong
    private static final int SECONDS_IN_MONTH = SECONDS_IN_HOUR * 
                                                HOURS_IN_DAY *
                                                DAYS_IN_MONTH;
    private static final int DAYS_IN_YEAR = 365; // this too
    private static final int SECONDS_IN_DAY = SECONDS_IN_HOUR * HOURS_IN_DAY;
    private static final int SECONDS_IN_YEAR = SECONDS_IN_DAY *
                                               DAYS_IN_YEAR;
    
    
    public static ClockRunnerConfig createTest()
    {
        ClockRunnerConfig ret = new ClockRunnerConfig();

        // if true, "counter mode"
        ret.setCounterMode(false);
     
        // target time for counter            
        ret.counterTimeTarget = "2012-01-01 00:00:00";

        // input pattern for p_counter_time
        ret.counterInputPattern = "yyyy-MM-dd HH:mm:ss";

        
        // if true use local timezone
        ret.setUseLocalTime(true);
    
        // This is the hours offset to add to UTC to get local time.
//        ret.timezoneHours = null;
        // This is the minutes offset to add to UTC to get local time.        
//        ret.timezoneMinutes = null;
            
        
        // display pattern
        ret.setDisplayPattern("yyyy-MM-dd HH:mm:ss");
        
        //background color (RRGGBB)
        //ret.p_background_color = new Color(255, 255, 255,);
        //ret.p_background_image = null;
        
        return ret;
    }

    public String formatPerConfig(final long millisecondsSinceEpoch)
    {
        final Date now = new java.util.Date(millisecondsSinceEpoch);
        
        if (counterMode) 
        { 
            //counter mode
            SimpleDateFormat target_formatter = new SimpleDateFormat(counterInputPattern);
            target_formatter.setLenient(true); //make parsing tollerant
            target_formatter.setTimeZone(tz); //set timezone
            Date dtarget = new Date();
            try 
            {
                dtarget = target_formatter.parse(counterTimeTarget,
                                                 new ParsePosition(0)); 
            }
            catch (NullPointerException e) 
            {
            }
            
            //convert time_diff to selected display pattern
            return millisecToPattern(now.getTime() - dtarget.getTime());
        }
        else 
        {
            return formatter.format(now);
        }
    }
    
    public boolean isCounterMode()
    {
        return counterMode;
    }

    public void setCounterMode(boolean counterMode)
    {
        this.counterMode = counterMode;
    }

    public boolean isUseLocalTime()
    {
        return useLocalTime;
    }

    public void setUseLocalTime(boolean useLocalTime)
    {
        this.useLocalTime = useLocalTime;
        if (this.useLocalTime)
        {
            this.tz = TimeZone.getDefault(); //get local timezone
        }
        else 
        { // Set offset to add to UTC to get local time.
            this.tz = TimeZone.getTimeZone("GMT");
            int offsetMillis = ( (timezoneHours * SECONDS_IN_HOUR) +
                                 (timezoneMinutes * SECONDS_IN_MINUTE)) * 
                                 MILLISECONDS_PER_SECOND;
            this.tz.setRawOffset(offsetMillis);
            updateFormatter();
        }
    }

    public String getDisplayPattern()
    {
        return displayPattern;
    }

    public void setDisplayPattern(String displayPattern)
    {
        this.displayPattern = displayPattern;
        updateFormatter();
    }
    private void updateFormatter()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(displayPattern);
        sdf.setTimeZone(tz);
        
        this.formatter = sdf;
    }
    
    
    
    /**
     * THIS IS COMPLETELY WRONG.  There may be a way to salvage it.
     * 
     * Convert milliseconds to date pattern format.
     * @param millisecs time to convert (milliseconds)
     * @return String representation of time
     */
    private String millisecToPattern(long millisecs) 
    {
        
        String tmpstr;
        String tmppattern = displayPattern;
        
        long seconds = millisecs / 1000;
        
        if (counterMode)
        {
            //add +/- symbol by case
            if (seconds > 0) 
            {
                tmppattern = "+" + tmppattern;
            }
            else 
            {
                if (seconds < 0) 
                {
                    tmppattern = "-" + tmppattern;
                }
                else 
                {
                    tmppattern = " " + tmppattern;
                }
            }
        }
        
        seconds = Math.abs(seconds); //consider absolute value
        
        char[] pattern = tmppattern.toCharArray();
        
        //calculate time parts (replace pattern with values)
        
        // YEARS
        if (tmppattern.indexOf('y') >= 0) 
        {
            int years = (int) (seconds / SECONDS_IN_YEAR);
            seconds = seconds % SECONDS_IN_YEAR;
            tmpstr = String.valueOf(years);
            int j = tmpstr.length() - 1;
            for (int i = tmppattern.lastIndexOf('y'); i >= tmppattern.indexOf('y'); i--) 
            {
                if (j >= 0) 
                {
                    pattern[i] = tmpstr.charAt(j);
                    j--;
                }
                else 
                {
                    pattern[i] = '0';
                }
            }
        }
        
        // MONTHS
        if (tmppattern.indexOf('M') >= 0) 
        {
            int months = (int) (seconds / SECONDS_IN_MONTH);
            seconds = seconds % SECONDS_IN_MONTH;
            tmpstr = String.valueOf(months);
            int j = tmpstr.length() - 1;
            for (int i = tmppattern.lastIndexOf('M'); i >= tmppattern.indexOf('M'); i--) 
            {
                if (j >= 0) 
                {
                    pattern[i] = tmpstr.charAt(j);
                    j--;
                }
                else 
                {
                    pattern[i] = '0';
                }
            }
        }
        
        // DAYS
        if (tmppattern.indexOf('d') >= 0) 
        {
            int days = (int) (seconds / SECONDS_IN_DAY);
            seconds = seconds % SECONDS_IN_DAY;
            tmpstr = String.valueOf(days);
            int j = tmpstr.length() - 1;
            for (int i = tmppattern.lastIndexOf('d'); i >= tmppattern.indexOf('d'); i--) 
            {
                if (j >= 0) 
                {
                    pattern[i] = tmpstr.charAt(j);
                    j--;
                }
                else {
                    pattern[i] = '0';
                }
            }
        }
        
        // HOURS
        if (tmppattern.indexOf('H') >= 0) 
        {
            int hours = (int) (seconds / SECONDS_IN_HOUR);
            seconds = seconds % SECONDS_IN_HOUR;
            tmpstr = String.valueOf(hours);
            int j = tmpstr.length() - 1;
            for (int i = tmppattern.lastIndexOf('H'); i >= tmppattern.indexOf('H'); i--) 
            {
                if (j >= 0) 
                {
                    pattern[i] = tmpstr.charAt(j);
                    j--;
                }
                else 
                {
                    pattern[i] = '0';
                }
            }
        }
        
        // MINUTES
        if (tmppattern.indexOf('m') >= 0) 
        {
            int minutes = (int) (seconds / SECONDS_IN_MINUTE);
            seconds = seconds % SECONDS_IN_MINUTE;
            tmpstr = String.valueOf(minutes);
            int j = tmpstr.length() - 1;
            for (int i = tmppattern.lastIndexOf('m'); i >= tmppattern.indexOf('m'); i--) 
            {
                if (j >= 0) 
                {
                    pattern[i] = tmpstr.charAt(j);
                    j--;
                }
                else 
                {
                    pattern[i] = '0';
                }
            }
        }
        
        // SECONDS
        if (tmppattern.indexOf('s') >= 0) 
        {
            tmpstr = String.valueOf(seconds);
            int j = tmpstr.length() - 1;
            for (int i = tmppattern.lastIndexOf('s'); i >= tmppattern.indexOf('s'); i--) 
            {
                if (j >= 0) 
                {
                    pattern[i] = tmpstr.charAt(j);
                    j--;
                }
                else 
                {
                    pattern[i] = '0';
                }
            }
        }
        
        return new String(pattern);
    }    
}
